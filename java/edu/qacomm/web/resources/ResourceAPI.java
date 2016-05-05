package edu.qacomm.web.resources;

import edu.qacomm.web.json.*;
import com.qacomm.api.*;
//import com.qacomm.dao.*;
import com.qacomm.entities.*;

import java.util.*;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import java.util.Optional;

@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceAPI {

	private qacommAPI api;

	public ResourceAPI(qacommAPI api) {
		this.api = api;
	}
	
	
	@GET
    @Path("/top10")
    @Timed
	public Response getTop10() throws Exception{
		List<Question> qList= api.getTopTen();
		topTenJson topTen = new topTenJson(qList);
		return Response.ok(topTen).build();
	}
	
	
	@POST
	@Path("/question")
	@Timed
	public Response postQuestion(QuestionJson json){
		Question question = json.asQuestion();
		Question created = api.postQuestion(question);
	    return Response.ok(new QuestionJson(created)).build();
	}
	
	
	@GET
    @Path("/{questionID}")
    @Timed
	public Response getQuestion(@PathParam("questionID") int qID){
		QuestionJson question = new QuestionJson(api.getQuestion(qID));
		return Response.ok(question).build();
	}
	
	
	@POST
    @Path("/answer")
    @Timed
	public Response postAnswer(AnswerJson json, @QueryParam("for") String qID){
		Answer answer = json.asAnswer();
		Answer created = api.postAnswer(Integer.parseInt(qID), answer);
		return Response.ok(new AnswerJson(created)).build();
		
	}
	
	
	
	//public Response voteAnswer(){
		
		//return null;
	//}	
}
