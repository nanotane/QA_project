
import java.util.Date;
import java.util.List;

public class Tester {
	/*
	 * This is for testing communication between the business logic, DAO layer,
	 * and the database layer
	 * 
	 * test uses a set of 100 users, and has those users do a number of various things
	 */
	public static void main(String args[])
	{
		Logic testLogic = new Logic();
		User userList[] = new User[100];//change the size of this list for more tests to be run
		for(int i = 0; i < userList.length;i++)
		{
			userList[i] = new User();
		}
		System.out.println("Creating users...");
		for(int i = 0; i < userList.length; i++)
		{
			//set the names to be from the random list + a random number after
			userList[i].setUserName(randomName()+(int) (Math.random() * 1000));
			//set the emails to be from the list of names
			userList[i].setEmailID(randomName() + "_" + randomName() + ((int) (Math.random() * 100)) + "@gmail.com");
			//random passwords
			userList[i].setPassword("12345");
			//set level
			userList[i].setUserLevel("0");
			
			if(!testLogic.createUser(userList[i]))
			{
				System.out.println("Failed to create entry #" + i);
				System.out.println("Username: " + userList[i].getUserName());
				System.out.println("Email: " + userList[i].getEmailID());
				System.out.println("Password: " + userList[i].getPassword());
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//add all the users
		}
		System.out.println("------------------------------------------------");
		System.out.println("Signing in users...");
		//now lets log them all in
		for(int i = 0; i < userList.length; i++)
		{
			if(!testLogic.signInUser(userList[i]))
			{
				System.out.println("Failed to log in entry #" + i);
				System.out.println("Username: " + userList[i].getUserName());
				System.out.println("Email: " + userList[i].getEmailID());
				System.out.println("Password: " + userList[i].getPassword());
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("------------------------------------------------");
		System.out.println("Making questions...");
		//lets have them all make a question
		Question temp = new Question();
		//temp.setDatePosted(new Date());
		temp.setText("TESTING");
		temp.setVotes(0);
		for(int i = 0; i < userList.length; i++)
		{
			temp.setUserID(i);
			if(testLogic.createQuestion(temp) == null)
			{
				System.out.println("Failed to make a question in entry #" + i);
				System.out.println("Username: " + userList[i].getUserName());
				System.out.println("Email: " + userList[i].getEmailID());
				System.out.println("Password: " + userList[i].getPassword());
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("------------------------------------------------");
		List<Question> qList = testLogic.getNewestPosts();
		System.out.println("Top 10 questions:");
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Question " + i);
			System.out.println("Contents: " + qList.get(i).getText());
			System.out.println("Question ID: " + qList.get(i).getQuestionID());
			System.out.println("User ID: " + qList.get(i).getUserID());
		}
		System.out.println("------------------------------------------------");
		System.out.println("Making answers...");
		//lets make some answers
		
		if(qList == null)
		{
			System.out.println("FAILED TO GET 10 NEWEST POSTS");
			System.exit(0);
		}
		Answer temp2 = new Answer();
		//temp2.setDatePosted(new Date());
		temp2.setText("OF COURSE");
		temp2.setVotes(0);
		for(int i = 0; i < userList.length; i++)
		{
			temp2.setUserID(userList[i].getUserID());
			if(testLogic.createAnswer(temp2, qList.get(0)) == null)
			{
				System.out.println("Failed to make an answer in entry #" + i);
				System.out.println("Username: " + userList[i].getUserName());
				System.out.println("Email: " + userList[i].getEmailID());
				System.out.println("Password: " + userList[i].getPassword());
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("------------------------------------------------");
		System.out.println("Voting on answers...");
		List<Answer> tempAnsList = testLogic.getAnswers(0);
		for(int i = 0; i < userList.length-1; i++)
		{
			if(testLogic.addScore(tempAnsList.get(i).getAnswerID()) == null)
			{
				System.out.println("Failed to vote on an answer in entry #" + i);
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ALL TESTING COMPLETE");
	}
	
	public static String randomName()
	{
		String names[] = {
		"Mathew",
		"Mark",
		"Luke",
		"John",
		"Joshua",
		"Ruth",
		"Emanual",
		"Victor",
		"Jacob",
		"Julia",
		"Sam",
		"Ivory",
		"Austin",
		"Ian",
		"Kedar"
		};
		return names[(int) (Math.random()*names.length-1)];
	}
}
