package com.zhuoyue.crawler.jd.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component
public class JdBookItemPipeline implements PageModelPipeline {

    private static final Logger log = LoggerFactory.getLogger(JdBookItemPipeline.class);




    @Override
    public void process(Object o, Task task) {
        log.info("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.info("resultItem = {}", o);


    }
}
