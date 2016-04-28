package persistant_logic;
import java.util.*;
import java.sql.*;

import Entities.Answer;
import Entities.Question;
import Entities.User;
public class DAOLayer {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/QandACommunity";
	
	//  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   
   public boolean signUp(User newUser)
   {
	   return true;
   }

	
	public boolean SignIn(User U)
	{
		 Connection conn = null;
		  Statement stmt = null;
		return true;
	}

	
	public User getUserInfo(int UserID)
	{
		 Connection conn = null;
		   Statement stmt = null;
		User user= new User();
		
		return user;
	}
	
	
	public List<Answer> getAnswers(int questionID)
	{
		 Connection conn = null;
		   Statement stmt = null;
		List<Answer> ans= null;
		
		return ans;
	}
	
	public List<Question> Search(String keyword)
	{
		 Connection conn = null;
		   Statement stmt = null;
		
		List<Question> questions= null;
		
		return questions;
	}
	
	public boolean postQuestion (Question question)
	{
		 Connection conn = null;
		   Statement stmt = null;
		return false;
	}
	
	public boolean postAnswer (int questionID,Answer answer)
	{
		 Connection conn = null;
		   Statement stmt = null;
		return false;
	}
	
	public boolean voteAnswer(int answerID)
	{
		 Connection conn = null;
		   Statement stmt = null;
		return false;
	}
}