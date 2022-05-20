package it.chopper.rest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import mybatis.AgsErrore;
import mybatis.Causa;
import mybatis.MyBatisConnectionFactory;


@Path("/rest")
public class SimpleRestService {

	private static final Logger logger = Logger.getLogger(SimpleRestService.class);

	@GET
	@Path("/choppa")
    @Produces(MediaType.APPLICATION_JSON)
	public StringBuilder getSomething(@QueryParam("request") String request ,
			 @DefaultValue("1") @QueryParam("version") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start getSomething");
			logger.debug("data: '" + request + "'");
			logger.debug("version: '" + version + "'");
		}

		String response = null;
		List<Causa> causaQuery = new ArrayList<Causa>();
		StringBuilder sr = new StringBuilder();
        try{		
			MyBatisConnectionFactory connection = MyBatisConnectionFactory.getInstance();
			/*AgsErroreService ags = new AgsErroreService();
			AgsErrore query = ags.getAgsErrori(connection.getSqlSessionFactory().openSession());*/
			
			CausaService causaService = new CausaService();
			causaQuery = causaService.getCause(connection.getSqlSessionFactory().openSession());
			
			
			for(int i=0; i<causaQuery.size(); i++) {
				sr.append(causaQuery.get(i)).append("\n");
			}
			
//			SqlSession session = connection.getSqlSessionFactory().openSession();
//			logger.info("session open");
//			Connection conn = session.getConnection();
//			logger.info("Connessione MyBatis2Oracle " + conn);
//			session.close();
			logger.info("session close");
//            switch(version){
//	            case 1:
//	                if(logger.isDebugEnabled()) logger.debug("in version 1");
//
//	                
//                    break;
//                default: throw new Exception("Unsupported version: " + version);
//            }
            response = "Response: " + sr.toString();	
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        	logger.error(response);
        }
        
        if(logger.isDebugEnabled()){
            logger.debug("result: '"+response+"'");
            logger.debug("End getSomething");
        }
        return sr;	
	}

	@POST
	@Path("/<add method name here>")
    @Produces(MediaType.TEXT_PLAIN)
	public String postSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start postSomething");
			logger.debug("data: '" + request + "'");
			logger.debug("version: '" + version + "'");
		}

		String response = null;

        try{			
            switch(version){
	            case 1:
	                if(logger.isDebugEnabled()) logger.debug("in version 1");

	                response = "Response from RESTEasy Restful Webservice : " + request;
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        }
        
        if(logger.isDebugEnabled()){
            logger.debug("result: '"+response+"'");
            logger.debug("End postSomething");
        }
        return response;	
	}

	@PUT
	@Path("/<add method name here>")
    @Produces(MediaType.TEXT_PLAIN)
	public String putSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {
		if (logger.isDebugEnabled()) {
			logger.debug("Start putSomething");
			logger.debug("data: '" + request + "'");
			logger.debug("version: '" + version + "'");
		}

		String response = null;

        try{			
            switch(version){
	            case 1:
	                if(logger.isDebugEnabled()) logger.debug("in version 1");

	                response = "Response from RESTEasy Restful Webservice : " + request;
                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	response = e.getMessage().toString();
        }
        
        if(logger.isDebugEnabled()){
            logger.debug("result: '"+response+"'");
            logger.debug("End putSomething");
        }
        return response;	
	}

	@DELETE
	@Path("/<add method name here>")
	public void deleteSomething(@FormParam("request") String request ,  @DefaultValue("1") @FormParam("version") int version) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start deleteSomething");
			logger.debug("data: '" + request + "'");
			logger.debug("version: '" + version + "'");
		}


        try{			
            switch(version){
	            case 1:
	                if(logger.isDebugEnabled()) logger.debug("in version 1");

                    break;
                default: throw new Exception("Unsupported version: " + version);
            }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        if(logger.isDebugEnabled()){
            logger.debug("End deleteSomething");
        }
	}
}