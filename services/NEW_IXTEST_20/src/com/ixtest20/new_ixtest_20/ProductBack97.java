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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductBack97 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PRODUCT_BACK_9_7`")
public class ProductBack97 implements Serializable {

    private BigInteger productid;
    private String productname;
    private BigInteger status;

    @Id
    @Column(name = "`PRODUCTID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getProductid() {
        return this.productid;
    }

    public void setProductid(BigInteger productid) {
        this.productid = productid;
    }

    @Column(name = "`PRODUCTNAME`", nullable = true, length = 32)
    public String getProductname() {
        return this.productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Column(name = "`STATUS`", nullable = true, scale = 0, precision = 19)
    public BigInteger getStatus() {
        return this.status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBack97)) return false;
        final ProductBack97 productBack97 = (ProductBack97) o;
        return Objects.equals(getProductid(), productBack97.getProductid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductid());
    }
}

