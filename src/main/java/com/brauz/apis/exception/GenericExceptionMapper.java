package com.brauz.apis.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper extends Throwable implements ExceptionMapper<Throwable>{
	private static final long serialVersionUID=1L;
	static Logger logger = LogManager.getLogger(GenericExceptionMapper.class);

	@Override
	public Response toResponse(Throwable exception) {
		//System.out.println("Hi I am in generic exception mapper");
		ObjectMapper responseObjectMapper = new ObjectMapper();
		ObjectNode responseNode = responseObjectMapper.createObjectNode();
		responseNode.putPOJO("Success", false);
		//responseNode.putPOJO("Message",exception.getMessage());
		responseNode.putPOJO("Error", exception.getMessage());
		logger.error("Exception:",exception);

		/*responseNode.putPOJO("StackTrace", exception.getStackTrace());*/
		return Response.status(510).entity(
				responseNode
				).type(MediaType.APPLICATION_JSON).build();
	}	
	
	
}