package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
	        	.antMatchers("/").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN") // Check with "/**"
	        	.antMatchers("/leaders/**").hasRole("MANAGER")
	        	.antMatchers("/systems/**").hasRole("ADMIN")
	        .and()
            	.formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
            .and()
            	.logout()
            	.permitAll()
            .and()
            	.exceptionHandling()
            	.accessDeniedPage("/access-denied");
    }

}
