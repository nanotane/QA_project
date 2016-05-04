package edu.qacomm.web.json;

import java.util.Date;

import com.qacomm.entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerJson {
	
	private int answerID;
	private int userID;
	private int questionID;
	private String text;
	private int votes;
	private Date datePosted;
	
	@JsonProperty
	public int getAnswerID() {
		return answerID;
	}
	@JsonProperty
	public int getUserID() {
		return userID;
	}
	@JsonProperty
	public int getQuestionID() {
		return questionID;
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
	public AnswerJson(Answer a) {
		this.answerID = a.getAnswerID();
		this.userID = a.getUserID();
		this.questionID = a.getQuestionID();
		this.text = a.getText();
		this.votes = a.getVotes();
		this.datePosted = a.getDatePosted();
	}
	
	public Answer asAnswer(){
		//TO DO
		return null;
	}
	
	
	
}
