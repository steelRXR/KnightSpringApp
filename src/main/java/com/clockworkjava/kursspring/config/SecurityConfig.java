package com.clockworkjava.kursspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/knights").hasAnyRole("USER","ADMIN")
                .antMatchers("/knight").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/knights");
    }


    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user1").password("user1").roles("USER")
                .and()
                .withUser("user2").password("user2").roles("ADMIN");
    }
}
