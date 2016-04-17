package core_logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	public int votes;
	public int id;
	public String title;
	public String text;
	public String userID;
	public String datePost; //??What will this be?
	public String dateMod;
	public boolean isDelete = false;
	public String error;
	
	//have a function that turns them into json objects
	/**
	 * Sets the date created value to when this was called
	 */
	public void setDateCreated()
	{
		datePost = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	/**
	 * Sets the date modified value to when this was called
	 */
	public void setDateModified()
	{
		dateMod = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	/**
	 * Increments the number of votes for a post, and makes
	 * sure that its not above the max for an int
	 */
	public void incrVotes()
	{
		if(votes != Integer.MAX_VALUE)
		{
			votes++;
		}
	}
	
}
