/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/
package com.ixtest20.new_ixtest_20.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.ixtest20.new_ixtest_20.DeletedEngine;

/**
 * Specifies methods used to obtain and modify DeletedEngine related information
 * which is stored in the database.
 */
@Repository("NEW_IXTEST_20.DeletedEngineDao")
public class DeletedEngineDao extends WMGenericDaoImpl<DeletedEngine, BigDecimal> {

    @Autowired
    @Qualifier("NEW_IXTEST_20Template")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

