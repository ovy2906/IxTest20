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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Network generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`NETWORK`")
public class Network implements Serializable {

    private BigInteger networkid;
    private String name;
    private String combine;
    private BigInteger interfaceid;
    private BigInteger platformid;
    private BigInteger slotnumber;
    private BigInteger portnumber;
    private BigInteger associatedApp;
    private String portSerialNumber;
    private Loadmodules loadmodules;
    private Chassis chassis;
    private List<PNetworkRun> pnetworkRuns = new ArrayList<>();

    @Id
    @Column(name = "`NETWORKID`", nullable = false, scale = 0, precision = 19)
    public BigInteger getNetworkid() {
        return this.networkid;
    }

    public void setNetworkid(BigInteger networkid) {
        this.networkid = networkid;
    }

    @Column(name = "`NAME`", nullable = true, length = 256)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`COMBINE`", nullable = true, length = 256)
    public String getCombine() {
        return this.combine;
    }

    public void setCombine(String combine) {
        this.combine = combine;
    }

    @Column(name = "`INTERFACEID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getInterfaceid() {
        return this.interfaceid;
    }

    public void setInterfaceid(BigInteger interfaceid) {
        this.interfaceid = interfaceid;
    }

    @Column(name = "`PLATFORMID`", nullable = true, scale = 0, precision = 19)
    public BigInteger getPlatformid() {
        return this.platformid;
    }

    public void setPlatformid(BigInteger platformid) {
        this.platformid = platformid;
    }

    @Column(name = "`SLOTNUMBER`", nullable = true, scale = 0, precision = 19)
    public BigInteger getSlotnumber() {
        return this.slotnumber;
    }

    public void setSlotnumber(BigInteger slotnumber) {
        this.slotnumber = slotnumber;
    }

    @Column(name = "`PORTNUMBER`", nullable = true, scale = 0, precision = 19)
    public BigInteger getPortnumber() {
        return this.portnumber;
    }

    public void setPortnumber(BigInteger portnumber) {
        this.portnumber = portnumber;
    }

    @Column(name = "`ASSOCIATED_APP`", nullable = true, scale = 0, precision = 19)
    public BigInteger getAssociatedApp() {
        return this.associatedApp;
    }

    public void setAssociatedApp(BigInteger associatedApp) {
        this.associatedApp = associatedApp;
    }

    @Column(name = "`PORT_SERIAL_NUMBER`", nullable = true, length = 256)
    public String getPortSerialNumber() {
        return this.portSerialNumber;
    }

    public void setPortSerialNumber(String portSerialNumber) {
        this.portSerialNumber = portSerialNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`INTERFACEID`", referencedColumnName = "`LMID`", insertable = false, updatable = false)
    public Loadmodules getLoadmodules() {
        return this.loadmodules;
    }

    public void setLoadmodules(Loadmodules loadmodules) {
        if(loadmodules != null) {
            this.interfaceid = loadmodules.getLmid();
        }

        this.loadmodules = loadmodules;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PLATFORMID`", referencedColumnName = "`CHASSISID`", insertable = false, updatable = false)
    public Chassis getChassis() {
        return this.chassis;
    }

    public void setChassis(Chassis chassis) {
        if(chassis != null) {
            this.platformid = chassis.getChassisid();
        }

        this.chassis = chassis;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "network")
    public List<PNetworkRun> getPnetworkRuns() {
        return this.pnetworkRuns;
    }

    public void setPnetworkRuns(List<PNetworkRun> pnetworkRuns) {
        this.pnetworkRuns = pnetworkRuns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Network)) return false;
        final Network network = (Network) o;
        return Objects.equals(getNetworkid(), network.getNetworkid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNetworkid());
    }
}

