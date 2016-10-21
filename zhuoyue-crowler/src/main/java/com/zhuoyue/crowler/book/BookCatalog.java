package com.zhuoyue.crowler.book;

import com.zhuoyue.commons.BaseEntity;
import com.zhuoyue.crowler.CrawlerSource;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/19.
 */
@Entity
@ApiModel(description = "图书爬虫目录信息")
public class BookCatalog extends BaseEntity {


    private String taskId;

    private String bookId;

    private String itemId;

    private String cover;

    private String name;

    private String site = CrawlerSource.jd.getType();

    private String shopName;

    private Date crawledDate;

    private RecordStatus recordStatus;

    private Date recordDate;



}
