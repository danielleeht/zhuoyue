package com.zhuoyue.crawler.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.UnknownHostException;
import java.util.Properties;

/**
 * Created by lihaitao on 2016/11/3.
 */
@Configuration
@EnableSwagger2
@Import({ SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {

//    @Bean
//    public static PropertyPlaceholderConfigurer swaggerProperties() throws UnknownHostException {
//
//        // Swagger expects these to property values to be replaced. We don't want to propagate these to consumers of
//        // this configuration, so we derive reasonable defaults here and configure the properties programmatically.
//        Properties properties = new Properties();
//        properties.setProperty("documentation.services.basePath", servletContext.getContextPath());
//        // this property will be overridden at runtime, so the value here doesn't matter
//        properties.setProperty("documentation.services.version", "REPLACE-ME");
//
//        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
//        configurer.setProperties(properties);
//        configurer.setIgnoreUnresolvablePlaceholders(true);
//        return configurer;
//    }

}
