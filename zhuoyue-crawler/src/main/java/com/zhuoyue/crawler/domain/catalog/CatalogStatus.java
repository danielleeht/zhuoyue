package com.zhuoyue.crawler.domain.catalog;

/**
 * 图书爬虫信息收录状态
 * Created by lihaitao on 2016/10/19.
 */
public enum CatalogStatus {
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
    CATALOGED,
    /**
     * 已抓取条目详细信息
     */
    DETAILED
}
