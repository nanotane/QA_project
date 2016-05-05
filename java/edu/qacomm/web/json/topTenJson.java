package edu.qacomm.web.json;

import java.util.Date;
import java.util.List;

import com.qacomm.entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class topTenJson {

	private List<Question> topTenList;
	
	@JsonProperty
	public List<Question> getTopTenList() {
		return topTenList;
	}

	public topTenJson(List<Question> topTenList) {
		this.topTenList = topTenList;
	}
	
	
	
}
