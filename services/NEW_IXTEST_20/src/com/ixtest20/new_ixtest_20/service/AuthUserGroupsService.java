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

import com.ixtest20.new_ixtest_20.AuthUserGroups;

/**
 * Service object for domain model class {@link AuthUserGroups}.
 */
public interface AuthUserGroupsService {

    /**
     * Creates a new AuthUserGroups. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AuthUserGroups if any.
     *
     * @param authUserGroups Details of the AuthUserGroups to be created; value cannot be null.
     * @return The newly created AuthUserGroups.
     */
	AuthUserGroups create(AuthUserGroups authUserGroups);


	/**
	 * Returns AuthUserGroups by given id if exists.
	 *
	 * @param authusergroupsId The id of the AuthUserGroups to get; value cannot be null.
	 * @return AuthUserGroups associated with the given authusergroupsId.
     * @throws EntityNotFoundException If no AuthUserGroups is found.
	 */
	AuthUserGroups getById(BigInteger authusergroupsId) throws EntityNotFoundException;

    /**
	 * Find and return the AuthUserGroups by given id if exists, returns null otherwise.
	 *
	 * @param authusergroupsId The id of the AuthUserGroups to get; value cannot be null.
	 * @return AuthUserGroups associated with the given authusergroupsId.
	 */
	AuthUserGroups findById(BigInteger authusergroupsId);


	/**
	 * Updates the details of an existing AuthUserGroups. It replaces all fields of the existing AuthUserGroups with the given authUserGroups.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AuthUserGroups if any.
     *
	 * @param authUserGroups The details of the AuthUserGroups to be updated; value cannot be null.
	 * @return The updated AuthUserGroups.
	 * @throws EntityNotFoundException if no AuthUserGroups is found with given input.
	 */
	AuthUserGroups update(AuthUserGroups authUserGroups) throws EntityNotFoundException;

    /**
	 * Deletes an existing AuthUserGroups with the given id.
	 *
	 * @param authusergroupsId The id of the AuthUserGroups to be deleted; value cannot be null.
	 * @return The deleted AuthUserGroups.
	 * @throws EntityNotFoundException if no AuthUserGroups found with the given id.
	 */
	AuthUserGroups delete(BigInteger authusergroupsId) throws EntityNotFoundException;

	/**
	 * Find all AuthUserGroups matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AuthUserGroups.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AuthUserGroups> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AuthUserGroups matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AuthUserGroups.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AuthUserGroups> findAll(String query, Pageable pageable);

    /**
	 * Exports all AuthUserGroups matching the given input query to the given exportType format.
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
	 * Retrieve the count of the AuthUserGroups in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AuthUserGroups.
	 */
	long count(String query);


}
