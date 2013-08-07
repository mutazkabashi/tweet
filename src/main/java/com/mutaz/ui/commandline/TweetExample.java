package com.mutaz.ui.commandline;

import java.util.ArrayList;
import java.util.ResourceBundle;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.service.TwitterTweetService;
import com.mutaz.di.guice.ObjectInjector;

public class TweetExample {
	
	private static  ResourceBundle configFile = ResourceBundle.getBundle("twitterConfig");
	
	public static void main(String[] args) {
		
		Injector injector =
				Guice.createInjector(new ObjectInjector());
		
		TwitterTweetService service =
				injector.getInstance(TwitterTweetService.class);
		String userName = configFile.getString("userName");
		String password = configFile.getString("password");
		ArrayList<Tweet> timeLineTweets=(ArrayList<Tweet>) service.getHomeTimeLineTweets(userName,password );
       service.saveTweets(timeLineTweets);
        ArrayList<Tweet> topRetweetTweets = (ArrayList<Tweet>) service.getTopTweets(5);
        ArrayList<Tweet> topFavouriteTweets = (ArrayList<Tweet>) service.getTopFavouriteTweets(5);
        System.out.println("Top Retweet Tweets");
        System.out.println("ID "+"  "+"RetweetCount"+"  "+"UserName"+"  "+"Text");
       for (Tweet tweet : topRetweetTweets) {
		System.out.println(tweet.getId() +"    "+tweet.getRetweetCount()+"     "+tweet.getUserName()+"     "+tweet.getText());
       }
        
        
        System.out.println("Top Faviourite Tweets");
        System.out.println("ID "+"  "+"FavoriteCount"+"  "+"UserName"+"  "+"Text");
       for (Tweet tweet : topFavouriteTweets) {
		System.out.println(tweet.getId() +"    "+tweet.getFavoriteCount()+"     "+tweet.getUserName()+"     "+tweet.getText());
	}

	}

}
