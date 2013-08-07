package com.mutaz.business.repository;

import java.lang.invoke.MethodHandles;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.pojo.TwitterTweet;
import com.mutaz.business.repository.exception.RepositroyException;

public class MongoJavaDriverTwitterRepository implements TwitterTweetRepository {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles
			.lookup().lookupClass());
	private static MongoClient mongo;
	private static DB db;

	static {
		logger.debug("iniliazling Mongo Driver Start");
		try {
			mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB("tweet");
			logger.debug("iniliazling Mongo Driver End");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveList(List<Tweet> tweets) throws RepositroyException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tweet> getTopTweets(int noOfTweets) throws RepositroyException{
		logger.debug("getTopTweets()@ MongoJavaDriverTwitterRepository Start");
		try {
			List<Tweet> topTweets = new ArrayList<Tweet>();
            DBCollection table = db.getCollection("Tweet");
            BasicDBObject searchQuery = new BasicDBObject();
            DBCursor cursor = table.find()
					.sort(new BasicDBObject("retweetCount", -1))
					.limit(noOfTweets); // retweetCount

			while (cursor.hasNext()) {
				DBObject temp = cursor.next();
				topTweets.add(new TwitterTweet(new Long(temp.get("_id")
						.toString()).longValue(), temp.get("text").toString(),
						temp.get("userName").toString(), temp.get(
								"userScreenName").toString(), new Long(temp
								.get("favoriteCount").toString()).longValue(),
						new Long(temp.get("retweetCount").toString())
								.longValue()));
			}
			logger.debug("getTopTweets()@ MongoJavaDriverTwitterRepository End");
			return topTweets;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RepositroyException("REP-002");
		}
	}

	@Override
	public List<Tweet> getTopFavouriteTweets(int noOfTweets) throws RepositroyException {
		logger.debug("getTopFavouriteTweets()@ MongoJavaDriverTwitterRepository Start");
		try {
			List<Tweet> topTweets = new ArrayList<Tweet>();
            DBCollection table = db.getCollection("Tweet");
            BasicDBObject searchQuery = new BasicDBObject();
            DBCursor cursor = table.find()
					.sort(new BasicDBObject("favoriteCount", -1))
					.limit(noOfTweets); // retweetCount

			while (cursor.hasNext()) {
				DBObject temp = cursor.next();
				topTweets.add(new TwitterTweet(new Long(temp.get("_id")
						.toString()).longValue(), temp.get("text").toString(),
						temp.get("userName").toString(), temp.get(
								"userScreenName").toString(), new Long(temp
								.get("favoriteCount").toString()).longValue(),
						new Long(temp.get("retweetCount").toString())
								.longValue()));
			}
			logger.debug("getTopFavouriteTweets()@ MongoJavaDriverTwitterRepository End");
			return topTweets;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RepositroyException("REP-002");
		}
	}

}
