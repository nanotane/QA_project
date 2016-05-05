package core_logic;
import Entities.Answer;
import Entities.Question;
import Entities.User;
import DAOLAyer.DAOLayer;

import java.lang.Throwable;
import java.util.Date;
import java.util.List;

public class Logic 
{
	//going to catch the java exception and show to screen
	//remember no tags, remove tags
	private DAOLayer DAO_obj = new DAOLayer();//persistent logic object
	/**
	 * Retrieves the 10 newest posts 
	 * @return a list of questions
	 */
	public List<Question> getNewestPosts()
	{
		//Persistent logic to get the posts
		List<Question> qList;
		try {
			qList = DAO_obj.getQuestions();
		} catch (Exception e) {
			e.printStackTrace();
			qList = null;
		}
		return qList;
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
		try {
			ansListTemp = DAO_obj.getAnswers(aQuestion.getQuestionID());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

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
		//just do a simple sorting algorithm to put the highest posts at the top
		Answer temp;
		for(int i = 0; i < MAX_LIST-1; i++)
		{
			if(ansList[i].getVotes() < ansList[i+1].getVotes())
			{
				//if the first is less than the second then flip them
				temp = ansList[i];
				ansList[i] = ansList[i+1];
				ansList[i+1] = temp;
			}
		}
		//now return the list
		return ansList;
	}
	/**
	 * Determine the user name's color based on the users score
	 * @param aUserID the userID of who we are checking
	 * @return a string that has the name of the color 
	 */
	public String getUserColor(String aUserID)
	{
		//ask for the users rank
		User tempUser;
		try {
			tempUser = DAO_obj.getUserInfo(aUserID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
	 * Add to the score of an answer
	 * @param anAnswer the answer object to add score to
	 * @return the new user object
	 */
	public Answer addScore(Answer anAnswer)
	{
		try {
			return DAO_obj.voteAnswer(anAnswer.getAnswerID());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Get the user information
	 * @param aUser object with the user name
	 * @return a user object that has all relavent user information
	 */
	public User getUserInfo(User aUser)
	{
		try {
			return DAO_obj.getUserInfo(aUser.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Create a new user in the database
	 * @param newUser the new user object that we are creating
	 * @return if we were successful or not
	 */
	public boolean createUser(User newUser)
	{
		try {
			return DAO_obj.SignUp(newUser);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Sign in a user 
	 * @param userLogin the user object with the login information
	 * @return if the user login information was correct or not
	 */
	public boolean signInUser(User userLogin)
	{
		//persistent logic call
		try {
			return DAO_obj.SignIn(userLogin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Create a new answer on the website
	 * @param newAnswer the answer object we are creating
	 * @param parentQuestion the question that the answer is related to
	 * @return the new answer objet that was created
	 */
	public Answer createAnswer(Answer newAnswer, Question parentQuestion)
	{
		//need to get current date and store that
		try
		{
			return DAO_obj.postAnswer(parentQuestion.getQuestionID(),newAnswer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Create a new question on the website
	 * @param newQuestion the question object we want to add to the database
	 * @return the new question object that was created
	 */
	public Question createQuestion(Question newQuestion)
	{
		try
		{
			return DAO_obj.postQuestion(newQuestion);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * Tells the DAO to delete the given answer object
	 * @param aQuestion the question object we are deleting
	 * @return a boolean signifying if we were successful or not
	 */
	public boolean deleteQuestion(Question aQuestion)
	{
		try
		{
			return DAO_obj.deleteQuestion(aQuestion);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		//TODO maybe set up try catch
	}
	/**
	 * Tells the DAO to delete the given answer object
	 * @param anAnswer the answer object we are deleting
	 * @return a boolean signifying if we were successful or not
	 */
	public boolean deleteAnswer(Answer anAnswer)
	{
		return false;
		//TODO get the proper method and maybe set up try catch
	}
	/**
	 * Searches the database for a list of Questions that match
	 * a users search term
	 * @param text the keyword to use for searching
	 * @return a list of Question objects
	 */
	public List<Question> searchQuestions(String text)
	{
		try {
			return DAO_obj.Search(text);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	public static void main(String args[])
//	{
//		Logic testLogic = new Logic();//create a new logic layer for testing
//	}
}
