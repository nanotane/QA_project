package edu.qacomm.web;

import com.qacomm.api.*;
import com.qacomm.dao.*;
//import com.qacomm.entities.*;
//import edu.qacomm.web.*;
//import edu.qacomm.web.json.*;
import edu.qacomm.web.resources.*;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class QacommWeb extends Application<QacommConfig>{

	
	public static void main(String[] args) throws Exception {
		new QacommWeb().run(args);
	}

@Override
public void run(QacommConfig config, Environment env) throws Exception {
    final DAOLayer dao = new DAOLayer();
    final qacommAPI api = new qacommAPI(dao);

    

    final ResourceAPI questionResource = new ResourceAPI(api);
    env.jersey().setUrlPattern("/questions/*");
    env.jersey().register(questionResource);

	}
}

