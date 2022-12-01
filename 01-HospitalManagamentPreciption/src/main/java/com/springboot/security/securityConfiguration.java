package com.springboot.security;
/*
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * 
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableGlobalMethodSecurity(prePostEnabled = true) public class
 * securityConfiguration extends WebSecurityConfigurerAdapter {
 * 
 * 
 * 
 * @Override public void configure(HttpSecurity http) throws Exception {
 * 
 * 
 * 
 * http .csrf().disable() .authorizeRequests() .anyRequest() .authenticated()
 * .and() .httpBasic();
 * 
 * 
 * 
 * }
 * 
 * @Override public void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * auth.inMemoryAuthentication().withUser("user").password(this.passwordencoder(
 * ).encode("user@123")).roles("USER");
 * auth.inMemoryAuthentication().withUser("admin").password(this.passwordencoder
 * ().encode("admin@123")).roles("ADMIN");
 * 
 * }
 * 
 * @Bean public PasswordEncoder passwordencoder() { return new
 * BCryptPasswordEncoder(10); }
 * 
 * 
 * 
 * }
 */