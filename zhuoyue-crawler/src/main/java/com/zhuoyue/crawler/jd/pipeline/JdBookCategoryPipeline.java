package com.zhuoyue.crawler.jd.pipeline;

import com.zhuoyue.crawler.domain.category.BookCategoryMapping;
import com.zhuoyue.crawler.domain.category.BookCategoryMappingRepository;
import com.zhuoyue.crawler.domain.category.CrawlStatus;
import com.zhuoyue.crawler.jd.model.JdBookCategory;
import com.zhuoyue.crawler.utils.CrawlerSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.Date;

@Component
public class JdBookCategoryPipeline implements PageModelPipeline<JdBookCategory> {

    private static final Logger log = LoggerFactory.getLogger(JdBookCategoryPipeline.class);
    private static final Integer PAGE_SIZE = 60;

    private BookCategoryMappingRepository bookCategoryMappingRepository;

    @Override
    public void process(JdBookCategory jdBookCategory, Task task) {
        log.info("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.info("resultItem = {}", jdBookCategory);

        BookCategoryMapping bookCategoryMapping = new BookCategoryMapping();
        bookCategoryMapping.setCategory(jdBookCategory.getCategory());
        bookCategoryMapping.setItemId(jdBookCategory.getItemId());
        bookCategoryMapping.setNormalCategory(jdBookCategory.getNormalCategory());
        bookCategoryMapping.setSite(CrawlerSource.jd.getType());
        if ( bookCategoryMappingRepository.findOne(Example.of(bookCategoryMapping)) == null ){
            bookCategoryMapping.setCrawlStatus(CrawlStatus.CRAWLED);
            bookCategoryMapping.setCrawlDate(new Date());
            bookCategoryMapping = bookCategoryMappingRepository.save(bookCategoryMapping);

            log.info("新增图书分类信息：{}", bookCategoryMapping);
        }

    }

}
