package com.zhuoyue.crawler.domain;

/**
 * 图书爬虫信息收录状态
 * Created by lihaitao on 2016/10/19.
 */
public enum RecordStatus {
    RECORDED,   //已收录
    ABANDONED,  //放弃收录
    CATALOGED,  //编目爬虫生产
    DETAILED    //已抓取条目详细信息
}
