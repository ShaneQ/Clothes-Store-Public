package com.baeldung.resource.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {// @formatter:off
        http.cors()
            .and()
              .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/foos")
                    .hasAuthority("SCOPE_write")
                .antMatchers(HttpMethod.GET, "/user/info", "/api/foos/**", "/api/product/**")
                    .hasAuthority("SCOPE_read")
                .anyRequest()
                    .authenticated()
            .and()
              .oauth2ResourceServer()
                .jwt();
    }//@formatter:on

}