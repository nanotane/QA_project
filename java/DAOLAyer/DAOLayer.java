import java.util.*;

//import com.qacomm.entities.Question;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DAOLayer {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3309/QandACommunity";
	
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
		      sqlCheckUserName = "SELECT * from Users where userName="+ "'"+user.getUserName()+"'";
		      sqlCheckEmail= "Select * from Users where emailID= "+ "'"+ user.getEmailID()+"'";
		      sqlInsertRecord= "Insert into Users (userName, password,phoneNumber, emailId, city, userLevel) "
		      		+ "values ('"+user.getUserName()+"', '"+user.getPassword()+"', '"+ user.getPhoneNumber()+ "', '"+ user.getEmailID()+"', '"+ user.getCity()+"', '"+ 
		    		  user.getUserLevel()+"')";
		      ResultSet rs1 = stmt.executeQuery(sqlCheckUserName);
		      stmt = conn.createStatement();
		      ResultSet rs2 = stmt.executeQuery(sqlCheckEmail);
		        
		       if(rs1.next()||rs2.next())
		       {
		    	   rs1.close();
			    	  rs2.close();
			          stmt.close();
			          conn.close();
		    	   return false;
		       }
		      

		       else{
		    	   stmt = conn.createStatement();
		    	  stmt.executeUpdate(sqlInsertRecord);
		    	  rs1.close();
		    	  rs2.close();
		          stmt.close();
		          conn.close();
		    	  return true;
		       }
	   }
	   catch(Exception e){
		   throw e;
	   }
		 
	   
   }
   
   public boolean deleteQuestion(Question question) throws Exception
   {
	   Connection conn = null;
		 Statement stmt = null;
		
		 try{
				Class.forName("com.mysql.jdbc.Driver");


			     
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();
			      String sql;
			     
			      sql = "UPDATE Questions SET isDeleted=1 where questionID="+question.getQuestionID();
			     
			   
			      
			      stmt.executeQuery(sql);
			      
			      
			      
			      
			     
		          stmt.close();
		          conn.close();
			      
			     return true;
			}
			catch (Exception E)
			{
				throw E;
			}
	   
	   
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
		      sql = "SELECT * from Questions where isDeleted=0 LIMIT 10";
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		      
		      
		     // DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		      //Date date = format.parse(string);
		    	  questions= new ArrayList<Question>();
		    	  while(rs1.next()){
		    		  Question q= new Question();
		    		  q.setQuestionID(rs1.getInt("questionID"));
		    		  q.setText(rs1.getString("questionText"));
		    		  q.setUserID(rs1.getInt("userID"));
		    		 // q.setDatePosted(format.parse(rs1.getString("datePosted")));
		    		  //q.setDateModified(format.parse(rs1.getString("dateModified")));
		    		  q.setVotes(rs1.getInt("votes"));
		    		  q.setDeleted(rs1.getBoolean("isDeleted"));
		    		  questions.add(q);
		    	  }
		    	  rs1.close();
		    	 
		          stmt.close();
		          conn.close();
		    	  return questions;
		     
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
			      sql = "SELECT * from Questions where questionID="+questionID+" AND isDeleted=0";
			     
			      ResultSet rs1 = stmt.executeQuery(sql);
			      
			      if(!rs1.next()){
			    	  rs1.close();
			    	  
			          stmt.close();
			          conn.close();
			    	  return q;
			      }
			      else
			      {
			    	  
			    	
			    		  q.setQuestionID(rs1.getInt("questionID"));
			    		  q.setText(rs1.getString("questionText"));
			    		  q.setUserID(rs1.getInt("userID"));
			    		//  q.setDatePosted(rs1.getDate("datePosted"));
			    		 // q.setDateModified(rs1.getDate("dateModified"));
			    		  q.setVotes(rs1.getInt("votes"));
			    		  q.setDeleted(rs1.getBoolean("isDeleted"));
			    		  
			    	  }
			      rs1.close();
		    	  
		          stmt.close();
		          conn.close();
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
		      sql = "SELECT password from Users where userName='"+ user.getUserName()+"'";
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		     
		   
		      
		      if(!rs1.next()){
		    	  rs1.close();
		    	 
		          stmt.close();
		          conn.close();
		    	  return false;
		      }

		      else{
		    	  
		    	  password=rs1.getString("password");
		    	  
		    	  if(password.trim().equals(user.getPassword().trim())){
		    	  
		    		  
		    		  rs1.close();
			    	  
			          stmt.close();
			          conn.close(); 
		    	  return true;
		    	  }
		    	  
		    	  else{
		    		  rs1.close();
			    	 
			          stmt.close();
			          conn.close();
		    		  return false;}
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
		      sql = "SELECT * from Users where userName='"+ userName+"'";
		     
		      ResultSet rs1 = stmt.executeQuery(sql);
		     
		   
		      
		      if(!rs1.next()){
		    	  rs1.close();
		    	
		          stmt.close();
		          conn.close();
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
		    	  rs1.close();
		    	
		          stmt.close();
		          conn.close();
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
		      
		      if(!rs1.next()){
		    	  rs1.close();
		    	  
		          stmt.close();
		          conn.close();
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
		    		 // a.setDatePosted(rs1.getDate("datePosted"));
		    		  //a.setDateModified(rs1.getDate("dateModified"));
		    		  ans.add(a);
		    	  }
		    	  rs1.close();
		    	 
		          stmt.close();
		          conn.close();
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
		    		  //q.setDatePosted(rs1.getDate("datePosted"));
		    		  //q.setDateModified(rs1.getDate("dateModified"));
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
			     // java.sql.Date datePosted=new java.sql.Date(question.getDatePosted().getTime());
			      //java.sql.Date dateModified=new java.sql.Date(question.getDateModified().getTime());
			     // sql = "insert into Questions (questionText, datePosted, dateModified, userID,votes, isDeleted) values('"+question.getText()+"','"+datePosted+"' ,'"+dateModified+"',"+question.getUserID()+","+question.getVotes()+", 0)";
			      sql = "insert into Questions (questionText, userID,votes, isDeleted) values('"+question.getText()+"',"+question.getUserID()+","+question.getVotes()+", 0)";
					
			     stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			      
			      ResultSet rs1= stmt.getGeneratedKeys();
			      rs1.next();
			      int questionID=rs1.getInt(1);
			      
			      question.setQuestionID(questionID);
			      
			      rs1.close();
		    	 
		          stmt.close();
		          conn.close();
			      
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
			      //java.sql.Date datePosted=new java.sql.Date(answer.getDatePosted().getTime());
			      //java.sql.Date dateModified=new java.sql.Date(answer.getDateModified().getTime());
			      //sql = "insert into Answers (userID, questionID, answerText, votes, datePosted, dateModified) values("+answer.getUserID()+","+answer.getQuestionID()+" ,'"+answer.getText()+"',"+answer.getVotes()+",'"+datePosted+"','"+dateModified+"')";
			      
			      
			      sql = "insert into Answers (userID, questionID, answerText, votes) values("+answer.getUserID()+","+answer.getQuestionID()+" ,'"+answer.getText()+"',"+answer.getVotes()+")";
			      
			      stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			      
			      ResultSet rs1= stmt.getGeneratedKeys();
			      rs1.next();
			      int answerID=rs1.getInt(1);
			      
			      answer.setAnswerID(answerID);
			     
			      rs1.close();
		    	  
		          stmt.close();
		          conn.close();
			      
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
			      if(rs1.next()){
			      ans.setAnswerID(answerID);
			      ans.setText(rs1.getString("answerText"));
			      ans.setUserID(rs1.getInt("userID"));
			      //ans.setDatePosted(rs1.getDate("datePosted"));
			      //ans.setDateModified(rs1.getDate("dateModified"));
			      ans.setQuestionID(rs1.getInt("questionID"));
			      }
			      int finalVotes=votes+1;
			      ans.setVotes(finalVotes);
			      sql1="UPDATE Answers SET votes="+finalVotes+" where answerID="+answerID;
			      
			      stmt.executeUpdate(sql1);
			      
			      
			      rs1.close();
		    	  
		          stmt.close();
		          conn.close();
			      
			     
			      
			     return ans;
			}
			catch (Exception E)
			{
				throw E;
			}
		
	}
}
