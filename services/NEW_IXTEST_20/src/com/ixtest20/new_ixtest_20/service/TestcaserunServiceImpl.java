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

import com.ixtest20.new_ixtest_20.PDutRun;
import com.ixtest20.new_ixtest_20.PNetworkRun;
import com.ixtest20.new_ixtest_20.Testcaserun;


/**
 * ServiceImpl object for domain model class Testcaserun.
 *
 * @see Testcaserun
 */
@Service("NEW_IXTEST_20.TestcaserunService")
public class TestcaserunServiceImpl implements TestcaserunService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestcaserunServiceImpl.class);

    @Autowired
	@Qualifier("NEW_IXTEST_20.PDutRunService")
	private PDutRunService pDutRunService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.PNetworkRunService")
	private PNetworkRunService pNetworkRunService;

    @Autowired
    @Qualifier("NEW_IXTEST_20.TestcaserunDao")
    private WMGenericDao<Testcaserun, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Testcaserun, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public Testcaserun create(Testcaserun testcaserun) {
        LOGGER.debug("Creating a new Testcaserun with information: {}", testcaserun);
        Testcaserun testcaserunCreated = this.wmGenericDao.create(testcaserun);
        if(testcaserunCreated.getPdutRuns() != null) {
            for(PDutRun pdutRun : testcaserunCreated.getPdutRuns()) {
                pdutRun.setTestcaserun(testcaserunCreated);
                LOGGER.debug("Creating a new child PDutRun with information: {}", pdutRun);
                pDutRunService.create(pdutRun);
            }
        }

        if(testcaserunCreated.getPnetworkRuns() != null) {
            for(PNetworkRun pnetworkRun : testcaserunCreated.getPnetworkRuns()) {
                pnetworkRun.setTestcaserun(testcaserunCreated);
                LOGGER.debug("Creating a new child PNetworkRun with information: {}", pnetworkRun);
                pNetworkRunService.create(pnetworkRun);
            }
        }
        return testcaserunCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Testcaserun getById(BigInteger testcaserunId) throws EntityNotFoundException {
        LOGGER.debug("Finding Testcaserun by id: {}", testcaserunId);
        Testcaserun testcaserun = this.wmGenericDao.findById(testcaserunId);
        if (testcaserun == null){
            LOGGER.debug("No Testcaserun found with id: {}", testcaserunId);
            throw new EntityNotFoundException(String.valueOf(testcaserunId));
        }
        return testcaserun;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Testcaserun findById(BigInteger testcaserunId) {
        LOGGER.debug("Finding Testcaserun by id: {}", testcaserunId);
        return this.wmGenericDao.findById(testcaserunId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Testcaserun update(Testcaserun testcaserun) throws EntityNotFoundException {
        LOGGER.debug("Updating Testcaserun with information: {}", testcaserun);
        this.wmGenericDao.update(testcaserun);

        BigInteger testcaserunId = testcaserun.getTestcaserunid();

        return this.wmGenericDao.findById(testcaserunId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Testcaserun delete(BigInteger testcaserunId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Testcaserun with id: {}", testcaserunId);
        Testcaserun deleted = this.wmGenericDao.findById(testcaserunId);
        if (deleted == null) {
            LOGGER.debug("No Testcaserun found with id: {}", testcaserunId);
            throw new EntityNotFoundException(String.valueOf(testcaserunId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<Testcaserun> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Testcaseruns");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Testcaserun> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Testcaseruns");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table Testcaserun to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<PDutRun> findAssociatedPdutRuns(BigInteger testcaserunid, Pageable pageable) {
        LOGGER.debug("Fetching all associated pdutRuns");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("testcaserun.testcaserunid = '" + testcaserunid + "'");

        return pDutRunService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<PNetworkRun> findAssociatedPnetworkRuns(BigInteger testcaserunid, Pageable pageable) {
        LOGGER.debug("Fetching all associated pnetworkRuns");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("testcaserun.testcaserunid = '" + testcaserunid + "'");

        return pNetworkRunService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PDutRunService instance
	 */
	protected void setPDutRunService(PDutRunService service) {
        this.pDutRunService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PNetworkRunService instance
	 */
	protected void setPNetworkRunService(PNetworkRunService service) {
        this.pNetworkRunService = service;
    }

}

