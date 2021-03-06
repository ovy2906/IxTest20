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
import com.ixtest20.new_ixtest_20.TestcasesBack;
import com.ixtest20.new_ixtest_20.service.TestcasesBackService;

/**
 * Controller object for domain model class TestcasesBack.
 * @see TestcasesBack
 */
@RestController("NEW_IXTEST_20.TestcasesBackController")
@Api(value = "TestcasesBackController", description = "Exposes APIs to work with TestcasesBack resource.")
@RequestMapping("/NEW_IXTEST_20/TestcasesBack")
public class TestcasesBackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestcasesBackController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.TestcasesBackService")
    private TestcasesBackService testcasesBackService;

    @ApiOperation(value = "Creates a new TestcasesBack instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TestcasesBack createTestcasesBack(@RequestBody TestcasesBack testcasesBack) {
        LOGGER.debug("Create TestcasesBack with information: {}", testcasesBack);
        testcasesBack = testcasesBackService.create(testcasesBack);
        LOGGER.debug("Created TestcasesBack with information: {}", testcasesBack);
        return testcasesBack;
    }

    @ApiOperation(value = "Returns the TestcasesBack instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TestcasesBack getTestcasesBack(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting TestcasesBack with id: {}", id);
        TestcasesBack foundTestcasesBack = testcasesBackService.getById(id);
        LOGGER.debug("TestcasesBack details with id: {}", foundTestcasesBack);
        return foundTestcasesBack;
    }

    @ApiOperation(value = "Updates the TestcasesBack instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TestcasesBack editTestcasesBack(@PathVariable("id") BigInteger id, @RequestBody TestcasesBack testcasesBack) throws EntityNotFoundException {
        LOGGER.debug("Editing TestcasesBack with id: {}", testcasesBack.getTestcaseid());
        testcasesBack.setTestcaseid(id);
        testcasesBack = testcasesBackService.update(testcasesBack);
        LOGGER.debug("TestcasesBack details with id: {}", testcasesBack);
        return testcasesBack;
    }

    @ApiOperation(value = "Deletes the TestcasesBack instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTestcasesBack(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TestcasesBack with id: {}", id);
        TestcasesBack deletedTestcasesBack = testcasesBackService.delete(id);
        return deletedTestcasesBack != null;
    }

    /**
     * @deprecated Use {@link #findTestcasesBacks(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TestcasesBack instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestcasesBack> searchTestcasesBacksByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TestcasesBacks list");
        return testcasesBackService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of TestcasesBack instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestcasesBack> findTestcasesBacks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TestcasesBacks list");
        return testcasesBackService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTestcasesBacks(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return testcasesBackService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of TestcasesBack instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countTestcasesBacks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TestcasesBacks");
        return testcasesBackService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestcasesBackService instance
	 */
    protected void setTestcasesBackService(TestcasesBackService service) {
        this.testcasesBackService = service;
    }
}
