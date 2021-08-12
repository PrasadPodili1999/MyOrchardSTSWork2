package com.mindtree.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.mindtree.redisdemo.model.User;

import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
public class Redisdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Redisdemo1Application.class, args);
	}

}
