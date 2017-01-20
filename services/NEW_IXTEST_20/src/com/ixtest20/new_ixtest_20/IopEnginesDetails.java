/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * IopEnginesDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`IOP_ENGINES_DETAILS`")
public class IopEnginesDetails implements Serializable {

    private BigInteger iopEnginesDetailsId;
    private BigInteger engineid;
    private BigInteger productid;
    private String releasename;
    private String buildnumber;
    private Engines engines;
    private Products products;

    @Id
    @Column(name = "`IOP_ENGINES_DETAILS_ID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getIopEnginesDetailsId() {
        return this.iopEnginesDetailsId;
    }

    public void setIopEnginesDetailsId(BigInteger iopEnginesDetailsId) {
        this.iopEnginesDetailsId = iopEnginesDetailsId;
    }

    @Column(name = "`ENGINEID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getEngineid() {
        return this.engineid;
    }

    public void setEngineid(BigInteger engineid) {
        this.engineid = engineid;
    }

    @Column(name = "`PRODUCTID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getProductid() {
        return this.productid;
    }

    public void setProductid(BigInteger productid) {
        this.productid = productid;
    }

    @Column(name = "`RELEASENAME`", nullable = true, length = 32)
    public String getReleasename() {
        return this.releasename;
    }

    public void setReleasename(String releasename) {
        this.releasename = releasename;
    }

    @Column(name = "`BUILDNUMBER`", nullable = true, length = 32)
    public String getBuildnumber() {
        return this.buildnumber;
    }

    public void setBuildnumber(String buildnumber) {
        this.buildnumber = buildnumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ENGINEID`", referencedColumnName = "`ENGINEID`", insertable = false, updatable = false)
    public Engines getEngines() {
        return this.engines;
    }

    public void setEngines(Engines engines) {
        if(engines != null) {
            this.engineid = engines.getEngineid();
        }

        this.engines = engines;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PRODUCTID`", referencedColumnName = "`PRODUCTID`", insertable = false, updatable = false)
    public Products getProducts() {
        return this.products;
    }

    public void setProducts(Products products) {
        if(products != null) {
            this.productid = products.getProductid();
        }

        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IopEnginesDetails)) return false;
        final IopEnginesDetails iopEnginesDetails = (IopEnginesDetails) o;
        return Objects.equals(getIopEnginesDetailsId(), iopEnginesDetails.getIopEnginesDetailsId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIopEnginesDetailsId());
    }
}

