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
import com.ixtest20.new_ixtest_20.AuthPermission;
import com.ixtest20.new_ixtest_20.DjangoContentType;
import com.ixtest20.new_ixtest_20.service.DjangoContentTypeService;

/**
 * Controller object for domain model class DjangoContentType.
 * @see DjangoContentType
 */
@RestController("NEW_IXTEST_20.DjangoContentTypeController")
@Api(value = "DjangoContentTypeController", description = "Exposes APIs to work with DjangoContentType resource.")
@RequestMapping("/NEW_IXTEST_20/DjangoContentType")
public class DjangoContentTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DjangoContentTypeController.class);

    @Autowired
    @Qualifier("NEW_IXTEST_20.DjangoContentTypeService")
    private DjangoContentTypeService djangoContentTypeService;

    @ApiOperation(value = "Creates a new DjangoContentType instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DjangoContentType createDjangoContentType(@RequestBody DjangoContentType djangoContentType) {
        LOGGER.debug("Create DjangoContentType with information: {}", djangoContentType);
        djangoContentType = djangoContentTypeService.create(djangoContentType);
        LOGGER.debug("Created DjangoContentType with information: {}", djangoContentType);
        return djangoContentType;
    }

    @ApiOperation(value = "Returns the DjangoContentType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DjangoContentType getDjangoContentType(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting DjangoContentType with id: {}", id);
        DjangoContentType foundDjangoContentType = djangoContentTypeService.getById(id);
        LOGGER.debug("DjangoContentType details with id: {}", foundDjangoContentType);
        return foundDjangoContentType;
    }

    @ApiOperation(value = "Updates the DjangoContentType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DjangoContentType editDjangoContentType(@PathVariable("id") BigInteger id, @RequestBody DjangoContentType djangoContentType) throws EntityNotFoundException {
        LOGGER.debug("Editing DjangoContentType with id: {}", djangoContentType.getId());
        djangoContentType.setId(id);
        djangoContentType = djangoContentTypeService.update(djangoContentType);
        LOGGER.debug("DjangoContentType details with id: {}", djangoContentType);
        return djangoContentType;
    }

    @ApiOperation(value = "Deletes the DjangoContentType instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDjangoContentType(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting DjangoContentType with id: {}", id);
        DjangoContentType deletedDjangoContentType = djangoContentTypeService.delete(id);
        return deletedDjangoContentType != null;
    }

    /**
     * @deprecated Use {@link #findDjangoContentTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DjangoContentType instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DjangoContentType> searchDjangoContentTypesByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DjangoContentTypes list");
        return djangoContentTypeService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of DjangoContentType instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DjangoContentType> findDjangoContentTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DjangoContentTypes list");
        return djangoContentTypeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDjangoContentTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return djangoContentTypeService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of DjangoContentType instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countDjangoContentTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting DjangoContentTypes");
        return djangoContentTypeService.count(query);
    }

    @RequestMapping(value = "/{id}/authPermissions", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the authPermissions instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AuthPermission> findAssociatedAuthPermissions(@PathVariable("id") BigInteger id, Pageable pageable) {
        LOGGER.debug("Fetching all associated authPermissions");
        return djangoContentTypeService.findAssociatedAuthPermissions(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DjangoContentTypeService instance
	 */
    protected void setDjangoContentTypeService(DjangoContentTypeService service) {
        this.djangoContentTypeService = service;
    }
}
