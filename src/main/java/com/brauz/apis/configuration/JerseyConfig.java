package com.brauz.apis.configuration;

import com.brauz.apis.exception.GenericExceptionMapper;
import com.fasterxml.jackson.jaxrs.xml.JacksonXMLProvider;
import io.swagger.annotations.Api;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Anand on 24/05/2017.
 */
@Component
@ApplicationPath("/notificationapis")
@Api(value = "Notification Apis")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		registerEndpoints();
		configureSwagger();
	}
	private void registerEndpoints() {
		//This will make sure that all the classes in the package is registered
		//packages("com.brauz.apis");
		//register(com.brauz.apis.consumerapis.ProductConsumerApis.class);
/*		register(com.brauz.apis.consumerapis.StoreConsumerApis.class);
		register(com.brauz.apis.consumerapis.CampaignConsumerApis.class);
		register(com.brauz.apis.consumerapis.ProductStockConsumerApis.class);
		register(com.brauz.apis.consumerapis.BrandConsumerApis.class);
		register(com.brauz.apis.consumerapis.TagConsumerApis.class);*/
		register(JacksonFeature.class);
		register(JacksonXMLProvider.class);
		//register(BrauzException.class);
		register(GenericExceptionMapper.class);
		register(CORSFilter.class);
		//For basic authentication, created a custom Authentication filter
		//This will block any unauthenticated requests. Currently implemented only Basic Authentication with hardcoded user name and password
		//Commenting this for the time being
		//register(AuthenticationFilter.class);
		register(WadlResource.class);

	}
	private void configureSwagger(){
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);
		BeanConfig beanConfig=new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setBasePath("/notificationapis");
		beanConfig.setResourcePackage("com.brauz");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);


	}
}
