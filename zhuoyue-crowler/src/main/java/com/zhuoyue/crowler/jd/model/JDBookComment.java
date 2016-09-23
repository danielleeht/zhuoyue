package com.zhuoyue.crowler.jd.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zhuoyue.crowler.CrawlerSource;
import com.zhuoyue.crowler.SubEntityFormatter;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.Formatter;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@Document(collection = "jd_book_comment")
@TargetUrl(value = "http://sclub.jd.com/productpage/p-\\d+-s-0-t-3-p-0.html", sourceRegion="no")
@ExtractBy(value = "//pre/text()")
public class JDBookComment {

	@Id
	private String id;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.productId")
	private String itemId;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.generalCount")
	private Integer generalCount;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.goodCount")
	private Integer goodCount;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.poorCount")
	private Integer poorCount;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.score1Count")
	private Integer score1Count;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.score2Count")
	private Integer score2Count;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.score3Count")
	private Integer score3Count;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.score4Count")
	private Integer score4Count;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.productCommentSummary.score5Count")
	private Integer score5Count;

	@Formatter(value="com.zhuoyue.crowler.jd.model.JDCommentTag", formatter=SubEntityFormatter.class)
	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.hotCommentTagStatistics")
	private List<JDCommentTag> tags;

	private String site = CrawlerSource.jd.getType();

	private Date updateTime = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.id = "JD"+itemId;
		this.itemId = itemId;
	}

	public Integer getGeneralCount() {
		return generalCount;
	}

	public void setGeneralCount(Integer generalCount) {
		this.generalCount = generalCount;
	}

	public Integer getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}

	public Integer getPoorCount() {
		return poorCount;
	}

	public void setPoorCount(Integer poorCount) {
		this.poorCount = poorCount;
	}

	public Integer getScore1Count() {
		return score1Count;
	}

	public void setScore1Count(Integer score1Count) {
		this.score1Count = score1Count;
	}

	public Integer getScore2Count() {
		return score2Count;
	}

	public void setScore2Count(Integer score2Count) {
		this.score2Count = score2Count;
	}

	public Integer getScore3Count() {
		return score3Count;
	}

	public void setScore3Count(Integer score3Count) {
		this.score3Count = score3Count;
	}

	public Integer getScore4Count() {
		return score4Count;
	}

	public void setScore4Count(Integer score4Count) {
		this.score4Count = score4Count;
	}

	public Integer getScore5Count() {
		return score5Count;
	}

	public void setScore5Count(Integer score5Count) {
		this.score5Count = score5Count;
	}

	public List<JDCommentTag> getTags() {
		return tags;
	}

	public void setTags(List<JDCommentTag> tags) {
		this.tags = tags;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "JDBookComment [id=" + id + ", itemId=" + itemId + ", generalCount=" + generalCount + ", goodCount="
				+ goodCount + ", poorCount=" + poorCount + ", score1Count=" + score1Count + ", score2Count="
				+ score2Count + ", score3Count=" + score3Count + ", score4Count=" + score4Count + ", score5Count="
				+ score5Count + ", tags=" + tags + ", site=" + site + ", updateTime=" + updateTime + "]";
	}


}
