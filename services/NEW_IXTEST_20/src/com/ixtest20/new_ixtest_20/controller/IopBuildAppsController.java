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
import com.ixtest20.new_ixtest_20.IopBuildApps;
import com.ixtest20.new_ixtest_20.service.IopBuildAppsService;

/**
 * Controller object for domain model class IopBuildApps.
 * @see IopBuildApps
 */
@RestController("NEW_IXTEST_20.IopBuildAppsController")
@Api(value = "IopBuildAppsController", description = "Exposes APIs to work with IopBuildApps resource.")
@RequestMapping("/NEW_IXTEST_20/IopBuildApps")
public class IopBuildAppsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IopBuildAppsController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.IopBuildAppsService")
    private IopBuildAppsService iopBuildAppsService;

    @ApiOperation(value = "Creates a new IopBuildApps instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IopBuildApps createIopBuildApps(@RequestBody IopBuildApps iopBuildApps) {
        LOGGER.debug("Create IopBuildApps with information: {}", iopBuildApps);
        iopBuildApps = iopBuildAppsService.create(iopBuildApps);
        LOGGER.debug("Created IopBuildApps with information: {}", iopBuildApps);
        return iopBuildApps;
    }

    @ApiOperation(value = "Returns the IopBuildApps instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IopBuildApps getIopBuildApps(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting IopBuildApps with id: {}", id);
        IopBuildApps foundIopBuildApps = iopBuildAppsService.getById(id);
        LOGGER.debug("IopBuildApps details with id: {}", foundIopBuildApps);
        return foundIopBuildApps;
    }

    @ApiOperation(value = "Updates the IopBuildApps instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IopBuildApps editIopBuildApps(@PathVariable("id") BigInteger id, @RequestBody IopBuildApps iopBuildApps) throws EntityNotFoundException {
        LOGGER.debug("Editing IopBuildApps with id: {}", iopBuildApps.getIopBuildAppsId());
        iopBuildApps.setIopBuildAppsId(id);
        iopBuildApps = iopBuildAppsService.update(iopBuildApps);
        LOGGER.debug("IopBuildApps details with id: {}", iopBuildApps);
        return iopBuildApps;
    }

    @ApiOperation(value = "Deletes the IopBuildApps instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteIopBuildApps(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting IopBuildApps with id: {}", id);
        IopBuildApps deletedIopBuildApps = iopBuildAppsService.delete(id);
        return deletedIopBuildApps != null;
    }

    /**
     * @deprecated Use {@link #findIopBuildApps(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of IopBuildApps instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IopBuildApps> searchIopBuildAppsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering IopBuildApps list");
        return iopBuildAppsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of IopBuildApps instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IopBuildApps> findIopBuildApps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering IopBuildApps list");
        return iopBuildAppsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportIopBuildApps(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return iopBuildAppsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of IopBuildApps instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countIopBuildApps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting IopBuildApps");
        return iopBuildAppsService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IopBuildAppsService instance
	 */
    protected void setIopBuildAppsService(IopBuildAppsService service) {
        this.iopBuildAppsService = service;
    }
}