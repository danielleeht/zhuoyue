package com.zhuoyue.crawler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Value("${spring.redis.host}")
    private String redisHost;


    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

        redisConnectionFactory.setHostName(redisHost);
        redisConnectionFactory.setPort(redisPort);

        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(3000);
        return cacheManager;
    }

    @Bean
    public RedisLockRegistry userLockRegistry() {
        JedisConnectionFactory jedisConnectionFactory = redisConnectionFactory();
        return new RedisLockRegistry(jedisConnectionFactory, "zhuoyue-crawler");
    }
}
