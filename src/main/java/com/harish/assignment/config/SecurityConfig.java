package com.harish.assignment.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic()
		.and()
		.authorizeRequests().antMatchers("/index.html", "/js/**", "/error.html", "/").permitAll()
		.anyRequest().authenticated()
		.and() .formLogin().defaultSuccessUrl("/home.html", true)
        .permitAll()
        .and()
        .logout()
        .permitAll();
	}
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")               
		        .authoritiesByUsernameQuery("select username as principal, authority as role from authorities where username = ?")                
		        .rolePrefix("ROLE_");
				
	}
}
