package com.zhuoyue.book.domain.author;

import com.zhuoyue.commons.BaseEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * 图书作者信息，与作者实体关联
 * Created by lihaitao on 2016/9/25.
 */
@Entity
public class BookAuthor extends BaseEntity {

    private String name;    //姓名

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action= NotFoundAction.IGNORE)
    private Author author;

    @Enumerated(EnumType.STRING)
    private BookAuthorType bookAuthorType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookAuthorType getBookAuthorType() {
        return bookAuthorType;
    }

    public void setBookAuthorType(BookAuthorType bookAuthorType) {
        this.bookAuthorType = bookAuthorType;
    }
}
