package org.nagarro.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.nagarro.moviecatalogservice.models.CatalogItem;
import org.nagarro.moviecatalogservice.models.Movie;
import org.nagarro.moviecatalogservice.models.Rating;
import org.nagarro.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	 private static final String SERVICE_A = "serviceA";
	
	@RequestMapping("/{userId}")
	@CircuitBreaker(name = SERVICE_A,fallbackMethod="serviceAFallback" )
//	@HystrixCommand(fallbackMethod="getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
//		List <Rating> ratings =Arrays.asList(
//				new Rating("1",4));

        UserRating ratings = restTemplate.getForObject("http://rating-data-service/rating/user/" + userId, UserRating.class);

        return ratings.getUserRating().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating());
                })
                .collect(Collectors.toList());
        
//        return Collections.singletonList(
//        		new CatalogItem("transformer", "test", 4)
//        				);

    }

	  public List<CatalogItem> serviceAFallback(String userId, Throwable throwable) {
	        // Provide fallback logic here
	        return Collections.singletonList(
	                new CatalogItem("Fallback Movie", "Fallback Description", 0)
	        );
	    }
		
	}


