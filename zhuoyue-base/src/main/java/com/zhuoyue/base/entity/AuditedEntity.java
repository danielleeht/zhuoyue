package com.zhuoyue.base.entity;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

/**
 * 支持审计信息的实体基类
 */
@Audited
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditedEntity extends BaseEntity {

    @CreatedDate
    protected Date createdDate;

    @CreatedBy
    protected String createdBy;

    @LastModifiedDate
    protected Date updatedDate;

    @LastModifiedBy
    protected String updatedBy;

    @Version
    protected Long version;

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Long getVersion() {
        return version;
    }
}
