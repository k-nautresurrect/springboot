package com.nagarro.minijava2.services;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.minijava2.Entity.User;
import com.nagarro.minijava2.Model.Gender;
import com.nagarro.minijava2.Model.Nationality;
import com.nagarro.minijava2.Model.UserInfo;
import com.nagarro.minijava2.Repository.UserRepository;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;


import java.time.Duration;

import reactor.netty.http.client.HttpClient;

@Service
public class UserService {

	private final WebClient randomUserWebClient;
	private final WebClient nationalizeWebClient;
	private final WebClient genderizeWebClient;
	private final UserRepository userRepository;

	public UserService(WebClient.Builder webClientBuilder, UserRepository userRepository) {

		TcpClient tcpClient = TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000).doOnConnected(
				conn -> conn.addHandlerLast(new ReadTimeoutHandler(2)).addHandlerLast(new WriteTimeoutHandler(2)));

		this.randomUserWebClient = webClientBuilder.baseUrl("https://randomuser.me/api/")
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient))).build();

		this.nationalizeWebClient = webClientBuilder.baseUrl("https://api.nationalize.io")
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient))).build();

		this.genderizeWebClient = webClientBuilder.baseUrl("https://api.genderize.io")
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient))).build();

		this.userRepository = userRepository;
	}

	@Transactional
	public void postUsers(int n) {
		if (n <= 0 || n > 5) {
			throw new IllegalArgumentException("Invalid value for n. It should be in the range (0, 5].");
		}

		Flux.range(1, n).flatMap(i -> randomUserWebClient.get().uri("/").retrieve().bodyToMono(UserInfo.class)
				.map(response -> response.getResults()).flatMapMany(Flux::fromIterable).flatMap(result -> {
					System.out.println("result Response: " + result);
					User userEntity = new User();
					userEntity.setFirstName(result.getName().getFirst());
					userEntity.setLastName(result.getName().getLast());
					userEntity.setGender(result.getGender());
					userEntity.setNationality(result.getNat());
					userEntity.setAge(result.getDob().getAge());

					Mono<Void> verificationMono = Mono.when(verifyNationality(userEntity), verifyGender(userEntity));

					return verificationMono.then(Mono.fromRunnable(() -> userRepository.save(userEntity)));
				})).timeout(Duration.ofSeconds(60)).subscribe();
	}

	private Mono<Void> verifyNationality(User userEntity) {
		return nationalizeWebClient.get().uri("/?name={name}", userEntity.getFirstName()).retrieve()
				.bodyToMono(Nationality.class).onErrorResume(throwable -> {

					System.err.println("Error during Nationality verification: " + throwable.getMessage());
					return Mono.empty();
				}).doOnNext(response -> {
					if (response != null && response.getCountry() != null && !response.getCountry().isEmpty()) {

						System.out.println("Nationality Response: " + response);

					}
				})
				.map(response -> response != null && response.getCountry() != null && !response.getCountry().isEmpty()
						&& response.getCountry().get(0).getCountry_id().contains(userEntity.getNationality()))
				.doOnNext(verified -> setUserVerificationStatus(userEntity, verified)).then();
	}

	private Mono<Void> verifyGender(User userEntity) {
		return genderizeWebClient.get().uri("/?name={name}", userEntity.getFirstName()).retrieve()
				.bodyToMono(Gender.class).onErrorResume(throwable -> {

					System.err.println("Error during Gender verification: " + throwable.getMessage());
					return Mono.empty();
				}).doOnNext(response -> {
					if (response != null && response.getGender() != null) {

						System.out.println("Gender Response: " + response);
						System.out.println("Gender Value: " + response.getGender());
					}
				}).map(response -> {

					return response != null && response.getGender() != null
							&& response.getGender().equalsIgnoreCase(userEntity.getGender());
				}).doOnNext(verified -> setUserVerificationStatus(userEntity, verified)).then();
	}

	private void setUserVerificationStatus(User userEntity, boolean verified) {
		if (verified) {
			userEntity.setVarificationStatus("verified");
		} else {
			userEntity.setVarificationStatus("not_verified");
		}
	}
}