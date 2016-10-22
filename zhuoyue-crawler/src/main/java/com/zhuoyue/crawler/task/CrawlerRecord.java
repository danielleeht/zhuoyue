package com.zhuoyue.crawler.task;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/19.
 */
@Entity
@ApiModel(description = "爬虫记录")
public class CrawlerRecord extends BaseEntity {

    private CrawlerType crawlerType;

    private Date crawlDate;

    private Date startTime;

    private Date endTime;

    public CrawlerRecord() {
    }

    public CrawlerRecord(CrawlerType crawlerType, Date crawlDate) {
        this.crawlerType = crawlerType;
        this.crawlDate = crawlDate;
    }

    public CrawlerType getCrawlerType() {
        return crawlerType;
    }

    public void setCrawlerType(CrawlerType crawlerType) {
        this.crawlerType = crawlerType;
    }

    public Date getCrawlDate() {
        return crawlDate;
    }

    public void setCrawlDate(Date crawlDate) {
        this.crawlDate = crawlDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CrawlerRecord{" +
            "crawlerType=" + crawlerType +
            ", crawlDate=" + crawlDate +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            '}';
    }
}
