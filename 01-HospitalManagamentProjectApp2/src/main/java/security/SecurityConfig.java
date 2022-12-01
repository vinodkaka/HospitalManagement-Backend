/*
 * package security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * public class SecurityConfig extends WebSecurityConfigurerAdapter{
 * 
 * @Autowired PasswordEncoder passwordEncoder;
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.inMemoryAuthentication()
 * .withUser("patient").password(passwordEncoder.encode("pat123")).roles(
 * "USER");
 * 
 * 
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.formLogin(); http.authorizeRequests() .antMatchers("/admin/**")
 * .hasRole("ADMIN") .anyRequest() .permitAll() .and() .csrf().disable(); }
 * 
 * 
 * 
 * }
 * 
 */