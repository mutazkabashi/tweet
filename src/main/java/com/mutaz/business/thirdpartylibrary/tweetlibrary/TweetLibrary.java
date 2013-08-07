package com.mutaz.business.thirdpartylibrary.tweetlibrary;

import java.util.List;

import com.mutaz.business.pojo.Tweet;

public interface TweetLibrary {

	public List<Tweet> getHomeTimeline();
	
	public void setUserAccountInfo(String userName,String password);

}
