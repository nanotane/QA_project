package core_logic;

import persistant_logic.P_Logic;

public class Logic 
{
	private P_Logic pLogic = new P_Logic();
	/**
	 * Get the 10 newest posts and return
	 * them to the frontend
	 */
	public void getNewestPosts()
	{
		//Persistant logic to get the posts
	}
	/**
	 * Get the color of the user based
	 * on the rank. 
	 */
	public String getUserColor(String userName)
	{
		//ask for the users rank
		int rank = 0; //TODO
		//Now check the users rank and see what color they should get
		if(rank < 10)
		{
			return "red";
		}
		else if(rank < 25)
		{
			return "blue";
		}
		else if(rank < 55)
		{
			return "orange";
		}
		return "black";//for low ranks its just black
	}
	/**
	 * modify the text for a post
	 */
	public void modifyPost(Post modedPost)
	{
		//set the modified post date
		modedPost.setDateModified();
		//call a persistent logic method
		
	}
	/**
	 * Check all of the users posts and votes
	 * then send back the new rank
	 */
	public void checkRank(String username)
	{
		//make a call to get the number of posts that the user has
		int questions = 0;
		int answers = 0;
		int postVotes = 0;
		
		//save the new rank with a persistant logic call
	}
	/**
	 * Add to the score of a posts
	 */
	public void addScore(Question question)
	{
		//make a persistant logic call to the 
	}
	/**
	 * Get the owner of a specific post
	 * either a question or answer
	 * @return a string with the owners username
	 */
	public String getPostOwner(String postID)
	{
		return "fail";
	}
	/**
	 * create a new user
	 */
	public void createUser()
	{
		
	}
	/**
	 * Send the sign in information and see
	 * if it is a user
	 */
	public int signInUser(String username, String password)
	{
		//persistant logic call
		//depending on the response we will get that error message
		//and send it up the line
		return 0;
	}
	/**
	 * Create a new answer
	 */
	public void createAnswer(Post newAsnwer)
	{
		//need to get current date and store that
		
	}
	/**
	 * create a new question
	 */
	public void createQuestion(Post newQuestion)
	{
		//need to get current date and store that
	}
	/**
	 * get the answers for a specific post
	 */
	public void getAnswers(String questionID)
	{
		//persistant logic call to get back an array of question json objects
		
		//return an array of them
	}
	/**
	 * Gets a sentence and returns a list
	 * of 10 questions that best match
	 */
	public void searchQuestions(String text)
	{
		//first make a query asking for all key word terms
		
		//next we check and see if the text has any of the search terms
		//if not then lets check and see if any question titles have a term
		/*
		 * If something matches both requirments, then put it into the list
		 * If list is not full, add something that only matches title
		 * if list is still not full add something that only matches key word of post
		 */
	}
	/**
	 * This method will check the text and make sure 
	 * that the text is not gonna mess up stuff
	 * @param text
	 * @return
	 */
	private String scrubText(String text)
	{
		return text;
	}
}
