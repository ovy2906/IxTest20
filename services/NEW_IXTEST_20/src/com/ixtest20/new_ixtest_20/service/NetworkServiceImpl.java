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

import com.ixtest20.new_ixtest_20.Network;
import com.ixtest20.new_ixtest_20.PNetworkRun;


/**
 * ServiceImpl object for domain model class Network.
 *
 * @see Network
 */
@Service("NEW_IXTEST_20.NetworkService")
public class NetworkServiceImpl implements NetworkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetworkServiceImpl.class);

    @Autowired
	@Qualifier("NEW_IXTEST_20.PNetworkRunService")
	private PNetworkRunService pNetworkRunService;

    @Autowired
    @Qualifier("NEW_IXTEST_20.NetworkDao")
    private WMGenericDao<Network, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Network, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
    @Override
	public Network create(Network network) {
        LOGGER.debug("Creating a new Network with information: {}", network);
        Network networkCreated = this.wmGenericDao.create(network);
        if(networkCreated.getPnetworkRuns() != null) {
            for(PNetworkRun pnetworkRun : networkCreated.getPnetworkRuns()) {
                pnetworkRun.setNetwork(networkCreated);
                LOGGER.debug("Creating a new child PNetworkRun with information: {}", pnetworkRun);
                pNetworkRunService.create(pnetworkRun);
            }
        }
        return networkCreated;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Network getById(BigInteger networkId) throws EntityNotFoundException {
        LOGGER.debug("Finding Network by id: {}", networkId);
        Network network = this.wmGenericDao.findById(networkId);
        if (network == null){
            LOGGER.debug("No Network found with id: {}", networkId);
            throw new EntityNotFoundException(String.valueOf(networkId));
        }
        return network;
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Network findById(BigInteger networkId) {
        LOGGER.debug("Finding Network by id: {}", networkId);
        return this.wmGenericDao.findById(networkId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Network update(Network network) throws EntityNotFoundException {
        LOGGER.debug("Updating Network with information: {}", network);
        this.wmGenericDao.update(network);

        BigInteger networkId = network.getNetworkid();

        return this.wmGenericDao.findById(networkId);
    }

    @Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Network delete(BigInteger networkId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Network with id: {}", networkId);
        Network deleted = this.wmGenericDao.findById(networkId);
        if (deleted == null) {
            LOGGER.debug("No Network found with id: {}", networkId);
            throw new EntityNotFoundException(String.valueOf(networkId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public Page<Network> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Networks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<Network> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Networks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NEW_IXTEST_20 for table Network to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "NEW_IXTEST_20TransactionManager")
    @Override
    public Page<PNetworkRun> findAssociatedPnetworkRuns(BigInteger networkid, Pageable pageable) {
        LOGGER.debug("Fetching all associated pnetworkRuns");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("network.networkid = '" + networkid + "'");

        return pNetworkRunService.findAll(queryBuilder.toString(), pageable);
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

