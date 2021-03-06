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

import com.ixtest20.new_ixtest_20.TestcasesBack;


/**
 * ServiceImpl object for domain model class TestcasesBack.
 *
 * @see TestcasesBack
 */
@Service("NEW_IXTEST_20.TestcasesBackService")
public class TestcasesBackServiceImpl implements TestcasesBackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestcasesBackServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.TestcasesBackDao")
    private WMGenericDao<TestcasesBack, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TestcasesBack, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public TestcasesBack create(TestcasesBack testcasesBack) {
        LOGGER.debug("Creating a new TestcasesBack with information: {}", testcasesBack);
        TestcasesBack testcasesBackCreated = this.wmGenericDao.create(testcasesBack);
        return testcasesBackCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public TestcasesBack getById(BigInteger testcasesbackId) throws EntityNotFoundException {
        LOGGER.debug("Finding TestcasesBack by id: {}", testcasesbackId);
        TestcasesBack testcasesBack = this.wmGenericDao.findById(testcasesbackId);
        if (testcasesBack == null){
            LOGGER.debug("No TestcasesBack found with id: {}", testcasesbackId);
            throw new EntityNotFoundException(String.valueOf(testcasesbackId));
        }
        return testcasesBack;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public TestcasesBack findById(BigInteger testcasesbackId) {
        LOGGER.debug("Finding TestcasesBack by id: {}", testcasesbackId);
        return this.wmGenericDao.findById(testcasesbackId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public TestcasesBack update(TestcasesBack testcasesBack) throws EntityNotFoundException {
        LOGGER.debug("Updating TestcasesBack with information: {}", testcasesBack);
        this.wmGenericDao.update(testcasesBack);

        BigInteger testcasesbackId = testcasesBack.getTestcaseid();

        return this.wmGenericDao.findById(testcasesbackId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public TestcasesBack delete(BigInteger testcasesbackId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TestcasesBack with id: {}", testcasesbackId);
        TestcasesBack deleted = this.wmGenericDao.findById(testcasesbackId);
        if (deleted == null) {
            LOGGER.debug("No TestcasesBack found with id: {}", testcasesbackId);
            throw new EntityNotFoundException(String.valueOf(testcasesbackId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<TestcasesBack> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TestcasesBacks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<TestcasesBack> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TestcasesBacks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table TestcasesBack to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

