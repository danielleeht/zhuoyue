package com.zhuoyue.crawler.task;

import com.zhuoyue.commons.BaseEntity;
import com.zhuoyue.crawler.CrawlerSource;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;

/**
 * Created by lihaitao on 2016/10/19.
 */
@Entity
@ApiModel(description = "爬虫任务定义")
public class CrawlerDefinition extends BaseEntity {

    private String source = CrawlerSource.jd.getType();

    private CrawlerType crawlerType;

    private Integer threadNum;

    private Integer retryTimes;

    private Integer sleepTime;

    private String cron;
}
