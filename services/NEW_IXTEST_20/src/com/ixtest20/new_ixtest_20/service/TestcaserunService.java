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

import com.ixtest20.new_ixtest_20.Testcaserun;

/**
 * Service object for domain model class {@link Testcaserun}.
 */
public interface TestcaserunService {

    /**
     * Creates a new Testcaserun. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Testcaserun if any.
     *
     * @param testcaserun Details of the Testcaserun to be created; value cannot be null.
     * @return The newly created Testcaserun.
     */
	Testcaserun create(Testcaserun testcaserun);


	/**
	 * Returns Testcaserun by given id if exists.
	 *
	 * @param testcaserunId The id of the Testcaserun to get; value cannot be null.
	 * @return Testcaserun associated with the given testcaserunId.
     * @throws EntityNotFoundException If no Testcaserun is found.
	 */
	Testcaserun getById(BigInteger testcaserunId) throws EntityNotFoundException;

    /**
	 * Find and return the Testcaserun by given id if exists, returns null otherwise.
	 *
	 * @param testcaserunId The id of the Testcaserun to get; value cannot be null.
	 * @return Testcaserun associated with the given testcaserunId.
	 */
	Testcaserun findById(BigInteger testcaserunId);


	/**
	 * Updates the details of an existing Testcaserun. It replaces all fields of the existing Testcaserun with the given testcaserun.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Testcaserun if any.
     *
	 * @param testcaserun The details of the Testcaserun to be updated; value cannot be null.
	 * @return The updated Testcaserun.
	 * @throws EntityNotFoundException if no Testcaserun is found with given input.
	 */
	Testcaserun update(Testcaserun testcaserun) throws EntityNotFoundException;

    /**
	 * Deletes an existing Testcaserun with the given id.
	 *
	 * @param testcaserunId The id of the Testcaserun to be deleted; value cannot be null.
	 * @return The deleted Testcaserun.
	 * @throws EntityNotFoundException if no Testcaserun found with the given id.
	 */
	Testcaserun delete(BigInteger testcaserunId) throws EntityNotFoundException;

	/**
	 * Find all Testcaseruns matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testcaseruns.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Testcaserun> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Testcaseruns matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testcaseruns.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Testcaserun> findAll(String query, Pageable pageable);

    /**
	 * Exports all Testcaseruns matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Testcaseruns in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Testcaserun.
	 */
	long count(String query);


}

