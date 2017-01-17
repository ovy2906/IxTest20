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
import com.ixtest20.new_ixtest_20.IopEnginesDetails;
import com.ixtest20.new_ixtest_20.service.IopEnginesDetailsService;

/**
 * Controller object for domain model class IopEnginesDetails.
 * @see IopEnginesDetails
 */
@RestController("NEW_IXTEST_20.IopEnginesDetailsController")
@Api(value = "IopEnginesDetailsController", description = "Exposes APIs to work with IopEnginesDetails resource.")
@RequestMapping("/NEW_IXTEST_20/IopEnginesDetails")
public class IopEnginesDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IopEnginesDetailsController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.IopEnginesDetailsService")
    private IopEnginesDetailsService iopEnginesDetailsService;

    @ApiOperation(value = "Creates a new IopEnginesDetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IopEnginesDetails createIopEnginesDetails(@RequestBody IopEnginesDetails iopEnginesDetails) {
        LOGGER.debug("Create IopEnginesDetails with information: {}", iopEnginesDetails);
        iopEnginesDetails = iopEnginesDetailsService.create(iopEnginesDetails);
        LOGGER.debug("Created IopEnginesDetails with information: {}", iopEnginesDetails);
        return iopEnginesDetails;
    }

    @ApiOperation(value = "Returns the IopEnginesDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IopEnginesDetails getIopEnginesDetails(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting IopEnginesDetails with id: {}", id);
        IopEnginesDetails foundIopEnginesDetails = iopEnginesDetailsService.getById(id);
        LOGGER.debug("IopEnginesDetails details with id: {}", foundIopEnginesDetails);
        return foundIopEnginesDetails;
    }

    @ApiOperation(value = "Updates the IopEnginesDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IopEnginesDetails editIopEnginesDetails(@PathVariable("id") BigInteger id, @RequestBody IopEnginesDetails iopEnginesDetails) throws EntityNotFoundException {
        LOGGER.debug("Editing IopEnginesDetails with id: {}", iopEnginesDetails.getIopEnginesDetailsId());
        iopEnginesDetails.setIopEnginesDetailsId(id);
        iopEnginesDetails = iopEnginesDetailsService.update(iopEnginesDetails);
        LOGGER.debug("IopEnginesDetails details with id: {}", iopEnginesDetails);
        return iopEnginesDetails;
    }

    @ApiOperation(value = "Deletes the IopEnginesDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteIopEnginesDetails(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting IopEnginesDetails with id: {}", id);
        IopEnginesDetails deletedIopEnginesDetails = iopEnginesDetailsService.delete(id);
        return deletedIopEnginesDetails != null;
    }

    /**
     * @deprecated Use {@link #findIopEnginesDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of IopEnginesDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IopEnginesDetails> searchIopEnginesDetailsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering IopEnginesDetails list");
        return iopEnginesDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of IopEnginesDetails instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IopEnginesDetails> findIopEnginesDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering IopEnginesDetails list");
        return iopEnginesDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportIopEnginesDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return iopEnginesDetailsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of IopEnginesDetails instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countIopEnginesDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting IopEnginesDetails");
        return iopEnginesDetailsService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IopEnginesDetailsService instance
	 */
    protected void setIopEnginesDetailsService(IopEnginesDetailsService service) {
        this.iopEnginesDetailsService = service;
    }
}