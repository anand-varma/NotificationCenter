package com.brauz.apis.configuration;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Anand on 29/06/2017.
 */
@Provider
public class CORSFilter implements ContainerResponseFilter{
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add("Access-Control-Allow-Origin","*");
		responseContext.getHeaders().add("Access-Control-Allow-Headers","origin, content-type, accept, authorization");
		responseContext.getHeaders().add("Access-Control-Allow-Methods","GET, POST, OPTIONS, HEAD");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials","true");

	}
}
