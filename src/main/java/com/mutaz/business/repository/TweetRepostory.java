package com.mutaz.business.repository;

import java.util.List;

import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.repository.exception.RepositroyException;

public interface TweetRepostory {
	
	
	
	public void saveList(List<Tweet> tweets) throws RepositroyException;
	
	public List<Tweet> getTopTweets(int noOfTweets) throws RepositroyException ;
	
	public List<Tweet> getTopFavouriteTweets(int noOfTweets) throws  RepositroyException;

}
