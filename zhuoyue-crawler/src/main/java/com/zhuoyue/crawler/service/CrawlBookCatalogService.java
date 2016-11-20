package com.zhuoyue.crawler.service;

import com.zhuoyue.crawler.domain.catalog.CatalogStatus;
import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.jd.crawler.JdBookCatalogCrawler;
import com.zhuoyue.crawler.jd.crawler.JdBookItemCrawler;
import com.zhuoyue.crawler.event.CrawlEndEvent;
import com.zhuoyue.crawler.utils.CrawlerSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by lihaitao on 2016/10/25.
 */
@Service
public class CrawlBookCatalogService {

    private static final Logger log = LoggerFactory.getLogger(CrawlBookCatalogService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdBookItemCrawler jdBookItemCrawler;

    @Autowired
    private JdBookCatalogCrawler jdBookCatalogCrawler;

    private void addBookCatalog(String taskId){
        log.info("Begin transfer new book catalog to fact table");

        jdbcTemplate.update("INSERT INTO book_catalog (item_id, name, cover, shop_name, site, category, crawled_date, catalog_status)" +
            " SELECT item_id, name, cover, shop_name, site, category, crawled_date, ? FROM daily_book_catalog D" +
            " WHERE NOT EXISTS(SELECT 1 FROM book_catalog B WHERE B.item_id=D.item_id AND B.site=D.site)" +
            " AND D.task_id=?", CatalogStatus.CATALOGED.name(), taskId);

    }

    public void deleteDailyCatalog(String site){
        jdbcTemplate.update("delete from daily_book_catalog where site = ?", site);
    }

    @Scheduled(cron="0 0 0 * * ?")
    public void scheduleCatalogCrawl(){
        this.deleteDailyCatalog(CrawlerSource.jd.getType());
        jdBookCatalogCrawler.doCrawl();
    }

    @EventListener(condition="#crawlEndEvent.crawlerType.equals(T(com.zhuoyue.crawler.utils.CrawlerType).JDCATALOG)")
    public void afterCatalogCrawl(CrawlEndEvent crawlEndEvent){

        CrawlerRecord record = (CrawlerRecord)crawlEndEvent.getSource();
        String taskId = record.getId()+"";

        this.addBookCatalog(taskId);

        jdBookItemCrawler.doCrawl();

    }
}
