package com.mutaz.business.service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.repository.TweetRepostory;
import com.mutaz.business.thirdpartylibrary.tweetlibrary.TweetLibrary;
import com.mutaz.business.thirdpartylibrary.tweetlibrary.Twitter4jTweetLibrary;

/**
 * 
 * @author mutaz hussein kabashi
 *
 */
public class TwitterTweetService implements TweetService {
	
	private TweetRepostory repository;
	private TweetLibrary  library;
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles
			.lookup().lookupClass());
	
	@Inject
	public TwitterTweetService(TweetRepostory repository,TweetLibrary library){
		logger.debug("Constructor() @TwitterTweetService Start");
		this.repository = repository;
		this.library   = library ;
		logger.debug("Repository {} ,and library {} have been initalized",this.repository,this.library);
		logger.debug("Constructor() @TwitterTweetService End");
	}
	
	public List<Tweet>  getHomeTimeLineTweets(String userName, String password){
		logger.debug("getHomeTimeLineTweets() @TwitterTweetService Start");
		library.setUserAccountInfo(userName,password);
		logger.info("User Info has been configured succefully");
		logger.debug("getHomeTimeLineTweets() @TwitterTweetService End");
		return library.getHomeTimeline();
		//return null;
	}

	public String saveTweets(List<Tweet> tweets) {
		logger.debug("saveTweets() @TwitterTweetService Start");
		repository.saveList(tweets);
		logger.info("Tweet List has been saved succefully to Data Base");
		logger.debug("saveTweets() @TwitterTweetService End");
		return "tweets have been saved succefully" ;
		
	}
	
	public List<Tweet> getTopTweets(int noOfTweets){
		logger.debug("getTopTweets() @TwitterTweetService Start");
		List <Tweet> topTweets = repository.getTopTweets(5);
		logger.debug("getTopTweets() @TwitterTweetService End");
		return topTweets;
	}

	@Override
	public List<Tweet> getTopFavouriteTweets(int noOfTweets) {
		logger.debug("getTopFavouriteTweets() @TwitterTweetService Start");
		List <Tweet> topTweets = repository.getTopFavouriteTweets(5);
		logger.debug("getTopFavouriteTweets() @TwitterTweetService End");
		return topTweets;
	}
	

}
