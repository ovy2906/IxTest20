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
import com.ixtest20.new_ixtest_20.Dut;
import com.ixtest20.new_ixtest_20.PDutRun;
import com.ixtest20.new_ixtest_20.service.DutService;

/**
 * Controller object for domain model class Dut.
 * @see Dut
 */
@RestController("NEW_IXTEST_20.DutController")
@Api(value = "DutController", description = "Exposes APIs to work with Dut resource.")
@RequestMapping("/NEW_IXTEST_20/Dut")
public class DutController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DutController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.DutService")
    private DutService dutService;

    @ApiOperation(value = "Creates a new Dut instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Dut createDut(@RequestBody Dut dut) {
        LOGGER.debug("Create Dut with information: {}", dut);
        dut = dutService.create(dut);
        LOGGER.debug("Created Dut with information: {}", dut);
        return dut;
    }

    @ApiOperation(value = "Returns the Dut instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Dut getDut(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting Dut with id: {}", id);
        Dut foundDut = dutService.getById(id);
        LOGGER.debug("Dut details with id: {}", foundDut);
        return foundDut;
    }

    @ApiOperation(value = "Updates the Dut instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Dut editDut(@PathVariable("id") BigInteger id, @RequestBody Dut dut) throws EntityNotFoundException {
        LOGGER.debug("Editing Dut with id: {}", dut.getDutid());
        dut.setDutid(id);
        dut = dutService.update(dut);
        LOGGER.debug("Dut details with id: {}", dut);
        return dut;
    }

    @ApiOperation(value = "Deletes the Dut instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDut(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Dut with id: {}", id);
        Dut deletedDut = dutService.delete(id);
        return deletedDut != null;
    }

    /**
     * @deprecated Use {@link #findDuts(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Dut instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Dut> searchDutsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Duts list");
        return dutService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Dut instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Dut> findDuts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Duts list");
        return dutService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDuts(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return dutService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Dut instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countDuts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Duts");
        return dutService.count(query);
    }

    @RequestMapping(value = "/{id}/pdutRuns", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the pdutRuns instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PDutRun> findAssociatedPdutRuns(@PathVariable("id") BigInteger id, Pageable pageable) {
        LOGGER.debug("Fetching all associated pdutRuns");
        return dutService.findAssociatedPdutRuns(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DutService instance
	 */
    protected void setDutService(DutService service) {
        this.dutService = service;
    }
}
