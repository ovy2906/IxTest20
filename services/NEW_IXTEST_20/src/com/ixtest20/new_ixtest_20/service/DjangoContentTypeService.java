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

import com.ixtest20.new_ixtest_20.AuthPermission;
import com.ixtest20.new_ixtest_20.DjangoContentType;

/**
 * Service object for domain model class {@link DjangoContentType}.
 */
public interface DjangoContentTypeService {

    /**
     * Creates a new DjangoContentType. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DjangoContentType if any.
     *
     * @param djangoContentType Details of the DjangoContentType to be created; value cannot be null.
     * @return The newly created DjangoContentType.
     */
	DjangoContentType create(DjangoContentType djangoContentType);


	/**
	 * Returns DjangoContentType by given id if exists.
	 *
	 * @param djangocontenttypeId The id of the DjangoContentType to get; value cannot be null.
	 * @return DjangoContentType associated with the given djangocontenttypeId.
     * @throws EntityNotFoundException If no DjangoContentType is found.
	 */
	DjangoContentType getById(BigInteger djangocontenttypeId) throws EntityNotFoundException;

    /**
	 * Find and return the DjangoContentType by given id if exists, returns null otherwise.
	 *
	 * @param djangocontenttypeId The id of the DjangoContentType to get; value cannot be null.
	 * @return DjangoContentType associated with the given djangocontenttypeId.
	 */
	DjangoContentType findById(BigInteger djangocontenttypeId);


	/**
	 * Updates the details of an existing DjangoContentType. It replaces all fields of the existing DjangoContentType with the given djangoContentType.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on DjangoContentType if any.
     *
	 * @param djangoContentType The details of the DjangoContentType to be updated; value cannot be null.
	 * @return The updated DjangoContentType.
	 * @throws EntityNotFoundException if no DjangoContentType is found with given input.
	 */
	DjangoContentType update(DjangoContentType djangoContentType) throws EntityNotFoundException;

    /**
	 * Deletes an existing DjangoContentType with the given id.
	 *
	 * @param djangocontenttypeId The id of the DjangoContentType to be deleted; value cannot be null.
	 * @return The deleted DjangoContentType.
	 * @throws EntityNotFoundException if no DjangoContentType found with the given id.
	 */
	DjangoContentType delete(BigInteger djangocontenttypeId) throws EntityNotFoundException;

	/**
	 * Find all DjangoContentTypes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DjangoContentTypes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<DjangoContentType> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all DjangoContentTypes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DjangoContentTypes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<DjangoContentType> findAll(String query, Pageable pageable);

    /**
	 * Exports all DjangoContentTypes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the DjangoContentTypes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the DjangoContentType.
	 */
	long count(String query);

    /*
     * Returns the associated authPermissions for given DjangoContentType id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated AuthPermission instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<AuthPermission> findAssociatedAuthPermissions(BigInteger id, Pageable pageable);

}

