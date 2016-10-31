package com.zhuoyue.crawler.domain.book;

/**
 * Created by lihaitao on 2016/9/25.
 */
public enum CrawledBookStatus {
    CRAWLED,//只完成爬取
    PROCESSED,//完成数据加工
    FULFILLED,//加工后数据包含完整信息
    DELETED
}
