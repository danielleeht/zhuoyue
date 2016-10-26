package com.zhuoyue.crawler.jd.pipeline;

import com.zhuoyue.crawler.jd.model.JdBookCatalog;
import com.zhuoyue.crawler.jd.model.JdBookItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component
public class JdBookItemPipeline implements PageModelPipeline<JdBookItem> {

    private static final Logger log = LoggerFactory.getLogger(JdBookItemPipeline.class);




    @Override
    public void process(JdBookItem jdBookItem, Task task) {
        log.info("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.info("resultItem = {}", jdBookItem);


    }
}
