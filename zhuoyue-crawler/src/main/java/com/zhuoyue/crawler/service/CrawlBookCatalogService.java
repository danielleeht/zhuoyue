package com.zhuoyue.crawler.service;

import com.zhuoyue.crawler.domain.CatalogStatus;
import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.jd.handler.JdBookItemCrawler;
import com.zhuoyue.crawler.pipeline.CrawlEndEvent;
import com.zhuoyue.crawler.utils.CrawlerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lihaitao on 2016/10/25.
 */
@Service
public class CrawlBookCatalogService {

    private static final Logger log = LoggerFactory.getLogger(CrawlBookCatalogService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBookCatalog(String taskId){
        log.info("Begin transfer new book catalog to fact table");

        jdbcTemplate.update("INSERT INTO book_catalog (item_id, name, shop_name, site, crawled_date, catalog_status)" +
            " SELECT item_id, name, shop_name, site, crawled_date, ? FROM daily_book_catalog D" +
            " WHERE NOT EXISTS(SELECT 1 FROM book_catalog B WHERE B.item_id=D.item_id AND B.site=D.site)" +
            " AND D.task_id=?", CatalogStatus.CATALOGED.name(), taskId);

    }

    public void deleteDailyCatalog(String site){
        jdbcTemplate.update("delete from daily_book_catalog where site = ?", site);
    }
}
