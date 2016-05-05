package com.qacomm.api;

import com.qacomm.logic.*;
import com.qacomm.entities.*;

import java.util.*;

public class qacommAPI {
	
	private Logic log;
	
	public qacommAPI(Logic log){
		this.log = log;
	}
	
	public List<Question> getTopTen() throws Exception{
		return log.getNewestPosts(); 
	}

	
	public Question postQuestion(Question question){
		return log.createQuestion(question);
		
	}
	
	public Question getQuestion(int questionID){
		return log.getQuestion(questionID);
		
	}
	
	public Answer postAnswer(int questionID, Answer answer){
		return log.createAnswer(answer,questionID);
	}
	
	//public boolean voteAnswer(int answerID){
		
	//}
	
}
