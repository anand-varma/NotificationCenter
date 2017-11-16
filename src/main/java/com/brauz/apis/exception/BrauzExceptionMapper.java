/**
 * 
 */
package com.brauz.apis.exception;

import com.brauz.exception.BrauzException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author Anand
 *
 */
public class BrauzExceptionMapper extends BrauzException implements ExceptionMapper<BrauzException> {

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(BrauzException exception) {

		System.out.println("Hi I am in Brauz exception mapper");
		ObjectMapper responseObjectMapper = new ObjectMapper();
		ObjectNode responseNode = responseObjectMapper.createObjectNode();
		responseNode.putPOJO("Success", false);
		responseNode.putPOJO("Error", exception.getMessage());
		responseNode.putPOJO("StackTrace", exception.getStackTrace());
		//return responseNode;
		return Response.status(400).entity(responseNode).type(MediaType.APPLICATION_JSON).build();
	}

}
