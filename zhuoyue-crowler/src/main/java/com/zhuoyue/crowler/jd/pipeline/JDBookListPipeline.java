package com.zhuoyue.crowler.jd.pipeline;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhuoyue.crowler.jd.handler.JDBookItemCrowler;
import com.zhuoyue.crowler.jd.model.JDBookList;
import com.zhuoyue.crowler.jd.repository.JDBookListRepository;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component
public class JDBookListPipeline implements PageModelPipeline<JDBookList>, Closeable {

    private static final Logger log = LoggerFactory.getLogger(JDBookListPipeline.class);

    @Autowired
    JDBookListRepository bookListRepository;

    @Autowired
    JDBookItemCrowler bookItemCrowler;

    @Override
    public void process(JDBookList bookList, Task task) {
        log.debug("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.debug("resultItem = {}", bookList);

        bookListRepository.save(bookList);

    }

	@Override
	public void close() throws IOException {
		log.debug("JD book list crowl finished, start crowl details");
//		bookItemCrowler.doCrowl();
	}
}
