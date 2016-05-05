package edu.qacomm.web.json;

import java.util.Date;
import java.util.List;

import com.qacomm.entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionJson {

	private int questionID;
	private int userID;
	private String qtext;
	private int votes;
	private Date datePosted;
	private boolean isDeleted;
	private List<Answer> answers=null;
	
	//public List<AnswerWrapper> createWrapper(answers){
	//	AnswerWrapper wrapperList = new ArrayList<AnswerWrapper>
		//return null;
	//}
	
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
		return qtext;
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
		this.qtext = q.getText();
		this.votes = q.getVotes();
		this.datePosted = q.getDatePosted();
		this.isDeleted = q.isDeleted();
		this.answers = q.getAnswers();
	}
	
	public Question asQuestion(){
		Question q = new Question();
		q.setText(qtext);
		q.setDatePosted(new Date());
		q.setDeleted(false);
		return q;
	}
	
}
