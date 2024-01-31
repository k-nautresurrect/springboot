package org.nagarro.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.nagarro.ratingsdataservice.models.Rating;
import org.nagarro.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/rating")
public class RatingController {
	  @RequestMapping("/{movieId}")
	    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
	        return new Rating(movieId, 4);
	    }
	  @RequestMapping("/user/{userId}")
	    public UserRating getUserRatings(@PathVariable("userId") String userId) {
		  List<Rating> ratings= (Arrays.asList(
	                new Rating("100", 3),
	                new Rating("200", 4)
	        ));
	        UserRating userRating = new UserRating();
//	        userRating.initData(userId);
	        userRating.setUserRating(ratings);
	        return userRating;

	  }
}
