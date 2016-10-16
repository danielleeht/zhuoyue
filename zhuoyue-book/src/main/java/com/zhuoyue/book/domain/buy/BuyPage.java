package com.zhuoyue.book.domain.buy;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.Entity;

/**
 * 电商网站购买链接页面
 * Created by lihaitao on 2016/9/25.
 */
@Entity
public class BuyPage extends BaseEntity {

    private String merchant;    //商家
    private Integer bookId;
    private String link;    //购买链接
    private Double price;   //价格

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
