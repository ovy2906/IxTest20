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
import com.ixtest20.new_ixtest_20.AssociatedApp;
import com.ixtest20.new_ixtest_20.Builds;
import com.ixtest20.new_ixtest_20.service.AssociatedAppService;

/**
 * Controller object for domain model class AssociatedApp.
 * @see AssociatedApp
 */
@RestController("NEW_IXTEST_20.AssociatedAppController")
@Api(value = "AssociatedAppController", description = "Exposes APIs to work with AssociatedApp resource.")
@RequestMapping("/NEW_IXTEST_20/AssociatedApp")
public class AssociatedAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociatedAppController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.AssociatedAppService")
    private AssociatedAppService associatedAppService;

    @ApiOperation(value = "Creates a new AssociatedApp instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AssociatedApp createAssociatedApp(@RequestBody AssociatedApp associatedApp) {
        LOGGER.debug("Create AssociatedApp with information: {}", associatedApp);
        associatedApp = associatedAppService.create(associatedApp);
        LOGGER.debug("Created AssociatedApp with information: {}", associatedApp);
        return associatedApp;
    }

    @ApiOperation(value = "Returns the AssociatedApp instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AssociatedApp getAssociatedApp(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting AssociatedApp with id: {}", id);
        AssociatedApp foundAssociatedApp = associatedAppService.getById(id);
        LOGGER.debug("AssociatedApp details with id: {}", foundAssociatedApp);
        return foundAssociatedApp;
    }

    @ApiOperation(value = "Updates the AssociatedApp instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AssociatedApp editAssociatedApp(@PathVariable("id") BigInteger id, @RequestBody AssociatedApp associatedApp) throws EntityNotFoundException {
        LOGGER.debug("Editing AssociatedApp with id: {}", associatedApp.getId());
        associatedApp.setId(id);
        associatedApp = associatedAppService.update(associatedApp);
        LOGGER.debug("AssociatedApp details with id: {}", associatedApp);
        return associatedApp;
    }

    @ApiOperation(value = "Deletes the AssociatedApp instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAssociatedApp(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AssociatedApp with id: {}", id);
        AssociatedApp deletedAssociatedApp = associatedAppService.delete(id);
        return deletedAssociatedApp != null;
    }

    /**
     * @deprecated Use {@link #findAssociatedApps(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AssociatedApp instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AssociatedApp> searchAssociatedAppsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AssociatedApps list");
        return associatedAppService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of AssociatedApp instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AssociatedApp> findAssociatedApps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AssociatedApps list");
        return associatedAppService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAssociatedApps(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return associatedAppService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of AssociatedApp instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countAssociatedApps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting AssociatedApps");
        return associatedAppService.count(query);
    }

    @RequestMapping(value = "/{id}/buildses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the buildses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Builds> findAssociatedBuildses(@PathVariable("id") BigInteger id, Pageable pageable) {
        LOGGER.debug("Fetching all associated buildses");
        return associatedAppService.findAssociatedBuildses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AssociatedAppService instance
	 */
    protected void setAssociatedAppService(AssociatedAppService service) {
        this.associatedAppService = service;
    }
}
