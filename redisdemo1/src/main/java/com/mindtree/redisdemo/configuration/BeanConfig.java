package com.mindtree.redisdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.mindtree.redisdemo.model.User;

@Configuration
public class BeanConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory()
	{
		return new JedisConnectionFactory();
	}
	
	@Bean
	RedisTemplate<String, User> redisTemplate()
	{
		RedisTemplate<String, User> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
}
