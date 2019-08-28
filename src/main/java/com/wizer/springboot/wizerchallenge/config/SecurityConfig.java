package com.wizer.springboot.wizerchallenge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.wizer.springboot.wizerchallenge.services.MongoUserDetailsService;;


@Configuration
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Authentication : User --> Roles

	@Autowired
  	MongoUserDetailsService userDetailsService;


	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/register").permitAll()
		.anyRequest()
		.authenticated()
		.and().httpBasic()
		.and().sessionManagement().disable();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}

	
    

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
	builder.userDetailsService(userDetailsService);
	}

	


}