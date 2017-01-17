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

import com.ixtest20.new_ixtest_20.Result;


/**
 * ServiceImpl object for domain model class Result.
 *
 * @see Result
 */
@Service("NEW_IXTEST_20.ResultService")
public class ResultServiceImpl implements ResultService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.ResultDao")
    private WMGenericDao<Result, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Result, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public Result create(Result result) {
        LOGGER.debug("Creating a new Result with information: {}", result);
        Result resultCreated = this.wmGenericDao.create(result);
        return resultCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Result getById(BigInteger resultId) throws EntityNotFoundException {
        LOGGER.debug("Finding Result by id: {}", resultId);
        Result result = this.wmGenericDao.findById(resultId);
        if (result == null){
            LOGGER.debug("No Result found with id: {}", resultId);
            throw new EntityNotFoundException(String.valueOf(resultId));
        }
        return result;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Result findById(BigInteger resultId) {
        LOGGER.debug("Finding Result by id: {}", resultId);
        return this.wmGenericDao.findById(resultId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Result update(Result result) throws EntityNotFoundException {
        LOGGER.debug("Updating Result with information: {}", result);
        this.wmGenericDao.update(result);

        BigInteger resultId = result.getId();

        return this.wmGenericDao.findById(resultId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Result delete(BigInteger resultId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Result with id: {}", resultId);
        Result deleted = this.wmGenericDao.findById(resultId);
        if (deleted == null) {
            LOGGER.debug("No Result found with id: {}", resultId);
            throw new EntityNotFoundException(String.valueOf(resultId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<Result> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Results");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Result> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Results");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table Result to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}
