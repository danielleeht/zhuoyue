package com.zhuoyue.book.domain.tag;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
public class BookTag extends BaseEntity {

    private Integer bookId;
    private String user;
    private String tag;
    private Date tagedDate;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getTagedDate() {
        return tagedDate;
    }

    public void setTagedDate(Date tagedDate) {
        this.tagedDate = tagedDate;
    }
}
