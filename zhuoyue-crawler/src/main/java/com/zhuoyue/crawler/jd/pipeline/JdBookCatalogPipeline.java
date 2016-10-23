package com.zhuoyue.crawler.jd.pipeline;

import java.io.Closeable;
import java.io.IOException;
import java.util.Date;

import com.zhuoyue.crawler.domain.book.BookCatalog;
import com.zhuoyue.crawler.domain.book.BookCatalogRepository;
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
public class JdBookCatalogPipeline implements PageModelPipeline<JdBookCatalog>, Closeable {

    private static final Logger log = LoggerFactory.getLogger(JdBookCatalogPipeline.class);
    private static final Integer PAGE_SIZE = 60;

    @Autowired
    private BookCatalogRepository bookCatalogRepository;

    @Override
    public void process(JdBookCatalog jdBookCatalog, Task task) {
        log.info("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.info("resultItem = {}", jdBookCatalog);

        BookCatalog bookCatalog = new BookCatalog();

        bookCatalog.setTaskId(task.getUUID());
        bookCatalog.setCover(jdBookCatalog.getCover());
        bookCatalog.setItemId(jdBookCatalog.getItemId());
        bookCatalog.setName(jdBookCatalog.getName());

        Integer pageNo = StringUtils.isEmpty(jdBookCatalog.getPageNo())?
            1 : Integer.parseInt(jdBookCatalog.getPageNo());
        Integer pageRank = StringUtils.isEmpty(jdBookCatalog.getDataId())?
            0 : Integer.parseInt(jdBookCatalog.getDataId());
        bookCatalog.setRank(PAGE_SIZE*(pageNo-1) + pageRank);
        bookCatalog.setCrawledDate(new Date());
        bookCatalog.setSite(CrawlerSource.jd.getType());
        bookCatalog.setShopName(jdBookCatalog.getShopName());

        bookCatalogRepository.save(bookCatalog);
    }

	@Override
	public void close() throws IOException {
		log.info("JD book list crawl finished, start crawl details");
	}
}
