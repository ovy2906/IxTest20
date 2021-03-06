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

import com.ixtest20.new_ixtest_20.AssociatedApp;
import com.ixtest20.new_ixtest_20.Builds;


/**
 * ServiceImpl object for domain model class AssociatedApp.
 *
 * @see AssociatedApp
 */
@Service("NEW_IXTEST_20.AssociatedAppService")
public class AssociatedAppServiceImpl implements AssociatedAppService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociatedAppServiceImpl.class);

    @Autowired
	@Qualifier("NEW_IXTEST_20.BuildsService")
	private BuildsService buildsService;

    @Autowired
    @Qualifier("NEW_IXTEST_20.AssociatedAppDao")
    private WMGenericDao<AssociatedApp, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AssociatedApp, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public AssociatedApp create(AssociatedApp associatedApp) {
        LOGGER.debug("Creating a new AssociatedApp with information: {}", associatedApp);
        AssociatedApp associatedAppCreated = this.wmGenericDao.create(associatedApp);
        if(associatedAppCreated.getBuildses() != null) {
            for(Builds buildse : associatedAppCreated.getBuildses()) {
                buildse.setAssociatedApp(associatedAppCreated);
                LOGGER.debug("Creating a new child Builds with information: {}", buildse);
                buildsService.create(buildse);
            }
        }
        return associatedAppCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AssociatedApp getById(BigInteger associatedappId) throws EntityNotFoundException {
        LOGGER.debug("Finding AssociatedApp by id: {}", associatedappId);
        AssociatedApp associatedApp = this.wmGenericDao.findById(associatedappId);
        if (associatedApp == null){
            LOGGER.debug("No AssociatedApp found with id: {}", associatedappId);
            throw new EntityNotFoundException(String.valueOf(associatedappId));
        }
        return associatedApp;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AssociatedApp findById(BigInteger associatedappId) {
        LOGGER.debug("Finding AssociatedApp by id: {}", associatedappId);
        return this.wmGenericDao.findById(associatedappId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AssociatedApp update(AssociatedApp associatedApp) throws EntityNotFoundException {
        LOGGER.debug("Updating AssociatedApp with information: {}", associatedApp);
        this.wmGenericDao.update(associatedApp);

        BigInteger associatedappId = associatedApp.getId();

        return this.wmGenericDao.findById(associatedappId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AssociatedApp delete(BigInteger associatedappId) throws EntityNotFoundException {
        LOGGER.debug("Deleting AssociatedApp with id: {}", associatedappId);
        AssociatedApp deleted = this.wmGenericDao.findById(associatedappId);
        if (deleted == null) {
            LOGGER.debug("No AssociatedApp found with id: {}", associatedappId);
            throw new EntityNotFoundException(String.valueOf(associatedappId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<AssociatedApp> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AssociatedApps");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<AssociatedApp> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AssociatedApps");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table AssociatedApp to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Builds> findAssociatedBuildses(BigInteger id, Pageable pageable) {
        LOGGER.debug("Fetching all associated buildses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("associatedApp.id = '" + id + "'");

        return buildsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BuildsService instance
	 */
	protected void setBuildsService(BuildsService service) {
        this.buildsService = service;
    }

}

