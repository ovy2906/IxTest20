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

import com.ixtest20.new_ixtest_20.ProductBack97;


/**
 * ServiceImpl object for domain model class ProductBack97.
 *
 * @see ProductBack97
 */
@Service("NEW_IXTEST_20.ProductBack97Service")
public class ProductBack97ServiceImpl implements ProductBack97Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBack97ServiceImpl.class);


    @Autowired
    @Qualifier("NEW_IXTEST_20.ProductBack97Dao")
    private WMGenericDao<ProductBack97, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ProductBack97, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public ProductBack97 create(ProductBack97 productBack97) {
        LOGGER.debug("Creating a new ProductBack97 with information: {}", productBack97);
        ProductBack97 productBack97Created = this.wmGenericDao.create(productBack97);
        return productBack97Created;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public ProductBack97 getById(BigInteger productback97Id) throws EntityNotFoundException {
        LOGGER.debug("Finding ProductBack97 by id: {}", productback97Id);
        ProductBack97 productBack97 = this.wmGenericDao.findById(productback97Id);
        if (productBack97 == null){
            LOGGER.debug("No ProductBack97 found with id: {}", productback97Id);
            throw new EntityNotFoundException(String.valueOf(productback97Id));
        }
        return productBack97;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public ProductBack97 findById(BigInteger productback97Id) {
        LOGGER.debug("Finding ProductBack97 by id: {}", productback97Id);
        return this.wmGenericDao.findById(productback97Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public ProductBack97 update(ProductBack97 productBack97) throws EntityNotFoundException {
        LOGGER.debug("Updating ProductBack97 with information: {}", productBack97);
        this.wmGenericDao.update(productBack97);

        BigInteger productback97Id = productBack97.getProductid();

        return this.wmGenericDao.findById(productback97Id);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public ProductBack97 delete(BigInteger productback97Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ProductBack97 with id: {}", productback97Id);
        ProductBack97 deleted = this.wmGenericDao.findById(productback97Id);
        if (deleted == null) {
            LOGGER.debug("No ProductBack97 found with id: {}", productback97Id);
            throw new EntityNotFoundException(String.valueOf(productback97Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<ProductBack97> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ProductBack97s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<ProductBack97> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ProductBack97s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table ProductBack97 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

