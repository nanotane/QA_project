package edu.qacomm.web;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.server.ServerFactory;

public class QacommConfig extends Configuration{
	
	 	@Valid
	    @NotNull
	    private ServerFactory server = new DefaultServerFactory();


	    @JsonProperty("server")
	    public ServerFactory getServerFactory() {
	        return server;
	    }

	    @JsonProperty("server")
	    public void setServerFactory(ServerFactory factory) {
	        this.server = factory;
	    }
}
