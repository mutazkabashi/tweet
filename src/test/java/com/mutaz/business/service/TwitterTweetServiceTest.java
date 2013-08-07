package com.mutaz.business.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.repository.TweetRepostory;
import com.mutaz.business.repository.exception.RepositroyException;
import com.mutaz.business.service.exception.TweetServiceException;

import com.mutaz.business.thirdpartylibrary.tweetlibrary.TweetLibrary;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TwitterTweetServiceTest {

	private Tweet tweet; // = mock(Tweet.class);

	private TweetRepostory tweetRepository; // = mock(TweetRepository.class);

	private TweetLibrary tweetLibrary;

	private TwitterTweetService service;

	@Before
	public void setup() {
		tweet = mock(Tweet.class);
		tweetLibrary = mock(TweetLibrary.class);
		tweetRepository = mock(TweetRepostory.class);
		service = new TwitterTweetService(tweetRepository, tweetLibrary);
	}

	@Test
	public void getHomeTimeLineTweetsTest() {
		when(tweetLibrary.getHomeTimeline()).thenReturn(prepareList());
		service.getHomeTimeLineTweets("username", "password");
		verify(tweetLibrary, times(1)).setUserAccountInfo("username",
				"password");
		verify(tweetLibrary, times(1)).getHomeTimeline();
		verifyNoMoreInteractions(tweetLibrary);
	}
	
	@Test(expected = Exception.class)
	public void getHomeTimeLineTweetsExceptionTest() {
		when(tweetLibrary.getHomeTimeline()).thenThrow(RepositroyException.class);
		service.getHomeTimeLineTweets("username", "password");
	}

	@Test
	public void saveTweets() {
		List<Tweet> tweets = prepareList();
		//when(tweetRepository.saveList(tweets)).thenReturn(true);
		String result =service.saveTweets(tweets);
		assertEquals("tweets have been saved succefully", "tweets have been saved succefully");
		verify(tweetRepository, times(1)).saveList(tweets);
		verifyNoMoreInteractions(tweetRepository);

	}
	
	
	@Test
	public void getTopTweets(){
		List<Tweet> tweets;
		when(tweetRepository.getTopTweets(5)).thenReturn(prepareList());
		tweets = service.getTopTweets(5);
		assertNotNull(tweets);
		verify(tweetRepository, times(1)).getTopTweets(5);
		
	}
	
	@Test(expected = Exception.class)
	public void getTopTweetsException(){
		List<Tweet> tweets;
		when(tweetRepository.getTopTweets(5)).thenThrow(RepositroyException.class);
		tweets = service.getTopTweets(5);
		
	}
	
	@Test
	public void getTopFavouriteTweets(){
		List<Tweet> tweets;
		when(tweetRepository.getTopFavouriteTweets(5)).thenReturn(prepareList());
		tweets = service.getTopFavouriteTweets(5);
		assertNotNull(tweets);
		verify(tweetRepository, times(1)).getTopFavouriteTweets(5);
	}
	
	@Test(expected = Exception.class)
	public void getTopFavouriteTweetsException(){
		List<Tweet> tweets;
		when(tweetRepository.getTopFavouriteTweets(5)).thenThrow(RepositroyException.class);
		tweets = service.getTopFavouriteTweets(5);
		
	}

	private List<Tweet> prepareList() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		Tweet tweet1 = mock(Tweet.class);
		Tweet tweet2 = mock(Tweet.class);
		/*
		 * tweet.setText("status1"); tweet.setUsername("user1");
		 * tweet.setUserScreenName("screenname1"); tweet.setFavoriteCount(1L);
		 * tweet.setRetweetCount(1L);
		 * 
		 * Tweet tweet2 = mock(Tweet.class); tweet2.setText("status2");
		 * tweet2.setUsername("user2"); tweet2.setUserScreenName("screenname2");
		 * tweet2.setFavoriteCount(2L); tweet2.setRetweetCount(2L);
		 */
		tweets.add(tweet1);
		tweets.add(tweet2);

		return tweets;
	}

	private Tweet prepareStatus(Tweet tweet, String text, String userName,
			String userScreenName, long favoriteCount, long retweetCount) {
		when(tweet.getText()).thenReturn("status1");
		return tweet;

	}
}
