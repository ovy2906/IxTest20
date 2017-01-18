/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.math.BigInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.ixtest20.new_ixtest_20.Network;
import com.ixtest20.new_ixtest_20.PNetworkRun;
import com.ixtest20.new_ixtest_20.service.NetworkService;

/**
 * Controller object for domain model class Network.
 * @see Network
 */
@RestController("NEW_IXTEST_20.NetworkController")
@Api(value = "NetworkController", description = "Exposes APIs to work with Network resource.")
@RequestMapping("/NEW_IXTEST_20/Network")
public class NetworkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetworkController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.NetworkService")
    private NetworkService networkService;

    @ApiOperation(value = "Creates a new Network instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Network createNetwork(@RequestBody Network network) {
        LOGGER.debug("Create Network with information: {}", network);
        network = networkService.create(network);
        LOGGER.debug("Created Network with information: {}", network);
        return network;
    }

    @ApiOperation(value = "Returns the Network instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Network getNetwork(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting Network with id: {}", id);
        Network foundNetwork = networkService.getById(id);
        LOGGER.debug("Network details with id: {}", foundNetwork);
        return foundNetwork;
    }

    @ApiOperation(value = "Updates the Network instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Network editNetwork(@PathVariable("id") BigInteger id, @RequestBody Network network) throws EntityNotFoundException {
        LOGGER.debug("Editing Network with id: {}", network.getNetworkid());
        network.setNetworkid(id);
        network = networkService.update(network);
        LOGGER.debug("Network details with id: {}", network);
        return network;
    }

    @ApiOperation(value = "Deletes the Network instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteNetwork(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Network with id: {}", id);
        Network deletedNetwork = networkService.delete(id);
        return deletedNetwork != null;
    }

    /**
     * @deprecated Use {@link #findNetworks(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Network instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Network> searchNetworksByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Networks list");
        return networkService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Network instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Network> findNetworks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Networks list");
        return networkService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportNetworks(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return networkService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Network instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countNetworks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Networks");
        return networkService.count(query);
    }

    @RequestMapping(value = "/{id:.+}/pnetworkRuns", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the pnetworkRuns instance associated with the given id.")
    public Page<PNetworkRun> findAssociatedPnetworkRuns(@PathVariable("id") BigInteger id, Pageable pageable) {
        LOGGER.debug("Fetching all associated pnetworkRuns");
        return networkService.findAssociatedPnetworkRuns(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service NetworkService instance
	 */
    protected void setNetworkService(NetworkService service) {
        this.networkService = service;
    }
}
