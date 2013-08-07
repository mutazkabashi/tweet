package com.mutaz.business.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Twitter Tweet Pojo
 * @author Mutaz Hussein Kabashi
 * 
 */
@Entity
@Table(name="Tweet")
public class TwitterTweet implements Tweet {
	private long id;
	private String text;
	private String userName;
	private String userScreenName;
	private long favoriteCount;
	private long RetweetCount;

	public TwitterTweet(long id,String text, String userName, String userScreenName,
			long favoriteCount, long RetweetCount) {
		this.id = id;
		this.text = text;
		this.userName = userName;
		this.userScreenName = userScreenName;
		this.favoriteCount = favoriteCount;
		this.RetweetCount = RetweetCount;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserScreenName() {
		return userScreenName;
	}

	public void setUserScreenName(String userScreenName) {
		this.userScreenName = userScreenName;
	}

	public long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public long getRetweetCount() {
		return RetweetCount;
	}

	public void setRetweetCount(long retweetCount) {
		RetweetCount = retweetCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (RetweetCount ^ (RetweetCount >>> 32));
		result = prime * result
				+ (int) (favoriteCount ^ (favoriteCount >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((userScreenName == null) ? 0 : userScreenName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterTweet other = (TwitterTweet) obj;
		if (RetweetCount != other.RetweetCount)
			return false;
		if (favoriteCount != other.favoriteCount)
			return false;
		if (id != other.id)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userScreenName == null) {
			if (other.userScreenName != null)
				return false;
		} else if (!userScreenName.equals(other.userScreenName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TwitterTweet [id=" + id + ", text=" + text + ", userName="
				+ userName + ", userScreenName=" + userScreenName
				+ ", favoriteCount=" + favoriteCount + ", RetweetCount="
				+ RetweetCount + "]";
	}

	

}
