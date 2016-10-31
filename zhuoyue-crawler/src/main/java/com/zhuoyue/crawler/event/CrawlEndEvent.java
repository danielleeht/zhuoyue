package com.zhuoyue.crawler.event;

import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.utils.CrawlerType;

import java.util.Date;
import java.util.EventObject;

/**
 * Created by lihaitao on 2016/10/23.
 */
public class CrawlEndEvent extends EventObject {

    private final CrawlerType crawlerType;

    private final Date crawlDate;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CrawlEndEvent(CrawlerRecord source) {
        super(source);
        this.crawlerType = source.getCrawlerType();
        this.crawlDate = source.getCrawlDate();
    }

    public CrawlerType getCrawlerType() {
        return crawlerType;
    }

    public Date getCrawlDate() {
        return crawlDate;
    }
}
