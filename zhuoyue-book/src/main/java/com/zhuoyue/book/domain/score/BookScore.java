package com.zhuoyue.book.domain.score;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
public class BookScore extends BaseEntity {
    private Integer bookId;
    private String user;
    private Integer score;
    private Date scoreDate;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }
}
