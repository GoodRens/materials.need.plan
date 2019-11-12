package com.example.demo.unit.service;

import com.example.demo.common.vo.CommonResultVO;

public interface IUnitService {

	/**
	 * 添加单位
	 * 
	 * @return
	 */
	CommonResultVO<?> AddOrUpdateunit();

	/**
	 * 删除单位
	 * 
	 * @param supplierId
	 * @return
	 */
	CommonResultVO<?> Deleteunit(String supplierId);

	/**
	 * 查询单位
	 * 
	 * @param supplierName
	 * @return
	 */
	CommonResultVO<?> Queryunit(String supplierName);
}
