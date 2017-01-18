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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Dut generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`DUT`")
public class Dut implements Serializable {

    private BigInteger dutid;
    private String name;
    private String description;
    private String type;
    private String ip;
    private List<PDutRun> pdutRuns = new ArrayList<>();

    @Id
    @Column(name = "`DUTID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getDutid() {
        return this.dutid;
    }

    public void setDutid(BigInteger dutid) {
        this.dutid = dutid;
    }

    @Column(name = "`NAME`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`DESCRIPTION`", nullable = true, length = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`TYPE`", nullable = true, length = 255)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "`IP`", nullable = true, length = 50)
    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "dut")
    public List<PDutRun> getPdutRuns() {
        return this.pdutRuns;
    }

    public void setPdutRuns(List<PDutRun> pdutRuns) {
        this.pdutRuns = pdutRuns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dut)) return false;
        final Dut dut = (Dut) o;
        return Objects.equals(getDutid(), dut.getDutid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDutid());
    }
}

