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
	
	//@POST
    //@Timed
	//public Response postQuestion(QuestionJson json){
		//Question question = json.asQuesion();
		//Question created = api.postQuestion(question);
	    //return Response.ok(new QuestionJson(created)).build();
	//}
	
	//@GET
    //@Path("/{questionID}")
    //@Timed
	//public Response getQuestion(@PathParam("questionID") int qID){
		/*
		Optional<Question> result = api.getQuestion(qID);
        if (result.isPresent()) {
            Question question = result.get();
            return Response.ok(new QuestionJson(question)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
		*/
		//return null;
	//}
	
	//@POST
    //@Path("/{questionID}/answer")
    //@Timed
	//public Response postAnswer(@PathParam("questionID") int qID, AnswerJson json){
		//Answer answer = json.asAnswer();
		//Answer created = api.postAnswer(qID, answer);
		//return Response.ok(new AnswerJson(created)).build();
		
	//}
	
	//public Response voteAnswer(){
		//return null;
	//}
	
	
	
	
}
