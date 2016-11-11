package com.zhuoyue.book.domain.score;

import com.zhuoyue.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
@ApiModel(description = "图书评分")
public class BookScore extends BaseEntity {

    @ApiModelProperty(value="图书ID")
    private Integer bookId;

    @ApiModelProperty(value="用户")
    private String user;

    @ApiModelProperty(value="分数")
    private Integer score;

    @ApiModelProperty(value="评分日期")
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
