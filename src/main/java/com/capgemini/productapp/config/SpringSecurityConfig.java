package com.capgemini.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/products/**")
		.hasAnyRole("ADMIN")
		.and()
		.formLogin();
		
	}
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}admin@123").roles("ADMIN");
		
			auth.inMemoryAuthentication()
			.withUser("guest")
			.password("{noop}admin@123")
			.roles("USER");
		
	}
}
