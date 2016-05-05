package src.core_logic;

import java.util.Date;
import java.util.List;

import Entities.Answer;
import Entities.Question;
import Entities.User;

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
		User userList[] = new User[100];
		System.out.println("Creating users...");
		for(int i = 0; i < userList.length; i++)
		{
			//set the names to be from the random list + a random number after
			userList[i].setUserName(randomName()+(int) (Math.random() * 100));
			//set the emails to be from the list of names
			userList[i].setEmailID(randomName() + "_" + randomName() + (Math.random() * 100) + "@gmail.com");
			//random passwords
			userList[i].setPassword(Integer.toString((int) Math.random() * 1000));
			//set level
			userList[i].setUserLevel("0");
			
			if(!testLogic.createUser(userList[i]))
			{
				System.out.println("Failed to create entry #" + i);
				System.out.println("Username: " + userList[i].getUserName());
				System.out.println("Email: " + userList[i].getEmailID());
				System.out.println("Password: " + userList[i].getPassword());
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
		}
		System.out.println("------------------------------------------------");
		System.out.println("Making questions...");
		//lets have them all make a question
		Question temp = new Question();
		temp.setDatePosted(new Date());
		temp.setText("TESTING");
		temp.setVotes(0);
		for(int i = 0; i < userList.length; i++)
		{
			temp.setUserID(userList[i].getUserID());
			if(testLogic.createQuestion(temp) == null)
			{
				System.out.println("Failed to make a question in entry #" + i);
				System.out.println("Username: " + userList[i].getUserName());
				System.out.println("Email: " + userList[i].getEmailID());
				System.out.println("Password: " + userList[i].getPassword());
			}
		}
		System.out.println("------------------------------------------------");
		System.out.println("Making answers...");
		//lets make some answers
		List<Question> qList = testLogic.getNewestPosts();
		if(qList == null)
		{
			System.out.println("FAILED TO GET 10 NEWEST POSTS");
			System.exit(0);
		}
		Answer temp2 = new Answer();
		temp2.setDatePosted(new Date());
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
		}
		System.out.println("------------------------------------------------");
		System.out.println("Voting on answers...");
		Answer[] tempAnsList = testLogic.getAnswers(qList.get(0));
		for(int i = 0; i < userList.length; i++)
		{
			if(testLogic.addScore(tempAnsList[i]) == null)
			{
				System.out.println("Failed to vote on an answer in entry #" + i);
			}
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
