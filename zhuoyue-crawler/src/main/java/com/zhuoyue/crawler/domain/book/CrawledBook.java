package com.zhuoyue.crawler.domain.book;

import com.zhuoyue.base.entity.BaseEntity;
import com.zhuoyue.crawler.domain.author.BookAuthor;
import com.zhuoyue.crawler.domain.publisher.Publisher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 图书主体信息（不包含互动信息）
 * Created by lihaitao on 2016/9/23.
 */
@Entity
@ApiModel(description = "图书主实体类")
public class CrawledBook extends BaseEntity {

    @ApiModelProperty("商品编号")
    @NotNull
    private String itemId;

    @ApiModelProperty("爬虫网站")
    @NotNull
    private String site;

    @ElementCollection
    @ApiModelProperty("封面图片")
    private List<String> coverPictures;

    @ApiModelProperty("作者（文本）")
    private String authorText;

    @ApiModelProperty("价格")
    @Column(precision = 8, scale = 2)
    private BigDecimal price;

    @ApiModelProperty("ISBN")
    @NotNull
	private String isbn;

    @NotNull
    @ApiModelProperty(value="书名")
    private String name;

    @ApiModelProperty(value="外文名称")
    private String foreignName;

    @ApiModelProperty(value="语言")
	private String language;

    @ApiModelProperty(value="图书分类")
    private String category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="CRAWLED_BOOK_ID")
    @ApiModelProperty(value="作者")
	private Set<BookAuthor> authors;

    @ApiModelProperty("出版社（文本）")
    private String publisherText;

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

    @ElementCollection
    @ApiModelProperty(value="书摘与插画")
    private List<String> inset;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="CRAWLED_BOOK_ID")
    @ApiModelProperty(value="附加信息")
    private Set<CrawledBookExtra> crawledBookExtras;

    @ApiModelProperty(value="状态")
    @Enumerated(EnumType.STRING)
    @NotNull
    private CrawledBookStatus crawledBookStatus;

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

    public String getPublisherText() {
        return publisherText;
    }

    public void setPublisherText(String publisherText) {
        this.publisherText = publisherText;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<CrawledBookExtra> getCrawledBookExtras() {
        return crawledBookExtras;
    }

    public void setCrawledBookExtras(Set<CrawledBookExtra> crawledBookExtras) {
        this.crawledBookExtras = crawledBookExtras;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<String> getCoverPictures() {
        return coverPictures;
    }

    public void setCoverPictures(List<String> coverPictures) {
        this.coverPictures = coverPictures;
    }

    public String getAuthorText() {
        return authorText;
    }

    public void setAuthorText(String authorText) {
        this.authorText = authorText;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CrawledBookStatus getCrawledBookStatus() {
        return crawledBookStatus;
    }

    public void setCrawledBookStatus(CrawledBookStatus crawledBookStatus) {
        this.crawledBookStatus = crawledBookStatus;
    }

    @Override
    public String toString() {
        return "CrawledBook{" +
            "itemId='" + itemId + '\'' +
            ", site='" + site + '\'' +
            ", coverPictures=" + coverPictures +
            ", authorText='" + authorText + '\'' +
            ", price=" + price +
            ", isbn='" + isbn + '\'' +
            ", name='" + name + '\'' +
            ", foreignName='" + foreignName + '\'' +
            ", language='" + language + '\'' +
            ", category=" + category +
            ", authors=" + authors +
            ", publisherText='" + publisherText + '\'' +
            ", publishers=" + publishers +
            ", publishNo=" + publishNo +
            ", series='" + series + '\'' +
            ", isSuit=" + isSuit +
            ", suitCount=" + suitCount +
            ", format='" + format + '\'' +
            ", packaging='" + packaging + '\'' +
            ", pages=" + pages +
            ", pager='" + pager + '\'' +
            ", wordCount=" + wordCount +
            ", publishTime=" + publishTime +
            ", ageScope=" + ageScope +
            ", inset=" + inset +
            ", crawledBookExtras=" + crawledBookExtras +
            ", crawledBookStatus=" + crawledBookStatus +
            '}';
    }
}
