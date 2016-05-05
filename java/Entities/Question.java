import java.util.Date;
import java.util.*;
public class Question {
	
	private int questionID;
	private int userID;
	private String text;
	private int votes;
	private Date datePosted;
	private Date dateModified;
	private boolean isDeleted;
	private List<Answer> answers=null;
	
	
	//getters and setters for questionID
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	
	
	//getters and setters for userID
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	//getters and setters for text
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//getters and setters for votes
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	//getters and setters for datePosted
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	
	//getters and setters for isDeleted
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	//getters and setters for List<Answer>
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	//Modified
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	
	
	
	
	
	
	

}
