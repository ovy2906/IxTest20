/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
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
import com.ixtest20.new_ixtest_20.Releases;
import com.ixtest20.new_ixtest_20.service.ReleasesService;

/**
 * Controller object for domain model class Releases.
 * @see Releases
 */
@RestController("NEW_IXTEST_20.ReleasesController")
@Api(value = "ReleasesController", description = "Exposes APIs to work with Releases resource.")
@RequestMapping("/NEW_IXTEST_20/Releases")
public class ReleasesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReleasesController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.ReleasesService")
    private ReleasesService releasesService;

    @ApiOperation(value = "Creates a new Releases instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Releases createReleases(@RequestBody Releases releases) {
        LOGGER.debug("Create Releases with information: {}", releases);
        releases = releasesService.create(releases);
        LOGGER.debug("Created Releases with information: {}", releases);
        return releases;
    }

    @ApiOperation(value = "Returns the Releases instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Releases getReleases(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Releases with id: {}", id);
        Releases foundReleases = releasesService.getById(id);
        LOGGER.debug("Releases details with id: {}", foundReleases);
        return foundReleases;
    }

    @ApiOperation(value = "Updates the Releases instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Releases editReleases(@PathVariable("id") Integer id, @RequestBody Releases releases) throws EntityNotFoundException {
        LOGGER.debug("Editing Releases with id: {}", releases.getReleaseid());
        releases.setReleaseid(id);
        releases = releasesService.update(releases);
        LOGGER.debug("Releases details with id: {}", releases);
        return releases;
    }

    @ApiOperation(value = "Deletes the Releases instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteReleases(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Releases with id: {}", id);
        Releases deletedReleases = releasesService.delete(id);
        return deletedReleases != null;
    }

    /**
     * @deprecated Use {@link #findReleases(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Releases instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Releases> searchReleasesByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Releases list");
        return releasesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Releases instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Releases> findReleases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Releases list");
        return releasesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportReleases(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return releasesService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Releases instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countReleases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Releases");
        return releasesService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ReleasesService instance
	 */
    protected void setReleasesService(ReleasesService service) {
        this.releasesService = service;
    }
}
