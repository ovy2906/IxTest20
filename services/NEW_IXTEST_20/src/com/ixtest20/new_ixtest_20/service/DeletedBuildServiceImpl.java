/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;

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

import com.ixtest20.new_ixtest_20.DeletedBuild;


/**
 * ServiceImpl object for domain model class DeletedBuild.
 *
 * @see DeletedBuild
 */
@Service("NEW_IXTEST_20.DeletedBuildService")
public class DeletedBuildServiceImpl implements DeletedBuildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeletedBuildServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.DeletedBuildDao")
    private WMGenericDao<DeletedBuild, BigDecimal> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<DeletedBuild, BigDecimal> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public DeletedBuild create(DeletedBuild deletedBuild) {
        LOGGER.debug("Creating a new DeletedBuild with information: {}", deletedBuild);
        DeletedBuild deletedBuildCreated = this.wmGenericDao.create(deletedBuild);
        return deletedBuildCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public DeletedBuild getById(BigDecimal deletedbuildId) throws EntityNotFoundException {
        LOGGER.debug("Finding DeletedBuild by id: {}", deletedbuildId);
        DeletedBuild deletedBuild = this.wmGenericDao.findById(deletedbuildId);
        if (deletedBuild == null){
            LOGGER.debug("No DeletedBuild found with id: {}", deletedbuildId);
            throw new EntityNotFoundException(String.valueOf(deletedbuildId));
        }
        return deletedBuild;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public DeletedBuild findById(BigDecimal deletedbuildId) {
        LOGGER.debug("Finding DeletedBuild by id: {}", deletedbuildId);
        return this.wmGenericDao.findById(deletedbuildId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public DeletedBuild update(DeletedBuild deletedBuild) throws EntityNotFoundException {
        LOGGER.debug("Updating DeletedBuild with information: {}", deletedBuild);
        this.wmGenericDao.update(deletedBuild);

        BigDecimal deletedbuildId = deletedBuild.getIdDeletedBuild();

        return this.wmGenericDao.findById(deletedbuildId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public DeletedBuild delete(BigDecimal deletedbuildId) throws EntityNotFoundException {
        LOGGER.debug("Deleting DeletedBuild with id: {}", deletedbuildId);
        DeletedBuild deleted = this.wmGenericDao.findById(deletedbuildId);
        if (deleted == null) {
            LOGGER.debug("No DeletedBuild found with id: {}", deletedbuildId);
            throw new EntityNotFoundException(String.valueOf(deletedbuildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<DeletedBuild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all DeletedBuilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<DeletedBuild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all DeletedBuilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table DeletedBuild to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

