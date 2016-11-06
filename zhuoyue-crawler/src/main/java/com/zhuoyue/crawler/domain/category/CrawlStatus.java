package com.zhuoyue.crawler.domain.category;

/**
 * 图书爬虫信息收录状态
 * Created by lihaitao on 2016/10/19.
 */
public enum CrawlStatus {
    /**
     * 已收录
     */
    RECORDED,
    /**
     * 放弃收录
     */
    ABANDONED,
    /**
     * 爬虫完成
     */
    CRAWLED
}
