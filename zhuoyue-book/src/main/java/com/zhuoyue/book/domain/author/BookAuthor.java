package com.zhuoyue.book.domain.author;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.*;

/**
 * 图书作者信息，与作者实体关联
 * Created by lihaitao on 2016/9/25.
 */
@Entity
public class BookAuthor extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @Enumerated(EnumType.STRING)
    private BookAuthorType bookAuthorType;
}
