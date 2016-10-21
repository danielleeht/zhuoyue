package com.zhuoyue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zhuoyue.crawler.jd.handler.JDBookItemCrawler;
import com.zhuoyue.crawler.jd.handler.JDBookListCrawler;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableCaching
@EnableSwagger2
@Import({ SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class CrawlerApplication implements CommandLineRunner {

	@Autowired
    JDBookListCrawler JDBookListCrawler;

	@Autowired
    JDBookItemCrawler JDBookItemCrawler;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CrawlerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JDBookListCrawler.doCrawl();
	}
}
