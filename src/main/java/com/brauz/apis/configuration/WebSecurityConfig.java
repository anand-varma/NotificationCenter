package com.brauz.apis.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Anand on 27/06/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
/*		httpSecurity.httpBasic().and()
				.authorizeRequests()
				.regexMatchers("/consumerapis*//*")
				.permitAll()
				.and()
				.authorizeRequests().anyRequest().authenticated();*/
		httpSecurity.
				authorizeRequests()
				.antMatchers("/swagger/**","/management/**")
				.authenticated().and()
				.httpBasic().and().csrf().disable();

	}

}
