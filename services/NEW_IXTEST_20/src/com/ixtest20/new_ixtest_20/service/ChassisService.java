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

import com.ixtest20.new_ixtest_20.Chassis;

/**
 * Service object for domain model class {@link Chassis}.
 */
public interface ChassisService {

    /**
     * Creates a new Chassis. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Chassis if any.
     *
     * @param chassis Details of the Chassis to be created; value cannot be null.
     * @return The newly created Chassis.
     */
	Chassis create(Chassis chassis);


	/**
	 * Returns Chassis by given id if exists.
	 *
	 * @param chassisId The id of the Chassis to get; value cannot be null.
	 * @return Chassis associated with the given chassisId.
     * @throws EntityNotFoundException If no Chassis is found.
	 */
	Chassis getById(BigInteger chassisId) throws EntityNotFoundException;

    /**
	 * Find and return the Chassis by given id if exists, returns null otherwise.
	 *
	 * @param chassisId The id of the Chassis to get; value cannot be null.
	 * @return Chassis associated with the given chassisId.
	 */
	Chassis findById(BigInteger chassisId);


	/**
	 * Updates the details of an existing Chassis. It replaces all fields of the existing Chassis with the given chassis.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Chassis if any.
     *
	 * @param chassis The details of the Chassis to be updated; value cannot be null.
	 * @return The updated Chassis.
	 * @throws EntityNotFoundException if no Chassis is found with given input.
	 */
	Chassis update(Chassis chassis) throws EntityNotFoundException;

    /**
	 * Deletes an existing Chassis with the given id.
	 *
	 * @param chassisId The id of the Chassis to be deleted; value cannot be null.
	 * @return The deleted Chassis.
	 * @throws EntityNotFoundException if no Chassis found with the given id.
	 */
	Chassis delete(BigInteger chassisId) throws EntityNotFoundException;

	/**
	 * Find all Chasses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Chasses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Chassis> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Chasses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Chasses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Chassis> findAll(String query, Pageable pageable);

    /**
	 * Exports all Chasses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Chasses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Chassis.
	 */
	long count(String query);


}
