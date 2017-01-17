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

import com.ixtest20.new_ixtest_20.AuthGroup;

/**
 * Service object for domain model class {@link AuthGroup}.
 */
public interface AuthGroupService {

    /**
     * Creates a new AuthGroup. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AuthGroup if any.
     *
     * @param authGroup Details of the AuthGroup to be created; value cannot be null.
     * @return The newly created AuthGroup.
     */
	AuthGroup create(AuthGroup authGroup);


	/**
	 * Returns AuthGroup by given id if exists.
	 *
	 * @param authgroupId The id of the AuthGroup to get; value cannot be null.
	 * @return AuthGroup associated with the given authgroupId.
     * @throws EntityNotFoundException If no AuthGroup is found.
	 */
	AuthGroup getById(BigInteger authgroupId) throws EntityNotFoundException;

    /**
	 * Find and return the AuthGroup by given id if exists, returns null otherwise.
	 *
	 * @param authgroupId The id of the AuthGroup to get; value cannot be null.
	 * @return AuthGroup associated with the given authgroupId.
	 */
	AuthGroup findById(BigInteger authgroupId);


	/**
	 * Updates the details of an existing AuthGroup. It replaces all fields of the existing AuthGroup with the given authGroup.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AuthGroup if any.
     *
	 * @param authGroup The details of the AuthGroup to be updated; value cannot be null.
	 * @return The updated AuthGroup.
	 * @throws EntityNotFoundException if no AuthGroup is found with given input.
	 */
	AuthGroup update(AuthGroup authGroup) throws EntityNotFoundException;

    /**
	 * Deletes an existing AuthGroup with the given id.
	 *
	 * @param authgroupId The id of the AuthGroup to be deleted; value cannot be null.
	 * @return The deleted AuthGroup.
	 * @throws EntityNotFoundException if no AuthGroup found with the given id.
	 */
	AuthGroup delete(BigInteger authgroupId) throws EntityNotFoundException;

	/**
	 * Find all AuthGroups matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AuthGroups.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AuthGroup> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AuthGroups matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AuthGroups.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AuthGroup> findAll(String query, Pageable pageable);

    /**
	 * Exports all AuthGroups matching the given input query to the given exportType format.
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
	 * Retrieve the count of the AuthGroups in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AuthGroup.
	 */
	long count(String query);


}
