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

/**
 * DeletedEngine generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`DELETED_ENGINE`")
public class DeletedEngine implements Serializable {

    private BigDecimal idDeletedEngine;
    private BigDecimal engineId;
    private String engineName;
    private BigDecimal productId;
    private BigDecimal buildId;
    private BigDecimal noOfTestcases;
    private BigDecimal iopSuiteId;

    @Id
    @Column(name = "`ID_DELETED_ENGINE`", nullable = false, scale = 9, precision = 22)
    public BigDecimal getIdDeletedEngine() {
        return this.idDeletedEngine;
    }

    public void setIdDeletedEngine(BigDecimal idDeletedEngine) {
        this.idDeletedEngine = idDeletedEngine;
    }

    @Column(name = "`ENGINE_ID`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getEngineId() {
        return this.engineId;
    }

    public void setEngineId(BigDecimal engineId) {
        this.engineId = engineId;
    }

    @Column(name = "`ENGINE_NAME`", nullable = true, length = 128)
    public String getEngineName() {
        return this.engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    @Column(name = "`PRODUCT_ID`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getProductId() {
        return this.productId;
    }

    public void setProductId(BigDecimal productId) {
        this.productId = productId;
    }

    @Column(name = "`BUILD_ID`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getBuildId() {
        return this.buildId;
    }

    public void setBuildId(BigDecimal buildId) {
        this.buildId = buildId;
    }

    @Column(name = "`NO_OF_TESTCASES`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getNoOfTestcases() {
        return this.noOfTestcases;
    }

    public void setNoOfTestcases(BigDecimal noOfTestcases) {
        this.noOfTestcases = noOfTestcases;
    }

    @Column(name = "`IOP_SUITE_ID`", nullable = true, scale = 9, precision = 22)
    public BigDecimal getIopSuiteId() {
        return this.iopSuiteId;
    }

    public void setIopSuiteId(BigDecimal iopSuiteId) {
        this.iopSuiteId = iopSuiteId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeletedEngine)) return false;
        final DeletedEngine deletedEngine = (DeletedEngine) o;
        return Objects.equals(getIdDeletedEngine(), deletedEngine.getIdDeletedEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDeletedEngine());
    }
}

