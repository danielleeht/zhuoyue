package com.zhuoyue.crowler.book.domain.buy;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

/**
 * 电商网站购买链接页面
 * Created by lihaitao on 2016/9/25.
 */
@Entity
@ApiModel(description = "图书购买链接")
public class BuyPage extends BaseEntity {

    @ApiModelProperty(value="商家")
    private String merchant;

    @ApiModelProperty(value="图书Id")
    private Integer bookId;

    @ApiModelProperty(value="购买链接")
    private String link;

    @ApiModelProperty(value="价格")
    private Double price;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
