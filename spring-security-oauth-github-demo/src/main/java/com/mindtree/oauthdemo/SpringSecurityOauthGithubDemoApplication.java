package com.mindtree.oauthdemo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SpringSecurityOauthGithubDemoApplication {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String message(Principal principal)
	{
		return "Hi "+principal.getName()+" welcome";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauthGithubDemoApplication.class, args);
	}

}
