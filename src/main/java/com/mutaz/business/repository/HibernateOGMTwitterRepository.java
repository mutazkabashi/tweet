package com.mutaz.business.repository;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
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

/**
 * 
 * @author Mutaz Hussein Kabashi
 * 
 */
public class HibernateOGMTwitterRepository implements TwitterTweetRepository {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("tweet");
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles
			.lookup().lookupClass());

	public void saveList(List<Tweet> tweets) throws RepositroyException {
		logger.debug("save() @HibernateOGMTwitterRepository Start");
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tm = em.getTransaction();
			tm.begin();
			/*
			 * com.mutaz.business.pojo.Breed collie = new
			 * com.mutaz.business.pojo.Breed(); collie.setName( "Test" );
			 */
			for (Tweet tweet : tweets) {
				em.persist(tweet);
			}
			// em.flush();
			tm.commit();
			em.close();
			logger.info("a List of tweets  have been saved Succefully to Data Base");
			logger.debug("save() @HibernateOGMTwitterRepository End");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RepositroyException("REP-001");
		}
	}

	@Override
	public List<Tweet> getTopTweets(int noOfTweets) throws RepositroyException {
		logger.debug("getTopTweets() @HibernateOGMTwitterRepository Start");
		try {
			/*
			 * EntityManager em = emf.createEntityManager(); EntityTransaction
			 * tm = em.getTransaction(); tm.begin(); Query query =
			 * em.createQuery("from Tweets order by favoriteCount desc");
			 * query.setMaxResults(noOfTweets); List<Tweet> topTweets =
			 * query.getResultList();
			 * logger.debug("getTopTweets() @HibernateOGMTwitterRepository End"
			 * );
			 */
			//TODO unfourunatley HibernateOGM doesn't support order by query yet for this reason we will use MongoJavaDriverTwitterReposiotry Until HibernateOgm team add it
			List<Tweet> topTweets = new ArrayList<Tweet>();
			MongoJavaDriverTwitterRepository mongoDriver = new MongoJavaDriverTwitterRepository();
			topTweets = mongoDriver.getTopTweets(5);
			logger.debug("getTopTweets() @HibernateOGMTwitterRepository End");
			return topTweets;
		} catch (RepositroyException e) {
			logger.error(e.getMessage(), e);
			//throw new RepositroyException("REP-002");
			throw e;
			//return null;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			//throw new RepositroyException("REP-002");
			//return null;
			throw new RepositroyException("REP-000");
		}

	}

	@Override
	public List<Tweet> getTopFavouriteTweets(int noOfTweets) throws RepositroyException {
		logger.debug("getTopFavouriteTweets() @HibernateOGMTwitterRepository Start");
		try {
			/*
			 * EntityManager em = emf.createEntityManager(); EntityTransaction
			 * tm = em.getTransaction(); tm.begin(); Query query =
			 * em.createQuery("from Tweets order by favoriteCount desc");
			 * query.setMaxResults(noOfTweets); List<Tweet> topTweets =
			 * query.getResultList();
			 * logger.debug("getTopTweets() @HibernateOGMTwitterRepository End"
			 * );
			 */
			//TODO unfourunatley HibernateOGM doesn't support order by query yet for this reason we will use MongoJavaDriverTwitterReposiotry Until HibernateOgm team add it
			List<Tweet> topTweets = new ArrayList<Tweet>();
			MongoJavaDriverTwitterRepository mongoDriver = new MongoJavaDriverTwitterRepository();
			topTweets = mongoDriver.getTopFavouriteTweets(5);
			logger.debug("getTopFavouriteTweets() @HibernateOGMTwitterRepository End");
			return topTweets;
		} catch (RepositroyException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			//throw new RepositroyException("REP-002");
			//return null;
			throw new RepositroyException("REP-000");
		}
	}

}
