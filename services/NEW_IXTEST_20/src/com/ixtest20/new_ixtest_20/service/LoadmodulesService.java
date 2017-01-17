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

import com.ixtest20.new_ixtest_20.Loadmodules;

/**
 * Service object for domain model class {@link Loadmodules}.
 */
public interface LoadmodulesService {

    /**
     * Creates a new Loadmodules. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Loadmodules if any.
     *
     * @param loadmodules Details of the Loadmodules to be created; value cannot be null.
     * @return The newly created Loadmodules.
     */
	Loadmodules create(Loadmodules loadmodules);


	/**
	 * Returns Loadmodules by given id if exists.
	 *
	 * @param loadmodulesId The id of the Loadmodules to get; value cannot be null.
	 * @return Loadmodules associated with the given loadmodulesId.
     * @throws EntityNotFoundException If no Loadmodules is found.
	 */
	Loadmodules getById(BigInteger loadmodulesId) throws EntityNotFoundException;

    /**
	 * Find and return the Loadmodules by given id if exists, returns null otherwise.
	 *
	 * @param loadmodulesId The id of the Loadmodules to get; value cannot be null.
	 * @return Loadmodules associated with the given loadmodulesId.
	 */
	Loadmodules findById(BigInteger loadmodulesId);


	/**
	 * Updates the details of an existing Loadmodules. It replaces all fields of the existing Loadmodules with the given loadmodules.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Loadmodules if any.
     *
	 * @param loadmodules The details of the Loadmodules to be updated; value cannot be null.
	 * @return The updated Loadmodules.
	 * @throws EntityNotFoundException if no Loadmodules is found with given input.
	 */
	Loadmodules update(Loadmodules loadmodules) throws EntityNotFoundException;

    /**
	 * Deletes an existing Loadmodules with the given id.
	 *
	 * @param loadmodulesId The id of the Loadmodules to be deleted; value cannot be null.
	 * @return The deleted Loadmodules.
	 * @throws EntityNotFoundException if no Loadmodules found with the given id.
	 */
	Loadmodules delete(BigInteger loadmodulesId) throws EntityNotFoundException;

	/**
	 * Find all Loadmodules matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Loadmodules.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Loadmodules> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Loadmodules matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Loadmodules.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Loadmodules> findAll(String query, Pageable pageable);

    /**
	 * Exports all Loadmodules matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Loadmodules in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Loadmodules.
	 */
	long count(String query);


}

