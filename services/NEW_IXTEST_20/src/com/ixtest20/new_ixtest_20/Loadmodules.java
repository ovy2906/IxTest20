/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Loadmodules generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`LOADMODULES`")
public class Loadmodules implements Serializable {

    private BigInteger lmid;
    private String name;
    private List<Network> networks = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`LMID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getLmid() {
        return this.lmid;
    }

    public void setLmid(BigInteger lmid) {
        this.lmid = lmid;
    }

    @Column(name = "`NAME`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "loadmodules")
    public List<Network> getNetworks() {
        return this.networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loadmodules)) return false;
        final Loadmodules loadmodules = (Loadmodules) o;
        return Objects.equals(getLmid(), loadmodules.getLmid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLmid());
    }
}

