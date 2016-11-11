package com.zhuoyue.book.domain.tag;

import com.zhuoyue.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
@ApiModel(description = "图书Tag信息")
public class BookTag extends BaseEntity {

    @ApiModelProperty(value="图书ID")
    private Integer bookId;

    @ApiModelProperty(value="用户")
    private String user;

    @ApiModelProperty(value="标签")
    private String tag;

    @ApiModelProperty(value="标记日期")
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
