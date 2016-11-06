package com.zhuoyue.crawler.jd.handler;

import com.zhuoyue.crawler.domain.category.CrawlBookCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lihaitao on 2016/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class JdBookCategoryCrawlerTest {

    @Autowired
    private JdBookCategoryCrawler jdBookCategoryCrawler;

    @Test
    public void doCrawl() throws Exception {
        jdBookCategoryCrawler.doCrawl();
    }

    @Test
    public void testCrawlCategories(){
        List<CrawlBookCategory> bookCategories = jdBookCategoryCrawler.findCrawlBookCategories();

        for(CrawlBookCategory bookCategory: bookCategories){
            List<CrawlBookCategory> normalCategories = jdBookCategoryCrawler.findNormalBookCategories(bookCategory.getCategoryString());
        }
    }

}
