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

import com.ixtest20.new_ixtest_20.PBugtableRun;


/**
 * ServiceImpl object for domain model class PBugtableRun.
 *
 * @see PBugtableRun
 */
@Service("NEW_IXTEST_20.PBugtableRunService")
public class PBugtableRunServiceImpl implements PBugtableRunService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PBugtableRunServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.PBugtableRunDao")
    private WMGenericDao<PBugtableRun, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PBugtableRun, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public PBugtableRun create(PBugtableRun pbugtableRun) {
        LOGGER.debug("Creating a new PBugtableRun with information: {}", pbugtableRun);
        PBugtableRun pbugtableRunCreated = this.wmGenericDao.create(pbugtableRun);
        return pbugtableRunCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PBugtableRun getById(BigInteger pbugtablerunId) throws EntityNotFoundException {
        LOGGER.debug("Finding PBugtableRun by id: {}", pbugtablerunId);
        PBugtableRun pbugtableRun = this.wmGenericDao.findById(pbugtablerunId);
        if (pbugtableRun == null){
            LOGGER.debug("No PBugtableRun found with id: {}", pbugtablerunId);
            throw new EntityNotFoundException(String.valueOf(pbugtablerunId));
        }
        return pbugtableRun;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PBugtableRun findById(BigInteger pbugtablerunId) {
        LOGGER.debug("Finding PBugtableRun by id: {}", pbugtablerunId);
        return this.wmGenericDao.findById(pbugtablerunId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PBugtableRun update(PBugtableRun pbugtableRun) throws EntityNotFoundException {
        LOGGER.debug("Updating PBugtableRun with information: {}", pbugtableRun);
        this.wmGenericDao.update(pbugtableRun);

        BigInteger pbugtablerunId = pbugtableRun.getId();

        return this.wmGenericDao.findById(pbugtablerunId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public PBugtableRun delete(BigInteger pbugtablerunId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PBugtableRun with id: {}", pbugtablerunId);
        PBugtableRun deleted = this.wmGenericDao.findById(pbugtablerunId);
        if (deleted == null) {
            LOGGER.debug("No PBugtableRun found with id: {}", pbugtablerunId);
            throw new EntityNotFoundException(String.valueOf(pbugtablerunId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<PBugtableRun> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PBugtableRuns");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<PBugtableRun> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PBugtableRuns");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table PBugtableRun to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

