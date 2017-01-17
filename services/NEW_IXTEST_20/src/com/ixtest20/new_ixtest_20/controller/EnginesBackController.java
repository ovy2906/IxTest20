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
import com.ixtest20.new_ixtest_20.EnginesBack;
import com.ixtest20.new_ixtest_20.service.EnginesBackService;

/**
 * Controller object for domain model class EnginesBack.
 * @see EnginesBack
 */
@RestController("NEW_IXTEST_20.EnginesBackController")
@Api(value = "EnginesBackController", description = "Exposes APIs to work with EnginesBack resource.")
@RequestMapping("/NEW_IXTEST_20/EnginesBack")
public class EnginesBackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnginesBackController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.EnginesBackService")
    private EnginesBackService enginesBackService;

    @ApiOperation(value = "Creates a new EnginesBack instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EnginesBack createEnginesBack(@RequestBody EnginesBack enginesBack) {
        LOGGER.debug("Create EnginesBack with information: {}", enginesBack);
        enginesBack = enginesBackService.create(enginesBack);
        LOGGER.debug("Created EnginesBack with information: {}", enginesBack);
        return enginesBack;
    }

    @ApiOperation(value = "Returns the EnginesBack instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EnginesBack getEnginesBack(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting EnginesBack with id: {}", id);
        EnginesBack foundEnginesBack = enginesBackService.getById(id);
        LOGGER.debug("EnginesBack details with id: {}", foundEnginesBack);
        return foundEnginesBack;
    }

    @ApiOperation(value = "Updates the EnginesBack instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EnginesBack editEnginesBack(@PathVariable("id") BigInteger id, @RequestBody EnginesBack enginesBack) throws EntityNotFoundException {
        LOGGER.debug("Editing EnginesBack with id: {}", enginesBack.getEngineid());
        enginesBack.setEngineid(id);
        enginesBack = enginesBackService.update(enginesBack);
        LOGGER.debug("EnginesBack details with id: {}", enginesBack);
        return enginesBack;
    }

    @ApiOperation(value = "Deletes the EnginesBack instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteEnginesBack(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EnginesBack with id: {}", id);
        EnginesBack deletedEnginesBack = enginesBackService.delete(id);
        return deletedEnginesBack != null;
    }

    /**
     * @deprecated Use {@link #findEnginesBacks(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of EnginesBack instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EnginesBack> searchEnginesBacksByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering EnginesBacks list");
        return enginesBackService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of EnginesBack instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EnginesBack> findEnginesBacks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EnginesBacks list");
        return enginesBackService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEnginesBacks(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return enginesBackService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of EnginesBack instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countEnginesBacks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting EnginesBacks");
        return enginesBackService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EnginesBackService instance
	 */
    protected void setEnginesBackService(EnginesBackService service) {
        this.enginesBackService = service;
    }
}
