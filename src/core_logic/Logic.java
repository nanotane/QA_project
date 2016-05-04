package src.core_logic;
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
	 * Get the 10 newest posts and return
	 * them to the front end
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
		//just do a merge sort or bubble sort or what ever to get the top rated posts

		//now return the list
		return ansList;
	}
	/**
	 * Get the color of the user based
	 * on the rank. 
	 */
	public String getUserColor(String aUserID)
	{
		//ask for the users rank
		User tempUser;
		try {
			tempUser = DAO_obj.getUserInfo(aUserID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	 * Add to the score of a posts
	 */
	public boolean addScore(Answer anAnswer)
	{
		return DAO_obj.voteAnswer(anAnswer.getAnswerID());
	}
	/**
	 * Get the owner of a specific post
	 * either a question or answer
	 * @return a string with the owners username
	 */
	public User getUserInfo(User aUser)
	{
		try {
			return DAO_obj.getUserInfo(aUser.getUserName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * create a new user
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
	 * Send the sign in information and see
	 * if it is a user
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
	 * Create a new answer
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
	 * This will create a question based on a new question object
	 * @param newQuestion
	 * @return
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
	 * 
	 * @return
	 */
	public boolean deleteQuestion(Question aQuestion)
	{
		return DAO_obj.deleteQuestion(aQuestion);
		//TODO maybe set up try catch
	}
	/**
	 * 
	 * @param anAnswer
	 * @return
	 */
	public boolean deleteAnswer(Answer anAnswer)
	{
		return false;
		//TODO get the proper method and maybe set up try catch
	}
	/**
	 * Gets a sentence and returns a list
	 * of 10 questions that best match
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

	public static void main(String args[])
	{
		//TODO set up the testing code
	}
}
