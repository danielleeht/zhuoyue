package com.zhuoyue.crawler.pipeline;

import com.zhuoyue.crawler.jd.pipeline.JDBookListPipeline;
import com.zhuoyue.crawler.task.CrawlerRecord;
import com.zhuoyue.crawler.task.CrawlerRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.Closeable;
import java.io.IOException;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/22.
 */
@Component
public class  CrawlerRecordPipelineFactory{

    @Autowired
    private CrawlerRecordRepository crawlerRecordRepository;

    public Pipeline createRecordPipeline(CrawlerRecord crawlerRecord){
        return new CrawlerRecordPipeline(crawlerRecord);
    }


    private class CrawlerRecordPipeline implements Pipeline, Closeable {

        private final Logger log = LoggerFactory.getLogger(CrawlerRecordPipeline.class);
        private CrawlerRecord crawlerRecord;

        public CrawlerRecordPipeline(CrawlerRecord crawlerRecord) {
            crawlerRecord.setStartTime(new Date());
            this.crawlerRecord = crawlerRecordRepository.save(crawlerRecord);
        }

        @Override
        public void close() throws IOException {
            log.info("Crawl finished 【{}】", crawlerRecord);
            this.crawlerRecord.setEndTime(new Date());
            crawlerRecordRepository.save(crawlerRecord);
        }

        @Override
        public void process(ResultItems resultItems, Task task) {

        }
    }
}

