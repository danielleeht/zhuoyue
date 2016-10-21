package com.zhuoyue.crawler.jd.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component
public class JDBookItemPipeline implements PageModelPipeline {

    private static final Logger log = LoggerFactory.getLogger(JDBookItemPipeline.class);

    @Autowired
    MongoTemplate mongoTemplate;



    @Override
    public void process(Object o, Task task) {
        log.debug("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.debug("resultItem = {}", o);

        mongoTemplate.save(o);

    }
}
