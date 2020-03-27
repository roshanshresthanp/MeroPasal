/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roshan.mavenspring.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author ROSHAB
 */
@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    DataSource dataSource;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select Username, Password, Active from User_detail where Username=?")
                .authoritiesByUsernameQuery("select ud.Username, ur.roles from User_Detail as ud, User_Role as ur where ud.ud_id=ur.ud_id and Username=?")
                .passwordEncoder(passwordEncoder);
                
    }
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()                                                                                                                                    
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/shoppingcart/**").hasRole("USER")
                .and()
            .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .successHandler(new CustomSuccessHandler())
                .failureUrl("/login?failure=true")
//                .failureForwardUrl("/login?failure=true")
                
                .permitAll()
                
             
                .and()
            .logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login?logout=true")
                .logoutUrl("/logout")
                .permitAll()
                .and()
            .csrf()
                .disable();
    }
     @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
    
}
