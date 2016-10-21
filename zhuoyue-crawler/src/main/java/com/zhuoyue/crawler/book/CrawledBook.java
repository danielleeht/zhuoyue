package com.zhuoyue.crawler.book;

import com.zhuoyue.crawler.book.author.BookAuthor;
import com.zhuoyue.crawler.book.category.BookCategory;
import com.zhuoyue.crawler.book.publisher.Publisher;
import com.zhuoyue.commons.AuditedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 图书主体信息（不包含互动信息）
 * Created by lihaitao on 2016/9/23.
 */
@Entity
@ApiModel(description = "图书主实体类")
public class CrawledBook extends AuditedEntity {

    @ApiModelProperty("封面图片")
    private String coverPicture;

    @Column(unique = true)
    @NotNull
    @Size(max=20)
	private String isbn;

    @NotNull
    @ApiModelProperty(value="书名")
    private String name;

    @ApiModelProperty(value="外文名称")
    private String foreignName;

    @ApiModelProperty(value="语言")
	private String language;

    @ManyToOne(fetch = FetchType.EAGER)
    @ApiModelProperty(value="书名")
    private BookCategory category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="BOOK_ID")
    @ApiModelProperty(value="作者")
	private Set<BookAuthor> authors;

    @ManyToMany
    @ApiModelProperty(value="出版社")
	private Set<Publisher> publishers;

    @ApiModelProperty(value="版次")
	private Integer publishNo;

    @ApiModelProperty(value="系列")
    private String series;

    @ApiModelProperty(value="是否套装")
    private Boolean isSuit;

    @ApiModelProperty(value="套装数量")
    private Integer suitCount;

    @ApiModelProperty(value="开本")
    private String format;

    @ApiModelProperty(value="尺寸")
    private String size;

    @ApiModelProperty(value="包装")
    private String packaging;

    @ApiModelProperty(value="页数")
    private Integer pages;

    @ApiModelProperty(value="用纸")
    private String pager;

    @ApiModelProperty(value="字数")
    private Integer wordCount;

    @ApiModelProperty(value="出版日期")
    private Date publishTime;

    @Embedded
    @ApiModelProperty(value="适读人群")
    private AgeScope ageScope;

    @ApiModelProperty(value="推荐信息")
    private String recommend;

    @ElementCollection
    @ApiModelProperty(value="书摘与插画")
    private List<String> inset;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="BOOK_ID")
    @ApiModelProperty(value="附加信息")
    private Set<BookExtra> bookExtras;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value="状态", hidden=true)
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

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Set<BookExtra> getBookExtras() {
        return bookExtras;
    }

    public void setBookExtras(Set<BookExtra> bookExtras) {
        this.bookExtras = bookExtras;
    }
}
