/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.ixtest20.new_ixtest_20.DeletionStatus;

/**
 * Service object for domain model class {@link DeletionStatus}.
 */
public interface DeletionStatusService {

    /**
     * Creates a new DeletionStatus. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DeletionStatus if any.
     *
     * @param deletionStatus Details of the DeletionStatus to be created; value cannot be null.
     * @return The newly created DeletionStatus.
     */
	DeletionStatus create(DeletionStatus deletionStatus);


	/**
	 * Returns DeletionStatus by given id if exists.
	 *
	 * @param deletionstatusId The id of the DeletionStatus to get; value cannot be null.
	 * @return DeletionStatus associated with the given deletionstatusId.
     * @throws EntityNotFoundException If no DeletionStatus is found.
	 */
	DeletionStatus getById(BigDecimal deletionstatusId) throws EntityNotFoundException;

    /**
	 * Find and return the DeletionStatus by given id if exists, returns null otherwise.
	 *
	 * @param deletionstatusId The id of the DeletionStatus to get; value cannot be null.
	 * @return DeletionStatus associated with the given deletionstatusId.
	 */
	DeletionStatus findById(BigDecimal deletionstatusId);


	/**
	 * Updates the details of an existing DeletionStatus. It replaces all fields of the existing DeletionStatus with the given deletionStatus.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on DeletionStatus if any.
     *
	 * @param deletionStatus The details of the DeletionStatus to be updated; value cannot be null.
	 * @return The updated DeletionStatus.
	 * @throws EntityNotFoundException if no DeletionStatus is found with given input.
	 */
	DeletionStatus update(DeletionStatus deletionStatus) throws EntityNotFoundException;

    /**
	 * Deletes an existing DeletionStatus with the given id.
	 *
	 * @param deletionstatusId The id of the DeletionStatus to be deleted; value cannot be null.
	 * @return The deleted DeletionStatus.
	 * @throws EntityNotFoundException if no DeletionStatus found with the given id.
	 */
	DeletionStatus delete(BigDecimal deletionstatusId) throws EntityNotFoundException;

	/**
	 * Find all DeletionStatuses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DeletionStatuses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<DeletionStatus> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all DeletionStatuses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DeletionStatuses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<DeletionStatus> findAll(String query, Pageable pageable);

    /**
	 * Exports all DeletionStatuses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the DeletionStatuses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the DeletionStatus.
	 */
	long count(String query);


}

