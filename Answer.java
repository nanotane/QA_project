import java.util.Date;

public class Answer {

	private int answerID;
	private int userID;
	private int questionID;
	private String text;
	private int votes;
	private Date datePosted;
	
	//getters and setters for answerID
	
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	
	//getters and setters for userID
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	//getters and setters for questionID
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
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
	
	
	
}
