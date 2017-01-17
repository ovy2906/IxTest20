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

import com.ixtest20.new_ixtest_20.AuthPermission;


/**
 * ServiceImpl object for domain model class AuthPermission.
 *
 * @see AuthPermission
 */
@Service("NEW_IXTEST_20.AuthPermissionService")
public class AuthPermissionServiceImpl implements AuthPermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthPermissionServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.AuthPermissionDao")
    private WMGenericDao<AuthPermission, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AuthPermission, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public AuthPermission create(AuthPermission authPermission) {
        LOGGER.debug("Creating a new AuthPermission with information: {}", authPermission);
        AuthPermission authPermissionCreated = this.wmGenericDao.create(authPermission);
        return authPermissionCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AuthPermission getById(BigInteger authpermissionId) throws EntityNotFoundException {
        LOGGER.debug("Finding AuthPermission by id: {}", authpermissionId);
        AuthPermission authPermission = this.wmGenericDao.findById(authpermissionId);
        if (authPermission == null){
            LOGGER.debug("No AuthPermission found with id: {}", authpermissionId);
            throw new EntityNotFoundException(String.valueOf(authpermissionId));
        }
        return authPermission;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AuthPermission findById(BigInteger authpermissionId) {
        LOGGER.debug("Finding AuthPermission by id: {}", authpermissionId);
        return this.wmGenericDao.findById(authpermissionId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AuthPermission update(AuthPermission authPermission) throws EntityNotFoundException {
        LOGGER.debug("Updating AuthPermission with information: {}", authPermission);
        this.wmGenericDao.update(authPermission);

        BigInteger authpermissionId = authPermission.getId();

        return this.wmGenericDao.findById(authpermissionId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public AuthPermission delete(BigInteger authpermissionId) throws EntityNotFoundException {
        LOGGER.debug("Deleting AuthPermission with id: {}", authpermissionId);
        AuthPermission deleted = this.wmGenericDao.findById(authpermissionId);
        if (deleted == null) {
            LOGGER.debug("No AuthPermission found with id: {}", authpermissionId);
            throw new EntityNotFoundException(String.valueOf(authpermissionId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<AuthPermission> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AuthPermissions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<AuthPermission> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AuthPermissions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table AuthPermission to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

