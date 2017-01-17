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
import com.ixtest20.new_ixtest_20.PNetworkRunTesting;
import com.ixtest20.new_ixtest_20.service.PNetworkRunTestingService;

/**
 * Controller object for domain model class PNetworkRunTesting.
 * @see PNetworkRunTesting
 */
@RestController("NEW_IXTEST_20.PNetworkRunTestingController")
@Api(value = "PNetworkRunTestingController", description = "Exposes APIs to work with PNetworkRunTesting resource.")
@RequestMapping("/NEW_IXTEST_20/PNetworkRunTesting")
public class PNetworkRunTestingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PNetworkRunTestingController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.PNetworkRunTestingService")
    private PNetworkRunTestingService pNetworkRunTestingService;

    @ApiOperation(value = "Creates a new PNetworkRunTesting instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PNetworkRunTesting createPNetworkRunTesting(@RequestBody PNetworkRunTesting pnetworkRunTesting) {
        LOGGER.debug("Create PNetworkRunTesting with information: {}", pnetworkRunTesting);
        pnetworkRunTesting = pNetworkRunTestingService.create(pnetworkRunTesting);
        LOGGER.debug("Created PNetworkRunTesting with information: {}", pnetworkRunTesting);
        return pnetworkRunTesting;
    }

    @ApiOperation(value = "Returns the PNetworkRunTesting instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PNetworkRunTesting getPNetworkRunTesting(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting PNetworkRunTesting with id: {}", id);
        PNetworkRunTesting foundPNetworkRunTesting = pNetworkRunTestingService.getById(id);
        LOGGER.debug("PNetworkRunTesting details with id: {}", foundPNetworkRunTesting);
        return foundPNetworkRunTesting;
    }

    @ApiOperation(value = "Updates the PNetworkRunTesting instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PNetworkRunTesting editPNetworkRunTesting(@PathVariable("id") BigInteger id, @RequestBody PNetworkRunTesting pnetworkRunTesting) throws EntityNotFoundException {
        LOGGER.debug("Editing PNetworkRunTesting with id: {}", pnetworkRunTesting.getId());
        pnetworkRunTesting.setId(id);
        pnetworkRunTesting = pNetworkRunTestingService.update(pnetworkRunTesting);
        LOGGER.debug("PNetworkRunTesting details with id: {}", pnetworkRunTesting);
        return pnetworkRunTesting;
    }

    @ApiOperation(value = "Deletes the PNetworkRunTesting instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePNetworkRunTesting(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PNetworkRunTesting with id: {}", id);
        PNetworkRunTesting deletedPNetworkRunTesting = pNetworkRunTestingService.delete(id);
        return deletedPNetworkRunTesting != null;
    }

    /**
     * @deprecated Use {@link #findPNetworkRunTestings(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PNetworkRunTesting instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PNetworkRunTesting> searchPNetworkRunTestingsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PNetworkRunTestings list");
        return pNetworkRunTestingService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of PNetworkRunTesting instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PNetworkRunTesting> findPNetworkRunTestings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PNetworkRunTestings list");
        return pNetworkRunTestingService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPNetworkRunTestings(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return pNetworkRunTestingService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of PNetworkRunTesting instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countPNetworkRunTestings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting PNetworkRunTestings");
        return pNetworkRunTestingService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PNetworkRunTestingService instance
	 */
    protected void setPNetworkRunTestingService(PNetworkRunTestingService service) {
        this.pNetworkRunTestingService = service;
    }
}