/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PDutRunTesting generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`P_DUT_RUN_TESTING`")
public class PDutRunTesting implements Serializable {

    private BigInteger id;
    private BigInteger dutid;
    private BigInteger runid;
    private BigDecimal invalidrun;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(name = "`DUTID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getDutid() {
        return this.dutid;
    }

    public void setDutid(BigInteger dutid) {
        this.dutid = dutid;
    }

    @Column(name = "`RUNID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getRunid() {
        return this.runid;
    }

    public void setRunid(BigInteger runid) {
        this.runid = runid;
    }

    @Column(name = "`INVALIDRUN`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getInvalidrun() {
        return this.invalidrun;
    }

    public void setInvalidrun(BigDecimal invalidrun) {
        this.invalidrun = invalidrun;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PDutRunTesting)) return false;
        final PDutRunTesting pdutRunTesting = (PDutRunTesting) o;
        return Objects.equals(getId(), pdutRunTesting.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
