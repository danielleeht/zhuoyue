package com.zhuoyue.author;

import com.zhuoyue.commons.BaseEntity;

/**
 * 图书作者信息，与作者实体关联
 * Created by lihaitao on 2016/9/25.
 */
public class BookAuthor extends BaseEntity {

    private Author author;
    private BookAuthorType bookAuthorType;
}
