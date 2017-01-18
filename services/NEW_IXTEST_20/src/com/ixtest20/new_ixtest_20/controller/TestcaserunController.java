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
import com.ixtest20.new_ixtest_20.PDutRun;
import com.ixtest20.new_ixtest_20.PNetworkRun;
import com.ixtest20.new_ixtest_20.Testcaserun;
import com.ixtest20.new_ixtest_20.service.TestcaserunService;

/**
 * Controller object for domain model class Testcaserun.
 * @see Testcaserun
 */
@RestController("NEW_IXTEST_20.TestcaserunController")
@Api(value = "TestcaserunController", description = "Exposes APIs to work with Testcaserun resource.")
@RequestMapping("/NEW_IXTEST_20/Testcaserun")
public class TestcaserunController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestcaserunController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.TestcaserunService")
    private TestcaserunService testcaserunService;

    @ApiOperation(value = "Creates a new Testcaserun instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Testcaserun createTestcaserun(@RequestBody Testcaserun testcaserun) {
        LOGGER.debug("Create Testcaserun with information: {}", testcaserun);
        testcaserun = testcaserunService.create(testcaserun);
        LOGGER.debug("Created Testcaserun with information: {}", testcaserun);
        return testcaserun;
    }

    @ApiOperation(value = "Returns the Testcaserun instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Testcaserun getTestcaserun(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting Testcaserun with id: {}", id);
        Testcaserun foundTestcaserun = testcaserunService.getById(id);
        LOGGER.debug("Testcaserun details with id: {}", foundTestcaserun);
        return foundTestcaserun;
    }

    @ApiOperation(value = "Updates the Testcaserun instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Testcaserun editTestcaserun(@PathVariable("id") BigInteger id, @RequestBody Testcaserun testcaserun) throws EntityNotFoundException {
        LOGGER.debug("Editing Testcaserun with id: {}", testcaserun.getTestcaserunid());
        testcaserun.setTestcaserunid(id);
        testcaserun = testcaserunService.update(testcaserun);
        LOGGER.debug("Testcaserun details with id: {}", testcaserun);
        return testcaserun;
    }

    @ApiOperation(value = "Deletes the Testcaserun instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTestcaserun(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Testcaserun with id: {}", id);
        Testcaserun deletedTestcaserun = testcaserunService.delete(id);
        return deletedTestcaserun != null;
    }

    /**
     * @deprecated Use {@link #findTestcaseruns(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Testcaserun instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Testcaserun> searchTestcaserunsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Testcaseruns list");
        return testcaserunService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Testcaserun instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Testcaserun> findTestcaseruns(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Testcaseruns list");
        return testcaserunService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTestcaseruns(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return testcaserunService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Testcaserun instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countTestcaseruns(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Testcaseruns");
        return testcaserunService.count(query);
    }

    @RequestMapping(value = "/{id}/pdutRuns", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the pdutRuns instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PDutRun> findAssociatedPdutRuns(@PathVariable("id") BigInteger id, Pageable pageable) {
        LOGGER.debug("Fetching all associated pdutRuns");
        return testcaserunService.findAssociatedPdutRuns(id, pageable);
    }

    @RequestMapping(value = "/{id:.+}/pnetworkRuns", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the pnetworkRuns instance associated with the given id.")
    public Page<PNetworkRun> findAssociatedPnetworkRuns(@PathVariable("id") BigInteger id, Pageable pageable) {
        LOGGER.debug("Fetching all associated pnetworkRuns");
        return testcaserunService.findAssociatedPnetworkRuns(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestcaserunService instance
	 */
    protected void setTestcaserunService(TestcaserunService service) {
        this.testcaserunService = service;
    }
}
