package com.mutaz.business.service;

import java.util.List;

import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.repository.TweetRepostory;

public interface TweetService {

	public List<Tweet>  getHomeTimeLineTweets(String userName, String Password);
	
	public String saveTweets(List<Tweet> tweets);
	
	public List<Tweet> getTopTweets(int noOfTweets);
	
	public List<Tweet> getTopFavouriteTweets(int noOfTweets);

}
