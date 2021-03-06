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
 * Releases generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`RELEASES`")
public class Releases implements Serializable {

    private Integer releaseid;
    private String releasename;
    private BigInteger productid;
    private Products products;

    @Id
    @Column(name = "`RELEASEID`", nullable = false, scale = 0, precision = 10)
    public Integer getReleaseid() {
        return this.releaseid;
    }

    public void setReleaseid(Integer releaseid) {
        this.releaseid = releaseid;
    }

    @Column(name = "`RELEASENAME`", nullable = true, length = 32)
    public String getReleasename() {
        return this.releasename;
    }

    public void setReleasename(String releasename) {
        this.releasename = releasename;
    }

    @Column(name = "`PRODUCTID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getProductid() {
        return this.productid;
    }

    public void setProductid(BigInteger productid) {
        this.productid = productid;
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
        if (!(o instanceof Releases)) return false;
        final Releases releases = (Releases) o;
        return Objects.equals(getReleaseid(), releases.getReleaseid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReleaseid());
    }
}

