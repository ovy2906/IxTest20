/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.ixtest20.new_ixtest_20.PNetworkRun;


/**
 * ServiceImpl object for domain model class PNetworkRun.
 *
 * @see PNetworkRun
 */
@Service("NEW_IXTEST_20.PNetworkRunService")
public class PNetworkRunServiceImpl implements PNetworkRunService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PNetworkRunServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.PNetworkRunDao")
    private WMGenericDao<PNetworkRun, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PNetworkRun, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public PNetworkRun create(PNetworkRun pnetworkRun) {
        LOGGER.debug("Creating a new PNetworkRun with information: {}", pnetworkRun);
        PNetworkRun pnetworkRunCreated = this.wmGenericDao.create(pnetworkRun);
        return pnetworkRunCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PNetworkRun getById(BigInteger pnetworkrunId) throws EntityNotFoundException {
        LOGGER.debug("Finding PNetworkRun by id: {}", pnetworkrunId);
        PNetworkRun pnetworkRun = this.wmGenericDao.findById(pnetworkrunId);
        if (pnetworkRun == null){
            LOGGER.debug("No PNetworkRun found with id: {}", pnetworkrunId);
            throw new EntityNotFoundException(String.valueOf(pnetworkrunId));
        }
        return pnetworkRun;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PNetworkRun findById(BigInteger pnetworkrunId) {
        LOGGER.debug("Finding PNetworkRun by id: {}", pnetworkrunId);
        return this.wmGenericDao.findById(pnetworkrunId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PNetworkRun update(PNetworkRun pnetworkRun) throws EntityNotFoundException {
        LOGGER.debug("Updating PNetworkRun with information: {}", pnetworkRun);
        this.wmGenericDao.update(pnetworkRun);

        BigInteger pnetworkrunId = pnetworkRun.getId();

        return this.wmGenericDao.findById(pnetworkrunId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PNetworkRun delete(BigInteger pnetworkrunId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PNetworkRun with id: {}", pnetworkrunId);
        PNetworkRun deleted = this.wmGenericDao.findById(pnetworkrunId);
        if (deleted == null) {
            LOGGER.debug("No PNetworkRun found with id: {}", pnetworkrunId);
            throw new EntityNotFoundException(String.valueOf(pnetworkrunId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<PNetworkRun> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PNetworkRuns");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<PNetworkRun> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PNetworkRuns");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table PNetworkRun to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

