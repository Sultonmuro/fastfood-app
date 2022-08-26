package com.example.kitchenservice.config;

import com.example.kitchenservice.entity.Worker;
import com.example.kitchenservice.entity.enums.WorkerType;
import com.example.kitchenservice.repository.WorkerRepository;
import com.sun.research.ws.wadl.HTTPMethods;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity @Configuration @Slf4j @RequiredArgsConstructor
public class BearerToken  extends WebSecurityConfigurerAdapter {
     private final UserDetailsService userDetailsService;
     private final BCryptPasswordEncoder bCryptPasswordEncoder;
     private  final WorkerType workerType;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.csrf().disable();
       http.authorizeRequests().anyRequest().hasRole("CHEF");
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.addFilter(new AuthFilter(authenticationManagerBean()));
       // ERTAGA TUGATISH SHART!!! >finished<
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws  Exception{
        return super.authenticationManagerBean();
    }

}
