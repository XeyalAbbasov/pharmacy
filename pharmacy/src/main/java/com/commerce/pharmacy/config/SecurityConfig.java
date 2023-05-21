package com.commerce.pharmacy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET ,"/","/home").permitAll()
                .antMatchers(HttpMethod.GET,"/v1/product/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/v1/product/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/v1/product/**").permitAll()
                .antMatchers(HttpMethod.POST,"/v1/product").permitAll()
                .antMatchers(HttpMethod.GET,"/v1/user/**").permitAll()
                .antMatchers(HttpMethod.POST,"/v1/user/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/v1/user/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/v1/user/**").permitAll()
                .antMatchers(HttpMethod.PATCH,"/v1/user/**").permitAll()
                .antMatchers(HttpMethod.POST,"/v1/orders/**").permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();
    }

}
