package core_logic;

import Entities.Answer;
import Entities.Question;
import Entities.User;
import persistant_logic.DAOLayer;

import java.lang.Throwable;
import java.util.Date;
import java.util.List;

import exceptions.TestException;

public class Logic 
{
	//going to catch the java exception and show to screen
	//remember no tags, remove tags
	private DAOLayer DAO_obj = new DAOLayer();//persistent logic object
	/**
	 * Get the 10 newest posts and return
	 * them to the front end
	 */
	public Question[] getNewestPosts()
	{
		//Persistent logic to get the posts
		//TODO
		return new Question[10];
	}
	/**
	 * Get and sort the list of questions based on the vote number of each
	 * If its more than the max size, then we will only grab answers
	 * up to the max from the query
	 * @param aQuestion the question we want answers from
	 * @return sorted list of questions
	 */
	public Answer[] getAnswers(Question aQuestion)
	{
		int MAX_LIST = 100;
		List<Answer> ansListTemp;
		ansListTemp = DAO_obj.getAnswers(aQuestion.getQuestionID());

		int ansTotal = ansListTemp.size();
		Answer[] ansList = new Answer[MAX_LIST];//set the size of the list

		//get the answers from the temp list to the list we will return
		if(ansTotal > MAX_LIST)
		{
			ansTotal = MAX_LIST;
			for(int i = 0; i < MAX_LIST; i++)
			{
				ansList[i] = ansListTemp.get(i);
			}
		}
		//just do a merge sort or bubble sort or what ever

		//now return the list
		return ansList;
	}
	/**
	 * Get the color of the user based
	 * on the rank. 
	 */
	public String getUserColor(int aUserID)
	{
		//ask for the users rank
		User tempUser;
		tempUser = DAO_obj.getUserInfo(aUserID);
		//Now check the users rank and see what color they should get
		if(Integer.parseInt(tempUser.getUserLevel()) < 10)
		{
			return "red";
		}
		else if(Integer.parseInt(tempUser.getUserLevel()) < 25)
		{
			return "blue";
		}
		else if(Integer.parseInt(tempUser.getUserLevel()) < 55)
		{
			return "orange";
		}
		return "black";//for low ranks its just black
	}
	/**
	 * modify the text for a question
	 */
	public String modifyPost(Question modedPost)
	{
		//set the modified post date
		Date d = new Date();
		modedPost.setDatePosted(d);
		//TODO
		//call a persistent logic method
		return "A MESSAGE";
	}
	/**
	 * Modify the text for an answer
	 * @param modedPost
	 * @return
	 */
	public String modifyPost(Answer modedPost)
	{
//		//set the modified post date
//		Date d = new Date();
//		modedPost.setDatePosted(d);
//		DAO_obj
//		//call a persistent logic method
		//TODO
		return "A MESSAGE";
	}
	/**
	 * Check all of the users posts and votes
	 * then send back the new rank
	 */
	public int checkRank(String username)
	{
		//make a call to get the number of posts that the user has
		//TODO
		//save the new rank with a persistant logic call
		return 10;
	}
	/**
	 * Add to the score of a posts
	 */
	public String addScore(Answer anAnswer)
	{
		DAO_obj.voteAnswer(anAnswer.getAnswerID());
		return "success";
		//TODO
	}
	/**
	 * Get the owner of a specific post
	 * either a question or answer
	 * @return a string with the owners username
	 */
	public User getUserInfo(User aUser)
	{
		return DAO_obj.getUserInfo(aUser.getUserID());

	}
	/**
	 * create a new user
	 */
	public boolean createUser(User newUser)
	{
		return DAO_obj.signUp(newUser);
	}
	/**
	 * Send the sign in information and see
	 * if it is a user
	 */
	public boolean signInUser(User userLogin)
	{
		//persistent logic call
		return DAO_obj.SignIn(userLogin);
	}
	/**
	 * Create a new answer
	 */
	public boolean createAnswer(Answer newAnswer, Question parentQuestion)
	{
		//need to get current date and store that
		return DAO_obj.postAnswer(parentQuestion.getQuestionID(),newAnswer);
	}
	/**
	 * This will create a question based on a new question object
	 * @param newQuestion
	 * @return
	 */
	public boolean createQuestion(Question newQuestion)
	{
			return DAO_obj.postQuestion(newQuestion);
	}
	/**
	 * Gets a sentence and returns a list
	 * of 10 questions that best match
	 */
	public void searchQuestions(String text)
	{
		//TODO
		//first make a query asking for all key word terms

		//next we check and see if the text has any of the search terms
		//if not then lets check and see if any question titles have a term
		/*
		 * If something matches both requirments, then put it into the list
		 * If list is not full, add something that only matches title
		 * if list is still not full add something that only matches key word of post
		 */
	}
	//ADD DELETE A QUESTION
	//TODO
}
