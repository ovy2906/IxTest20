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
import com.ixtest20.new_ixtest_20.Testcases;
import com.ixtest20.new_ixtest_20.service.TestcasesService;

/**
 * Controller object for domain model class Testcases.
 * @see Testcases
 */
@RestController("NEW_IXTEST_20.TestcasesController")
@Api(value = "TestcasesController", description = "Exposes APIs to work with Testcases resource.")
@RequestMapping("/NEW_IXTEST_20/Testcases")
public class TestcasesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestcasesController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.TestcasesService")
    private TestcasesService testcasesService;

    @ApiOperation(value = "Creates a new Testcases instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Testcases createTestcases(@RequestBody Testcases testcases) {
        LOGGER.debug("Create Testcases with information: {}", testcases);
        testcases = testcasesService.create(testcases);
        LOGGER.debug("Created Testcases with information: {}", testcases);
        return testcases;
    }

    @ApiOperation(value = "Returns the Testcases instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Testcases getTestcases(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting Testcases with id: {}", id);
        Testcases foundTestcases = testcasesService.getById(id);
        LOGGER.debug("Testcases details with id: {}", foundTestcases);
        return foundTestcases;
    }

    @ApiOperation(value = "Updates the Testcases instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Testcases editTestcases(@PathVariable("id") BigInteger id, @RequestBody Testcases testcases) throws EntityNotFoundException {
        LOGGER.debug("Editing Testcases with id: {}", testcases.getTestcaseid());
        testcases.setTestcaseid(id);
        testcases = testcasesService.update(testcases);
        LOGGER.debug("Testcases details with id: {}", testcases);
        return testcases;
    }

    @ApiOperation(value = "Deletes the Testcases instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTestcases(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Testcases with id: {}", id);
        Testcases deletedTestcases = testcasesService.delete(id);
        return deletedTestcases != null;
    }

    /**
     * @deprecated Use {@link #findTestcases(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Testcases instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Testcases> searchTestcasesByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Testcases list");
        return testcasesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Testcases instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Testcases> findTestcases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Testcases list");
        return testcasesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTestcases(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return testcasesService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Testcases instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countTestcases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Testcases");
        return testcasesService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestcasesService instance
	 */
    protected void setTestcasesService(TestcasesService service) {
        this.testcasesService = service;
    }
}
