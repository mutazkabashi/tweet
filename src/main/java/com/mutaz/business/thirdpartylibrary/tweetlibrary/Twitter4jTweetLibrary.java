package com.mutaz.business.thirdpartylibrary.tweetlibrary;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.pojo.TwitterTweet;

public class Twitter4jTweetLibrary implements TweetLibrary {

	@Override
	public List<Tweet> getHomeTimeline() {
		Twitter twitter = TwitterFactory.getSingleton();
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	    try {
			  java.util.List<Status> statuses = twitter.getHomeTimeline(new Paging(1,100));
			  for (Status status : statuses) {
				Tweet twitterTweet = new TwitterTweet(status.getId(),status.getText(),status.getUser().getName(),status.getUser().getScreenName(),status.getFavoriteCount(),status.getRetweetCount());
				tweets.add(twitterTweet);
			}
			  return tweets;
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setUserAccountInfo(String userName, String password) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setUser("mutazhkabbashi@gmail.com");
		cb.setPassword("mutaz12345^");
		
	}

}
