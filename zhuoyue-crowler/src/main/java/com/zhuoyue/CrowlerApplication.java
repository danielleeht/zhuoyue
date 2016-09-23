package com.zhuoyue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zhuoyue.crowler.jd.handler.JDBookItemCrowler;
import com.zhuoyue.crowler.jd.handler.JDBookListCrowler;

@SpringBootApplication
public class CrowlerApplication implements CommandLineRunner {

	@Autowired
	JDBookListCrowler JDBookListCrowler;

	@Autowired
	JDBookItemCrowler JDBookItemCrowler;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CrowlerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JDBookListCrowler.doCrowl();
	}
}
