package com.zhuoyue.crowler.book.domain.comment;

import com.zhuoyue.commons.AuditedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
@ApiModel(description = "图书评论")
public class BookComment extends AuditedEntity {

    @ApiModelProperty(value="图书Id")
    private Integer bookId;

    @ApiModelProperty(value="回复评论")
    private Integer pid;

    @ApiModelProperty(value="评论用户")
    private String user;

    @ApiModelProperty(value="评论内容")
    private String comment;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value="评论状态")
    private CommentStatus commentStatus;

    @ApiModelProperty(value="赞成数")
    private Integer voteUp;

    @ApiModelProperty(value="反对数")
    private Integer voteDown;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentStatus getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatus commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(Integer voteUp) {
        this.voteUp = voteUp;
    }

    public Integer getVoteDown() {
        return voteDown;
    }

    public void setVoteDown(Integer voteDown) {
        this.voteDown = voteDown;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
