/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.ixtest20.new_ixtest_20.Releases;

/**
 * Service object for domain model class {@link Releases}.
 */
public interface ReleasesService {

    /**
     * Creates a new Releases. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Releases if any.
     *
     * @param releases Details of the Releases to be created; value cannot be null.
     * @return The newly created Releases.
     */
	Releases create(Releases releases);


	/**
	 * Returns Releases by given id if exists.
	 *
	 * @param releasesId The id of the Releases to get; value cannot be null.
	 * @return Releases associated with the given releasesId.
     * @throws EntityNotFoundException If no Releases is found.
	 */
	Releases getById(Integer releasesId) throws EntityNotFoundException;

    /**
	 * Find and return the Releases by given id if exists, returns null otherwise.
	 *
	 * @param releasesId The id of the Releases to get; value cannot be null.
	 * @return Releases associated with the given releasesId.
	 */
	Releases findById(Integer releasesId);


	/**
	 * Updates the details of an existing Releases. It replaces all fields of the existing Releases with the given releases.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Releases if any.
     *
	 * @param releases The details of the Releases to be updated; value cannot be null.
	 * @return The updated Releases.
	 * @throws EntityNotFoundException if no Releases is found with given input.
	 */
	Releases update(Releases releases) throws EntityNotFoundException;

    /**
	 * Deletes an existing Releases with the given id.
	 *
	 * @param releasesId The id of the Releases to be deleted; value cannot be null.
	 * @return The deleted Releases.
	 * @throws EntityNotFoundException if no Releases found with the given id.
	 */
	Releases delete(Integer releasesId) throws EntityNotFoundException;

	/**
	 * Find all Releases matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Releases.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Releases> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Releases matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Releases.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Releases> findAll(String query, Pageable pageable);

    /**
	 * Exports all Releases matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Releases in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Releases.
	 */
	long count(String query);


}

