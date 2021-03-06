/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * RecycleTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`RECYCLE_TABLE`")
public class RecycleTable implements Serializable {

    private BigDecimal idRecycle;
    private String triggeredBy;
    @Type(type = "DateTime")
    private LocalDateTime triggeredTime;
    private BigDecimal statusId;
    private BigDecimal idDeletedEngine;
    private BigDecimal idDeletedBuild;

    @Id
    @Column(name = "`ID_RECYCLE`", nullable = false, scale = 9, precision = 22)
    public BigDecimal getIdRecycle() {
        return this.idRecycle;
    }

    public void setIdRecycle(BigDecimal idRecycle) {
        this.idRecycle = idRecycle;
    }

    @Column(name = "`TRIGGERED_BY`", nullable = true, length = 128)
    public String getTriggeredBy() {
        return this.triggeredBy;
    }

    public void setTriggeredBy(String triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    @Column(name = "`TRIGGERED_TIME`", nullable = true)
    public LocalDateTime getTriggeredTime() {
        return this.triggeredTime;
    }

    public void setTriggeredTime(LocalDateTime triggeredTime) {
        this.triggeredTime = triggeredTime;
    }

    @Column(name = "`STATUS_ID`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getStatusId() {
        return this.statusId;
    }

    public void setStatusId(BigDecimal statusId) {
        this.statusId = statusId;
    }

    @Column(name = "`ID_DELETED_ENGINE`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getIdDeletedEngine() {
        return this.idDeletedEngine;
    }

    public void setIdDeletedEngine(BigDecimal idDeletedEngine) {
        this.idDeletedEngine = idDeletedEngine;
    }

    @Column(name = "`ID_DELETED_BUILD`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getIdDeletedBuild() {
        return this.idDeletedBuild;
    }

    public void setIdDeletedBuild(BigDecimal idDeletedBuild) {
        this.idDeletedBuild = idDeletedBuild;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecycleTable)) return false;
        final RecycleTable recycleTable = (RecycleTable) o;
        return Objects.equals(getIdRecycle(), recycleTable.getIdRecycle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRecycle());
    }
}

