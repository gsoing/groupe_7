package com.episen.docmanagement.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // utilisateur ayant le rôle de rédacteur
        auth.inMemoryAuthentication()
                .withUser("writter").password(passwordEncoder().encode("writter"))
                .roles("WRITTER");
        // utilisateur ayant le rôle de relecteur
        auth.inMemoryAuthentication()
                .withUser("reader").password(passwordEncoder().encode("reader"))
                .roles("READER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // allow documentation to be embedded in an iframe
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
              //  .antMatchers("/api/**/documents").hasRole("READER")
                .antMatchers("/api/**/user").hasRole("WRITTER")
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}