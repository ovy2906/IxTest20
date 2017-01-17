/*Copyright (c) 2017-2018 ixiacom.com All Rights Reserved.
 This software is the confidential and proprietary information of ixiacom.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with ixiacom.com*/

package com.ixtest20.new_ixtest_20.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

@Service
public class NEW_IXTEST_20ProcedureExecutorServiceImpl implements NEW_IXTEST_20ProcedureExecutorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NEW_IXTEST_20ProcedureExecutorServiceImpl.class);

	@Autowired
	@Qualifier("NEW_IXTEST_20WMProcedureExecutor")
	private WMProcedureExecutor procedureExecutor;


	@Transactional(value = "NEW_IXTEST_20TransactionManager")
	@Override
	public List<Object> executeWMCustomProcedure(CustomProcedure procedure) {
	    return procedureExecutor.executeCustomProcedure(procedure);
	}


}

