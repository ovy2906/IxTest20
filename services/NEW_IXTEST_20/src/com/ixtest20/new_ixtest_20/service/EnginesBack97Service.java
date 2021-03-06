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

import com.ixtest20.new_ixtest_20.EnginesBack97;

/**
 * Service object for domain model class {@link EnginesBack97}.
 */
public interface EnginesBack97Service {

    /**
     * Creates a new EnginesBack97. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on EnginesBack97 if any.
     *
     * @param enginesBack97 Details of the EnginesBack97 to be created; value cannot be null.
     * @return The newly created EnginesBack97.
     */
	EnginesBack97 create(EnginesBack97 enginesBack97);


	/**
	 * Returns EnginesBack97 by given id if exists.
	 *
	 * @param enginesback97Id The id of the EnginesBack97 to get; value cannot be null.
	 * @return EnginesBack97 associated with the given enginesback97Id.
     * @throws EntityNotFoundException If no EnginesBack97 is found.
	 */
	EnginesBack97 getById(BigInteger enginesback97Id) throws EntityNotFoundException;

    /**
	 * Find and return the EnginesBack97 by given id if exists, returns null otherwise.
	 *
	 * @param enginesback97Id The id of the EnginesBack97 to get; value cannot be null.
	 * @return EnginesBack97 associated with the given enginesback97Id.
	 */
	EnginesBack97 findById(BigInteger enginesback97Id);


	/**
	 * Updates the details of an existing EnginesBack97. It replaces all fields of the existing EnginesBack97 with the given enginesBack97.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on EnginesBack97 if any.
     *
	 * @param enginesBack97 The details of the EnginesBack97 to be updated; value cannot be null.
	 * @return The updated EnginesBack97.
	 * @throws EntityNotFoundException if no EnginesBack97 is found with given input.
	 */
	EnginesBack97 update(EnginesBack97 enginesBack97) throws EntityNotFoundException;

    /**
	 * Deletes an existing EnginesBack97 with the given id.
	 *
	 * @param enginesback97Id The id of the EnginesBack97 to be deleted; value cannot be null.
	 * @return The deleted EnginesBack97.
	 * @throws EntityNotFoundException if no EnginesBack97 found with the given id.
	 */
	EnginesBack97 delete(BigInteger enginesback97Id) throws EntityNotFoundException;

	/**
	 * Find all EnginesBack97s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching EnginesBack97s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<EnginesBack97> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all EnginesBack97s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching EnginesBack97s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<EnginesBack97> findAll(String query, Pageable pageable);

    /**
	 * Exports all EnginesBack97s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the EnginesBack97s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the EnginesBack97.
	 */
	long count(String query);


}

