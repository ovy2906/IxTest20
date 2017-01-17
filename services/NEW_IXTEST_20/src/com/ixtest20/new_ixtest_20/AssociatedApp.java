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
 * AssociatedApp generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ASSOCIATED_APP`")
public class AssociatedApp implements Serializable {

    private BigInteger id;
    private String name;
    private String version;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(name = "`NAME`", nullable = true, length = 128)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`VERSION`", nullable = true, length = 128)
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssociatedApp)) return false;
        final AssociatedApp associatedApp = (AssociatedApp) o;
        return Objects.equals(getId(), associatedApp.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

