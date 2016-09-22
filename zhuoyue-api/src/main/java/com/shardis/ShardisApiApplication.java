package com.shardis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Tomasz Kucharzyk
 */
@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableCaching
public class ShardisApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardisApiApplication.class, args);
    }

}
