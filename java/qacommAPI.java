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

	
	//public Question postQuestion(Question question){
		//return dao.postQuestion(question);
		
	//}
	
	//public Answer postAnswer(int questionID, Answer answer){
		//return dao.postAnswer(questionID, answer);
	//}
	
	//public boolean voteAnswer(int answerID){
		//if(dao.voteAnswer(answerID)) return true;
		//else return false;
	//}
	
}
