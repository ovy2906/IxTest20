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
 * AuthPermission generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`AUTH_PERMISSION`")
public class AuthPermission implements Serializable {

    private BigInteger id;
    private String name;
    private BigInteger contentTypeId;
    private String codename;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(name = "`NAME`", nullable = true, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`CONTENT_TYPE_ID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getContentTypeId() {
        return this.contentTypeId;
    }

    public void setContentTypeId(BigInteger contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    @Column(name = "`CODENAME`", nullable = true, length = 100)
    public String getCodename() {
        return this.codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthPermission)) return false;
        final AuthPermission authPermission = (AuthPermission) o;
        return Objects.equals(getId(), authPermission.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
