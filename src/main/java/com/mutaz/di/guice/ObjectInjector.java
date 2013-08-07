package com.mutaz.di.guice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.mutaz.business.pojo.Tweet;
import com.mutaz.business.repository.HibernateOGMTwitterRepository;
import com.mutaz.business.repository.TweetRepostory;
import com.mutaz.business.thirdpartylibrary.tweetlibrary.TweetLibrary;
import com.mutaz.business.thirdpartylibrary.tweetlibrary.Twitter4jTweetLibrary;

/**
 * 
 * @author mutaz hussein kabashi
 *
 */
public class ObjectInjector extends AbstractModule{
	private static final Logger logger = LoggerFactory.getLogger(ObjectInjector.class);
	@Override
	protected void configure() {
		logger.trace("Guice init");
		bind(TweetRepostory.class).to(HibernateOGMTwitterRepository.class);
		bind(TweetLibrary.class).to(Twitter4jTweetLibrary.class);
		
	}
}
