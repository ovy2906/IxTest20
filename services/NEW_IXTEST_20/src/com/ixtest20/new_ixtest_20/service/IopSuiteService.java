/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.ixtest20.new_ixtest_20.Engines;
import com.ixtest20.new_ixtest_20.IopSuite;

/**
 * Service object for domain model class {@link IopSuite}.
 */
public interface IopSuiteService {

    /**
     * Creates a new IopSuite. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on IopSuite if any.
     *
     * @param iopSuite Details of the IopSuite to be created; value cannot be null.
     * @return The newly created IopSuite.
     */
	IopSuite create(IopSuite iopSuite);


	/**
	 * Returns IopSuite by given id if exists.
	 *
	 * @param iopsuiteId The id of the IopSuite to get; value cannot be null.
	 * @return IopSuite associated with the given iopsuiteId.
     * @throws EntityNotFoundException If no IopSuite is found.
	 */
	IopSuite getById(BigInteger iopsuiteId) throws EntityNotFoundException;

    /**
	 * Find and return the IopSuite by given id if exists, returns null otherwise.
	 *
	 * @param iopsuiteId The id of the IopSuite to get; value cannot be null.
	 * @return IopSuite associated with the given iopsuiteId.
	 */
	IopSuite findById(BigInteger iopsuiteId);


	/**
	 * Updates the details of an existing IopSuite. It replaces all fields of the existing IopSuite with the given iopSuite.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on IopSuite if any.
     *
	 * @param iopSuite The details of the IopSuite to be updated; value cannot be null.
	 * @return The updated IopSuite.
	 * @throws EntityNotFoundException if no IopSuite is found with given input.
	 */
	IopSuite update(IopSuite iopSuite) throws EntityNotFoundException;

    /**
	 * Deletes an existing IopSuite with the given id.
	 *
	 * @param iopsuiteId The id of the IopSuite to be deleted; value cannot be null.
	 * @return The deleted IopSuite.
	 * @throws EntityNotFoundException if no IopSuite found with the given id.
	 */
	IopSuite delete(BigInteger iopsuiteId) throws EntityNotFoundException;

	/**
	 * Find all IopSuites matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching IopSuites.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<IopSuite> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all IopSuites matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching IopSuites.
     *
     * @see Pageable
     * @see Page
	 */
    Page<IopSuite> findAll(String query, Pageable pageable);

    /**
	 * Exports all IopSuites matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the IopSuites in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the IopSuite.
	 */
	long count(String query);

    /*
     * Returns the associated engineses for given IopSuite id.
     *
     * @param iopSuiteId value of iopSuiteId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Engines instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Engines> findAssociatedEngineses(BigInteger iopSuiteId, Pageable pageable);

}

