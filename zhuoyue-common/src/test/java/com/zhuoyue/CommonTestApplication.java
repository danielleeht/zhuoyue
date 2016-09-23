package com.zhuoyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by Tomasz Kucharzyk
 */

@SpringBootApplication
@EnableCaching
public class CommonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonTestApplication.class, args);
    }

}
