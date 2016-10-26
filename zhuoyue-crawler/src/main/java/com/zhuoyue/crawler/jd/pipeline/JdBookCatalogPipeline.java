package com.zhuoyue.crawler.jd.pipeline;

import java.io.Closeable;
import java.io.IOException;
import java.util.Date;

import com.zhuoyue.crawler.domain.book.BookCatalog;
import com.zhuoyue.crawler.domain.book.BookCatalogRepository;
import com.zhuoyue.crawler.domain.book.DailyBookCatalog;
import com.zhuoyue.crawler.domain.book.DailyBookCatalogRepository;
import com.zhuoyue.crawler.utils.CrawlerSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhuoyue.crawler.jd.model.JdBookCatalog;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component
public class JdBookCatalogPipeline implements PageModelPipeline<JdBookCatalog> {

    private static final Logger log = LoggerFactory.getLogger(JdBookCatalogPipeline.class);
    private static final Integer PAGE_SIZE = 60;

    @Autowired
    private DailyBookCatalogRepository dailyBookCatalogRepository;

    @Override
    public void process(JdBookCatalog jdBookCatalog, Task task) {
        log.info("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.info("resultItem = {}", jdBookCatalog);

        DailyBookCatalog dailyBookCatalog = new DailyBookCatalog();

        dailyBookCatalog.setTaskId(task.getUUID());
        dailyBookCatalog.setCover(jdBookCatalog.getCover());
        dailyBookCatalog.setItemId(jdBookCatalog.getItemId());
        dailyBookCatalog.setName(jdBookCatalog.getName());
        dailyBookCatalog.setCatalog(jdBookCatalog.getCategory());

        Integer pageNo = StringUtils.isEmpty(jdBookCatalog.getPageNo())?
            1 : Integer.parseInt(jdBookCatalog.getPageNo());
        Integer pageRank = StringUtils.isEmpty(jdBookCatalog.getDataId())?
            0 : Integer.parseInt(jdBookCatalog.getDataId());
        dailyBookCatalog.setRank(PAGE_SIZE*(pageNo-1) + pageRank);
        dailyBookCatalog.setCrawledDate(new Date());
        dailyBookCatalog.setSite(CrawlerSource.jd.getType());
        dailyBookCatalog.setShopName(jdBookCatalog.getShopName());

        dailyBookCatalogRepository.save(dailyBookCatalog);
    }

}
