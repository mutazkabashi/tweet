package com.mutaz.business.pojo;
/**
 * 
 * Base Tweet contains basic tweets/status attributes
 *
 * @author Mutaz Hussein Kabbashi
 *
 */

public interface Tweet {
	
	public long getId() ;
	
	public void setId(long id);

	public String getText();

	public void setText(String text);

	public String getUserName();

	public void setUserName(String username);

	public String getUserScreenName();

	public void setUserScreenName(String userScreenName);

	public long getFavoriteCount();

	public void setFavoriteCount(long location);

	public long getRetweetCount();

	public void setRetweetCount(long retweetCount);

}
