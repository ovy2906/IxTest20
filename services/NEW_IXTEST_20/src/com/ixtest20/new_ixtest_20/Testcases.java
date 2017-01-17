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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * Testcases generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TESTCASES`")
public class Testcases implements Serializable {

    private BigInteger testcaseid;
    private String testcasename;
    private String testcasedescription;
    private BigInteger productid;
    private BigInteger engineid;
    private BigInteger testcaseownerid;
    private BigInteger testcaseauthorid;
    @Type(type = "DateTime")
    private LocalDateTime created;
    private BigInteger ixtestcaseid;
    private BigDecimal invalid;

    @Id
    @Column(name = "`TESTCASEID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getTestcaseid() {
        return this.testcaseid;
    }

    public void setTestcaseid(BigInteger testcaseid) {
        this.testcaseid = testcaseid;
    }

    @Column(name = "`TESTCASENAME`", nullable = true, length = 256)
    public String getTestcasename() {
        return this.testcasename;
    }

    public void setTestcasename(String testcasename) {
        this.testcasename = testcasename;
    }

    @Column(name = "`TESTCASEDESCRIPTION`", nullable = true, length = 256)
    public String getTestcasedescription() {
        return this.testcasedescription;
    }

    public void setTestcasedescription(String testcasedescription) {
        this.testcasedescription = testcasedescription;
    }

    @Column(name = "`PRODUCTID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getProductid() {
        return this.productid;
    }

    public void setProductid(BigInteger productid) {
        this.productid = productid;
    }

    @Column(name = "`ENGINEID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getEngineid() {
        return this.engineid;
    }

    public void setEngineid(BigInteger engineid) {
        this.engineid = engineid;
    }

    @Column(name = "`TESTCASEOWNERID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getTestcaseownerid() {
        return this.testcaseownerid;
    }

    public void setTestcaseownerid(BigInteger testcaseownerid) {
        this.testcaseownerid = testcaseownerid;
    }

    @Column(name = "`TESTCASEAUTHORID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getTestcaseauthorid() {
        return this.testcaseauthorid;
    }

    public void setTestcaseauthorid(BigInteger testcaseauthorid) {
        this.testcaseauthorid = testcaseauthorid;
    }

    @Column(name = "`CREATED`", nullable = true)
    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Column(name = "`IXTESTCASEID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getIxtestcaseid() {
        return this.ixtestcaseid;
    }

    public void setIxtestcaseid(BigInteger ixtestcaseid) {
        this.ixtestcaseid = ixtestcaseid;
    }

    @Column(name = "`INVALID`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getInvalid() {
        return this.invalid;
    }

    public void setInvalid(BigDecimal invalid) {
        this.invalid = invalid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Testcases)) return false;
        final Testcases testcases = (Testcases) o;
        return Objects.equals(getTestcaseid(), testcases.getTestcaseid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestcaseid());
    }
}

