package com.zhuoyue.crawler.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by lihaitao on 2016/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CrawlBookCatalogServiceTest {

    @Autowired
    CrawlBookCatalogService crawlBookCatalogService;

    @Test
    public void scheduleCatalogCrawl() throws Exception {
        crawlBookCatalogService.scheduleCatalogCrawl();
    }

}
