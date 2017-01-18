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

import com.ixtest20.new_ixtest_20.Builds;
import com.ixtest20.new_ixtest_20.Engines;
import com.ixtest20.new_ixtest_20.IopBuildApps;
import com.ixtest20.new_ixtest_20.IopEnginesDetails;
import com.ixtest20.new_ixtest_20.Products;
import com.ixtest20.new_ixtest_20.Releases;
import com.ixtest20.new_ixtest_20.Testcaserun;
import com.ixtest20.new_ixtest_20.Testcases;
import com.ixtest20.new_ixtest_20.Testplan;


/**
 * ServiceImpl object for domain model class Products.
 *
 * @see Products
 */
@Service("NEW_IXTEST_20.ProductsService")
public class ProductsServiceImpl implements ProductsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsServiceImpl.class);

    @Autowired
	@Qualifier("NEW_IXTEST_20.IopBuildAppsService")
	private IopBuildAppsService iopBuildAppsService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.ReleasesService")
	private ReleasesService releasesService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.TestcasesService")
	private TestcasesService testcasesService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.IopEnginesDetailsService")
	private IopEnginesDetailsService iopEnginesDetailsService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.TestplanService")
	private TestplanService testplanService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.TestcaserunService")
	private TestcaserunService testcaserunService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.EnginesService")
	private EnginesService enginesService;

    @Autowired
	@Qualifier("NEW_IXTEST_20.BuildsService")
	private BuildsService buildsService;

    @Autowired
    @Qualifier("NEW_IXTEST_20.ProductsDao")
    private WMGenericDao<Products, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Products, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public Products create(Products products) {
        LOGGER.debug("Creating a new Products with information: {}", products);
        Products productsCreated = this.wmGenericDao.create(products);
        if(productsCreated.getBuildses() != null) {
            for(Builds buildse : productsCreated.getBuildses()) {
                buildse.setProducts(productsCreated);
                LOGGER.debug("Creating a new child Builds with information: {}", buildse);
                buildsService.create(buildse);
            }
        }

        if(productsCreated.getEngineses() != null) {
            for(Engines enginese : productsCreated.getEngineses()) {
                enginese.setProducts(productsCreated);
                LOGGER.debug("Creating a new child Engines with information: {}", enginese);
                enginesService.create(enginese);
            }
        }

        if(productsCreated.getIopBuildAppses() != null) {
            for(IopBuildApps iopBuildAppse : productsCreated.getIopBuildAppses()) {
                iopBuildAppse.setProducts(productsCreated);
                LOGGER.debug("Creating a new child IopBuildApps with information: {}", iopBuildAppse);
                iopBuildAppsService.create(iopBuildAppse);
            }
        }

        if(productsCreated.getIopEnginesDetailses() != null) {
            for(IopEnginesDetails iopEnginesDetailse : productsCreated.getIopEnginesDetailses()) {
                iopEnginesDetailse.setProducts(productsCreated);
                LOGGER.debug("Creating a new child IopEnginesDetails with information: {}", iopEnginesDetailse);
                iopEnginesDetailsService.create(iopEnginesDetailse);
            }
        }

        if(productsCreated.getReleaseses() != null) {
            for(Releases releasese : productsCreated.getReleaseses()) {
                releasese.setProducts(productsCreated);
                LOGGER.debug("Creating a new child Releases with information: {}", releasese);
                releasesService.create(releasese);
            }
        }

        if(productsCreated.getTestcaseruns() != null) {
            for(Testcaserun testcaserun : productsCreated.getTestcaseruns()) {
                testcaserun.setProducts(productsCreated);
                LOGGER.debug("Creating a new child Testcaserun with information: {}", testcaserun);
                testcaserunService.create(testcaserun);
            }
        }

        if(productsCreated.getTestcaseses() != null) {
            for(Testcases testcasese : productsCreated.getTestcaseses()) {
                testcasese.setProducts(productsCreated);
                LOGGER.debug("Creating a new child Testcases with information: {}", testcasese);
                testcasesService.create(testcasese);
            }
        }

        if(productsCreated.getTestplans() != null) {
            for(Testplan testplan : productsCreated.getTestplans()) {
                testplan.setProducts(productsCreated);
                LOGGER.debug("Creating a new child Testplan with information: {}", testplan);
                testplanService.create(testplan);
            }
        }
        return productsCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Products getById(BigInteger productsId) throws EntityNotFoundException {
        LOGGER.debug("Finding Products by id: {}", productsId);
        Products products = this.wmGenericDao.findById(productsId);
        if (products == null){
            LOGGER.debug("No Products found with id: {}", productsId);
            throw new EntityNotFoundException(String.valueOf(productsId));
        }
        return products;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Products findById(BigInteger productsId) {
        LOGGER.debug("Finding Products by id: {}", productsId);
        return this.wmGenericDao.findById(productsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Products update(Products products) throws EntityNotFoundException {
        LOGGER.debug("Updating Products with information: {}", products);
        this.wmGenericDao.update(products);

        BigInteger productsId = products.getProductid();

        return this.wmGenericDao.findById(productsId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Products delete(BigInteger productsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Products with id: {}", productsId);
        Products deleted = this.wmGenericDao.findById(productsId);
        if (deleted == null) {
            LOGGER.debug("No Products found with id: {}", productsId);
            throw new EntityNotFoundException(String.valueOf(productsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<Products> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Products> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table Products to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Builds> findAssociatedBuildses(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated buildses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return buildsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Engines> findAssociatedEngineses(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated engineses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return enginesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<IopBuildApps> findAssociatedIopBuildAppses(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated iopBuildAppses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return iopBuildAppsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<IopEnginesDetails> findAssociatedIopEnginesDetailses(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated iopEnginesDetailses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return iopEnginesDetailsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Releases> findAssociatedReleaseses(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated releaseses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return releasesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Testcaserun> findAssociatedTestcaseruns(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated testcaseruns");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return testcaserunService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Testcases> findAssociatedTestcaseses(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated testcaseses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return testcasesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Testplan> findAssociatedTestplans(BigInteger productid, Pageable pageable) {
        LOGGER.debug("Fetching all associated testplans");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("products.productid = '" + productid + "'");

        return testplanService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IopBuildAppsService instance
	 */
	protected void setIopBuildAppsService(IopBuildAppsService service) {
        this.iopBuildAppsService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ReleasesService instance
	 */
	protected void setReleasesService(ReleasesService service) {
        this.releasesService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestcasesService instance
	 */
	protected void setTestcasesService(TestcasesService service) {
        this.testcasesService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IopEnginesDetailsService instance
	 */
	protected void setIopEnginesDetailsService(IopEnginesDetailsService service) {
        this.iopEnginesDetailsService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestplanService instance
	 */
	protected void setTestplanService(TestplanService service) {
        this.testplanService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestcaserunService instance
	 */
	protected void setTestcaserunService(TestcaserunService service) {
        this.testcaserunService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EnginesService instance
	 */
	protected void setEnginesService(EnginesService service) {
        this.enginesService = service;
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

