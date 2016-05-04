package edu.qacomm.web.json;

import java.util.Date;
import java.util.List;

import com.qacomm.entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionJson {

	private int questionID;
	private int userID;
	private String text;
	private int votes;
	private Date datePosted;
	private boolean isDeleted;
	private List<Answer> answers=null;
	
	
	@JsonProperty
	public int getQuestionID() {
		return questionID;
	}
	@JsonProperty
	public int getUserID() {
		return userID;
	}
	
	@JsonProperty
	public String getText() {
		return text;
	}
	
	@JsonProperty
	public int getVotes() {
		return votes;
	}
	
	@JsonProperty
	public Date getDatePosted() {
		return datePosted;
	}
	
	@JsonProperty
	public boolean isDeleted() {
		return isDeleted;
	}
	
	@JsonProperty
	public List<Answer> getAnswers() {
		return answers;
	}
	public QuestionJson(Question q) {
		this.questionID = q.getQuestionID();
		this.userID = q.getUserID();
		this.text = q.getText();
		this.votes = q.getVotes();
		this.datePosted = q.getDatePosted();
		this.isDeleted = q.isDeleted();
		this.answers = q.getAnswers();
	}
	
	public Question asQuesion(){
		//TO DO
		return null;
	}
	
}
