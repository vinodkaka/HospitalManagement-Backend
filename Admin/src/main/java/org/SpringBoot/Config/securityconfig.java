//package org.SpringBoot.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Configuration
//public class securityconfig extends WebSecurityConfiguration {
//
//	 
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	
//    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
//    	
//        managerBuilder.inMemoryAuthentication()
//                .withUser("vinod").password("vinod123").roles("ADMIN").and();
//           
//                
//               
//    }
//
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.httpBasic().and().authorizeRequests()
//               // .antMatchers("/addItem","/delete").hasRole("ADMIN")
//                .antMatchers("/getallref").hasRole("ADMIN")
//                .and().csrf().disable().headers().frameOptions().disable();
//    }
//	 
//	 
//}
