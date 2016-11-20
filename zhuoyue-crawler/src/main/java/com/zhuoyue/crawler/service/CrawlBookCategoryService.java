package com.zhuoyue.crawler.service;

import com.zhuoyue.crawler.jd.crawler.JdBookCategoryCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by lihaitao on 2016/10/25.
 */
@Service
public class CrawlBookCategoryService {

    private static final Logger log = LoggerFactory.getLogger(CrawlBookCategoryService.class);

    @Autowired
    private JdBookCategoryCrawler jdBookCategoryCrawler;


    @Scheduled(cron="0 0 3 * * ?")
    public void scheduleCatalogCrawl(){
        jdBookCategoryCrawler.doCrawl();
    }

}
