package com.zhuoyue.crawler;

import com.zhuoyue.CommonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@Import({CommonConfiguration.class})
public class CrawlerApplication {


	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CrawlerApplication.class, args);
	}

}
