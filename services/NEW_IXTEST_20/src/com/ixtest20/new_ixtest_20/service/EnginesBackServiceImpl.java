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

import com.ixtest20.new_ixtest_20.EnginesBack;


/**
 * ServiceImpl object for domain model class EnginesBack.
 *
 * @see EnginesBack
 */
@Service("NEW_IXTEST_20.EnginesBackService")
public class EnginesBackServiceImpl implements EnginesBackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnginesBackServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.EnginesBackDao")
    private WMGenericDao<EnginesBack, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EnginesBack, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public EnginesBack create(EnginesBack enginesBack) {
        LOGGER.debug("Creating a new EnginesBack with information: {}", enginesBack);
        EnginesBack enginesBackCreated = this.wmGenericDao.create(enginesBack);
        return enginesBackCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public EnginesBack getById(BigInteger enginesbackId) throws EntityNotFoundException {
        LOGGER.debug("Finding EnginesBack by id: {}", enginesbackId);
        EnginesBack enginesBack = this.wmGenericDao.findById(enginesbackId);
        if (enginesBack == null){
            LOGGER.debug("No EnginesBack found with id: {}", enginesbackId);
            throw new EntityNotFoundException(String.valueOf(enginesbackId));
        }
        return enginesBack;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public EnginesBack findById(BigInteger enginesbackId) {
        LOGGER.debug("Finding EnginesBack by id: {}", enginesbackId);
        return this.wmGenericDao.findById(enginesbackId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public EnginesBack update(EnginesBack enginesBack) throws EntityNotFoundException {
        LOGGER.debug("Updating EnginesBack with information: {}", enginesBack);
        this.wmGenericDao.update(enginesBack);

        BigInteger enginesbackId = enginesBack.getEngineid();

        return this.wmGenericDao.findById(enginesbackId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public EnginesBack delete(BigInteger enginesbackId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EnginesBack with id: {}", enginesbackId);
        EnginesBack deleted = this.wmGenericDao.findById(enginesbackId);
        if (deleted == null) {
            LOGGER.debug("No EnginesBack found with id: {}", enginesbackId);
            throw new EntityNotFoundException(String.valueOf(enginesbackId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<EnginesBack> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EnginesBacks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<EnginesBack> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EnginesBacks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table EnginesBack to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

