import java.util.*;
import java.sql.*;
public class DAOLayer {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/QandACommunity";
	
	//  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public boolean SignUp(User user) throws Exception
   {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		
		      Class.forName("com.mysql.jdbc.Driver");


		     
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sqlCheckUserName , sqlCheckEmail, sqlInsertRecord;
		      sqlCheckUserName = "SELECT * from Users where userName="+ user.getUserName();
		      sqlCheckEmail= "Select * from Users where emailID= "+ user.getEmailID();
		      sqlInsertRecord= "Insert in to Users (userName, password,phoneNumber, emailId, city, userLevel) "
		      		+ "values ("+user.getUserName()+", "+user.getPassword()+", "+ user.getPhoneNumber()+ ", "+ user.getEmailID()+", "+ user.getCity()+", "+ 
		    		  user.getUserLevel()+")";
		      ResultSet rs1 = stmt.executeQuery(sqlCheckUserName);
		      ResultSet rs2 = stmt.executeQuery(sqlCheckEmail);
		   
		      
		      if(rs1.getFetchSize()>0||rs2.getFetchSize()>0){
		    	  return false;
		      }

		      else{
		    	  stmt.executeQuery(sqlInsertRecord);
		    	  return true;
		      }
	   }
	   catch(Exception e){
		   throw e;
	   }
		 
	   
   }
   
   public boolean deleteQuestion(Question question)
   {
	   return false;
   }
   
   public List<Question> getQuestions() throws Exception
   {
	   List<Question> questions= null;
	   Connection conn = null;
		  Statement stmt = null; 
	   try{
			Class.forName("com.mysql.jdbc.Driver");

			
			
		     
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * from (select TOP 10 * from Questions Order by datePosted DESC)";
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		      
		      if(rs1.getFetchSize()<=0){
		    	  return questions;
		      }
		      else
		      {
		    	  questions= new ArrayList<Question>();
		    	  while(rs1.next()){
		    		  Question q= new Question();
		    		  q.setQuestionID(rs1.getInt("questionID"));
		    		  q.setText(rs1.getString("questionText"));
		    		  q.setUserID(rs1.getInt("userID"));
		    		  q.setDatePosted(rs1.getDate("datePosted"));
		    		  q.setDateModified(rs1.getDate("dateModified"));
		    		  q.setVotes(rs1.getInt("votes"));
		    		  q.setDeleted(rs1.getBoolean("isDeleted"));
		    		  questions.add(q);
		    	  }
		    	  return questions;
		      }
		}
		catch (Exception E)
		{
			throw E;
		}
	   
	
   }
   
   public Question getQuestion(int questionID) throws Exception
   {
	   Connection conn = null;
		  Statement stmt = null; 
		  Question q= new Question();
		  try{
				Class.forName("com.mysql.jdbc.Driver");

				
				
			     
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT * from Questions where questionID="+questionID;
			     
			      ResultSet rs1 = stmt.executeQuery(sql);
			      
			      if(rs1.getFetchSize()<=0){
			    	  return q;
			      }
			      else
			      {
			    	  
			    	
			    		  q.setQuestionID(rs1.getInt("questionID"));
			    		  q.setText(rs1.getString("questionText"));
			    		  q.setUserID(rs1.getInt("userID"));
			    		  q.setDatePosted(rs1.getDate("datePosted"));
			    		  q.setDateModified(rs1.getDate("dateModified"));
			    		  q.setVotes(rs1.getInt("votes"));
			    		  q.setDeleted(rs1.getBoolean("isDeleted"));
			    		  
			    	  }
			    	  return q;
			      
			}
			catch (Exception E)
			{
				throw E;
			}
		  
   }

	
	public boolean SignIn(User user) throws Exception
	{
		Connection conn = null;
		  Statement stmt = null; 
		  String password="";
		  try{
				
		      Class.forName("com.mysql.jdbc.Driver");


		     
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT password from Users where userName="+ user.getUserName();
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		     
		   
		      
		      if(rs1.getFetchSize()<=0){
		    	  return false;
		      }

		      else{
		    	  
		    	  password=rs1.getString("password");
		    	  
		    	  if(password==user.getPassword())
		    	  
		    	  return true;
		    	  
		    	  else
		    		  return false;
		      }
	   }
	   catch(Exception e){
		   throw e;
	   }
		
	}

	
	public User getUserInfo(String userName) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		User user= null;
		try{
			
		      Class.forName("com.mysql.jdbc.Driver");


		     
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * from Users where userName="+ userName;
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		     
		   
		      
		      if(rs1.getFetchSize()<=0){
		    	  return user;
		      }

		      else{
		    	  user= new User();
		    	  while(rs1.next()){
		    		  user.setUserID(rs1.getInt("userID"));
		    		  user.setUserName(rs1.getString("userName"));
		    		  user.setPassword(rs1.getString("password"));
		    		  user.setPhoneNumber(rs1.getString("phoneNumber"));
		    		  user.setEmailID(rs1.getString("emaiID"));
		    		  user.setCity(rs1.getString("city"));
		    		  user.setUserLevel(rs1.getString("userLevel"));
		    	  }
		    	 return user;
		      }
	   }
	   catch(Exception e){
		   throw e;
	   }
		
		
	}
	
	
	public List<Answer> getAnswers(int questionID) throws Exception
	{
		 Connection conn = null;
		   Statement stmt = null;
		List<Answer> ans= null;
		try{
			Class.forName("com.mysql.jdbc.Driver");


		     
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * from Answers where questionID="+ questionID;
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		      
		      if(rs1.getFetchSize()<=0){
		    	  return ans;
		      }
		      else
		      {
		    	  ans= new ArrayList<Answer>();
		    	  while(rs1.next()){
		    		  Answer a= new Answer();
		    		  a.setAnswerID(rs1.getInt("answerID"));
		    		  a.setUserID(rs1.getInt("userID"));
		    		  a.setQuestionID(questionID);
		    		  a.setText(rs1.getString("answerText"));
		    		  a.setVotes(rs1.getInt("votes"));
		    		  a.setDatePosted(rs1.getDate("datePosted"));
		    		  a.setDateModified(rs1.getDate("dateModified"));
		    		  ans.add(a);
		    	  }
		    	  return ans;
		      }
		}
		catch (Exception E)
		{
			throw E;
		}
		
	}
	
	public List<Question> Search(String keyword) throws Exception
	{
		 Connection conn = null;
		   Statement stmt = null;
		   
		
		List<Question> questions= null;
		try{
			Class.forName("com.mysql.jdbc.Driver");


		     
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * from Questions where questionText LIKE '%"+ keyword+"%'";
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		      
		      if(rs1.getFetchSize()<=0){
		    	  return questions;
		      }
		      else
		      {
		    	  questions= new ArrayList<Question>();
		    	  while(rs1.next()){
		    		  Question q= new Question();
		    		  q.setQuestionID(rs1.getInt("questionID"));
		    		  q.setText(rs1.getString("questionText"));
		    		  q.setUserID(rs1.getInt("userID"));
		    		  q.setDatePosted(rs1.getDate("datePosted"));
		    		  q.setDateModified(rs1.getDate("dateModified"));
		    		  q.setVotes(rs1.getInt("votes"));
		    		  q.setDeleted(rs1.getBoolean("isDeleted"));
		    		  questions.add(q);
		    	  }
		    	  return questions;
		      }
		}
		catch (Exception E)
		{
			throw E;
		}
		
		
	}
	
	public Question postQuestion (Question question) throws Exception
	{
		 Connection conn = null;
		 Statement stmt = null;
		 
		 
		 try{
				Class.forName("com.mysql.jdbc.Driver");


			     
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();
			      String sql;
			      sql = "insert in to Questions (questionText, datePosted, dateModified, userID,votes, isDeleted) values("+question.getText()+","+question.getDatePosted()+" ,"+question.getDateModified()+","+question.getUserID()+","+question.getVotes()+","+question.getDateModified()+")";
			     
			      stmt.executeQuery(sql);
			     
			      ResultSet rs1= stmt.executeQuery("Select last_insert_id() as last_id from Questions");
			      int questionID=rs1.getInt("last_id");
			      
			      question.setQuestionID(questionID);
			      
			     return question;
			}
			catch (Exception E)
			{
				throw E;
			}
			
		 
		 
		
	}
	
	public Answer postAnswer (int questionID,Answer answer) throws Exception
	{
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try{
				Class.forName("com.mysql.jdbc.Driver");


			     
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();
			      String sql;
			      sql = "insert in to Answers (userID, questionID, answerText, votes, datePosted, dateModified) values("+answer.getUserID()+","+answer.getQuestionID()+" ,"+answer.getText()+","+answer.getVotes()+","+answer.getDatePosted()+","+answer.getDateModified()+")";
			      
			      stmt.executeQuery(sql);
			      
			      ResultSet rs1= stmt.executeQuery("Select last_insert_id() as last_id from Answers");
			      int answerID=rs1.getInt("last_id");
			      
			      answer.setAnswerID(answerID);
			     
			      
			     return answer;
			}
			catch (Exception E)
			{
				throw E;
			}
		  
	}
	//new Answer object returned
	public Answer voteAnswer(int answerID) throws Exception
	{
		 Connection conn = null;
		 Statement stmt = null;
		 Answer ans= new Answer();
		 int votes=0;
		 try{
				Class.forName("com.mysql.jdbc.Driver");


			     
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();
			      String sql,sql1;
			     
			      sql = "select * from answers where answerID="+answerID;
			     
			      ResultSet rs1=stmt.executeQuery(sql);
			      ans.setAnswerID(answerID);
			      ans.setText(rs1.getString("answerText"));
			      ans.setUserID(rs1.getInt("userID"));
			      ans.setDatePosted(rs1.getDate("datePosted"));
			      ans.setDateModified(rs1.getDate("dateModified"));
			      ans.setQuestionID(rs1.getInt("questionID"));
			      int finalVotes=votes+1;
			      ans.setVotes(finalVotes);
			      sql1="UPDATE Answers SET votes="+finalVotes+"where answerID="+answerID;
			      
			      stmt.executeQuery(sql1);
			      
			      
			      
			      
			     
			      
			     return ans;
			}
			catch (Exception E)
			{
				throw E;
			}
		
	}
}
