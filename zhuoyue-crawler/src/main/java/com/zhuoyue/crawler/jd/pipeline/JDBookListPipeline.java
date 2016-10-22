package com.zhuoyue.crawler.jd.pipeline;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhuoyue.crawler.jd.handler.JDBookItemCrawler;
import com.zhuoyue.crawler.jd.model.JDBookList;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component
public class JDBookListPipeline implements PageModelPipeline<JDBookList>, Closeable {

    private static final Logger log = LoggerFactory.getLogger(JDBookListPipeline.class);


    @Autowired
    JDBookItemCrawler bookItemCrawler;

    @Override
    public void process(JDBookList bookList, Task task) {
        log.info("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.info("resultItem = {}", bookList);

//        bookListRepository.save(bookList);

    }

	@Override
	public void close() throws IOException {
		log.info("JD book list crawl finished, start crawl details");
	}
}
