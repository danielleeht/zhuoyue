package com.zhuoyue.book.domain;

import com.zhuoyue.book.domain.author.BookAuthor;
import com.zhuoyue.book.domain.category.BookCategory;
import com.zhuoyue.book.domain.publisher.Publisher;
import com.zhuoyue.commons.AuditedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 图书主体信息（不包含互动信息）
 * Created by lihaitao on 2016/9/23.
 */
@Entity
public class Book extends AuditedEntity {

    private String coverPicture;	//封面图片

    @Column(unique = true)
    @NotNull
	private String isbn;

    @NotNull
    private String name;	//书名

    private String foreignName;	//外文名称
	private String language;	//语言

    @ManyToOne(fetch = FetchType.EAGER)
    private BookCategory category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="BOOK_ID") // join column is in table for Order
	private Set<BookAuthor> authors;   //作者

    @ManyToMany
	private Set<Publisher> publishers;	//出版社
	private Integer publishNo;	//版次
    private String series;	//系列
    private Boolean isSuit; //是否套装
    private Integer suitCount;    //套装数量
    private String format;	//开本
    private String size;    //尺寸
    private String packaging;	//包装
    private Integer pages;	//页数
    private String pager;	//用纸
    private Integer wordCount;  //字数
    private Date publishTime;	//出版日期

    @Embedded
    private AgeScope ageScope;	//适读人群
    private String characteristic;	//特色
    private String recommend;	//编辑推荐
    private String introduction;	//内容简介
    private String authorIntro;	//作者简介
    private String bookReview;	//专家评论
    private String toc;	//目录
    private String excerpt;	//精彩书摘
    private String preface;	//前言/序言

    @ElementCollection
    private List<String> inset;	//书摘与插画

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<BookAuthor> authors) {
        this.authors = authors;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Integer getPublishNo() {
        return publishNo;
    }

    public void setPublishNo(Integer publishNo) {
        this.publishNo = publishNo;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Boolean getSuit() {
        return isSuit;
    }

    public void setSuit(Boolean suit) {
        isSuit = suit;
    }

    public Integer getSuitCount() {
        return suitCount;
    }

    public void setSuitCount(Integer suitCount) {
        this.suitCount = suitCount;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public AgeScope getAgeScope() {
        return ageScope;
    }

    public void setAgeScope(AgeScope ageScope) {
        this.ageScope = ageScope;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public String getBookReview() {
        return bookReview;
    }

    public void setBookReview(String bookReview) {
        this.bookReview = bookReview;
    }

    public String getToc() {
        return toc;
    }

    public void setToc(String toc) {
        this.toc = toc;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public List<String> getInset() {
        return inset;
    }

    public void setInset(List<String> inset) {
        this.inset = inset;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }



}
