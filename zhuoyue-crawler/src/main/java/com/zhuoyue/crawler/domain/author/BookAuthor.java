package com.zhuoyue.crawler.domain.author;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 图书作者信息，与作者实体关联
 * Created by lihaitao on 2016/9/25.
 */
@Entity
@ApiModel(description = "图书相关作者信息")
public class BookAuthor extends BaseEntity {

    @ApiModelProperty("作者姓名")
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action= NotFoundAction.IGNORE)
    @ApiModelProperty("作者档案")
    private Author author;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty("作者类型，作、绘、编、译、校等")
    @NotNull
    private BookAuthorType bookAuthorType;

    @ApiModelProperty("顺序号")
    @NotNull
    private Integer number;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
