package com.myretail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Satya
 * Configuration will initialize the Jedis connection factory, redistemplate and loads configurations
 */
@Configuration
@EnableRedisRepositories
@ConfigurationProperties(prefix="product")
public class MyRetailConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(MyRetailConfiguration.class);
	//Values will be set from environment variables - Spring relaxed binding
	private String redisIp;
	private String nameServiceUrl;
	private Integer redisMaxCon;
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    //TODO Add Redis Cluster support for efficient data reads
	    JedisPoolConfig poolConfig = new JedisPoolConfig();
	    poolConfig.setMaxTotal(redisMaxCon);
	    poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(poolConfig);
		jedisConFactory.setHostName(redisIp);
		logger.info("Jedis initialized {}",jedisConFactory);

		return jedisConFactory;
	}

	/**
	 * @return
	 */
	@Bean
	@Autowired
	public RedisTemplate<byte[],byte[]> redisTemplate() {
	    RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    logger.info("Rest Template initialized {}",template);
	    return template;
	}

	public String getNameServiceUrl() {
		return nameServiceUrl;
	}

	public void setNameServiceUrl(String nameServiceUrl) {
		this.nameServiceUrl = nameServiceUrl;
	}

	public String getRedisIp() {
		return redisIp;
	}

	public void setRedisIp(String redisIp) {
		this.redisIp = redisIp;
	}

	public Integer getRedisMaxCon() {
		return redisMaxCon;
	}

	public void setRedisMaxCon(Integer redisMaxCon) {
			this.redisMaxCon = redisMaxCon;
		
	}
	
	
}
