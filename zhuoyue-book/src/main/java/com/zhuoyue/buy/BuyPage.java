package com.zhuoyue.buy;

import javax.persistence.Entity;

/**
 * 电商网站购买链接页面
 * Created by lihaitao on 2016/9/25.
 */
@Entity
public class BuyPage {

    private String merchant;
    private String bookId;
    private String link;
    private Double price;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
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
