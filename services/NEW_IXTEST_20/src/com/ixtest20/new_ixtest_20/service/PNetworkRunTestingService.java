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

import com.ixtest20.new_ixtest_20.PNetworkRunTesting;

/**
 * Service object for domain model class {@link PNetworkRunTesting}.
 */
public interface PNetworkRunTestingService {

    /**
     * Creates a new PNetworkRunTesting. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PNetworkRunTesting if any.
     *
     * @param pnetworkRunTesting Details of the PNetworkRunTesting to be created; value cannot be null.
     * @return The newly created PNetworkRunTesting.
     */
	PNetworkRunTesting create(PNetworkRunTesting pnetworkRunTesting);


	/**
	 * Returns PNetworkRunTesting by given id if exists.
	 *
	 * @param pnetworkruntestingId The id of the PNetworkRunTesting to get; value cannot be null.
	 * @return PNetworkRunTesting associated with the given pnetworkruntestingId.
     * @throws EntityNotFoundException If no PNetworkRunTesting is found.
	 */
	PNetworkRunTesting getById(BigInteger pnetworkruntestingId) throws EntityNotFoundException;

    /**
	 * Find and return the PNetworkRunTesting by given id if exists, returns null otherwise.
	 *
	 * @param pnetworkruntestingId The id of the PNetworkRunTesting to get; value cannot be null.
	 * @return PNetworkRunTesting associated with the given pnetworkruntestingId.
	 */
	PNetworkRunTesting findById(BigInteger pnetworkruntestingId);


	/**
	 * Updates the details of an existing PNetworkRunTesting. It replaces all fields of the existing PNetworkRunTesting with the given pnetworkRunTesting.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PNetworkRunTesting if any.
     *
	 * @param pnetworkRunTesting The details of the PNetworkRunTesting to be updated; value cannot be null.
	 * @return The updated PNetworkRunTesting.
	 * @throws EntityNotFoundException if no PNetworkRunTesting is found with given input.
	 */
	PNetworkRunTesting update(PNetworkRunTesting pnetworkRunTesting) throws EntityNotFoundException;

    /**
	 * Deletes an existing PNetworkRunTesting with the given id.
	 *
	 * @param pnetworkruntestingId The id of the PNetworkRunTesting to be deleted; value cannot be null.
	 * @return The deleted PNetworkRunTesting.
	 * @throws EntityNotFoundException if no PNetworkRunTesting found with the given id.
	 */
	PNetworkRunTesting delete(BigInteger pnetworkruntestingId) throws EntityNotFoundException;

	/**
	 * Find all PNetworkRunTestings matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PNetworkRunTestings.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PNetworkRunTesting> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PNetworkRunTestings matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PNetworkRunTestings.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PNetworkRunTesting> findAll(String query, Pageable pageable);

    /**
	 * Exports all PNetworkRunTestings matching the given input query to the given exportType format.
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
	 * Retrieve the count of the PNetworkRunTestings in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PNetworkRunTesting.
	 */
	long count(String query);


}
