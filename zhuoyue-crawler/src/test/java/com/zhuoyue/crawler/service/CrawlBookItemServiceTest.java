package com.zhuoyue.crawler.service;

import com.zhuoyue.crawler.domain.book.CrawledBook;
import com.zhuoyue.crawler.domain.book.CrawledBookRepository;
import com.zhuoyue.crawler.domain.book.CrawledBookStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daniel on 2016/11/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CrawlBookItemServiceTest {

    @Autowired
    private CrawledBookRepository crawledBookRepository;

    @Autowired
    private CrawlBookItemService crawlBookItemService;

    @Test
    public void processAll() throws Exception {
        List<CrawledBook> crawledBookList = crawledBookRepository.findAll();

        for(CrawledBook crawledBook : crawledBookList){
            crawlBookItemService.processBookItem(crawledBook);
        }
    }

}
