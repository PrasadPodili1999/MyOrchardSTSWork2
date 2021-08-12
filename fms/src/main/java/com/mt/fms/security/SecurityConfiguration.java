package com.mt.fms.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication()
//		.withUser("jack")
//		.password("2345")
//		.roles("AUDIENCE")
//		.and()
//		.withUser("jones")
//		.password("3456")
//		.roles("DIRECTOR");
//	}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/").permitAll()
//		.antMatchers("/films").hasRole("AUDIENCE")
//		.antMatchers("/director").hasAnyRole("DIRECTOR")
//		.anyRequest().authenticated()
//		//.antMatchers("/").permitAll()
//		.and().formLogin();
//	}
//}
