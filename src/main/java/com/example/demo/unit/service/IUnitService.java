package com.example.demo.unit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.unit.vo.UnitVO;

public interface IUnitService {

	/**
	 * 添加单位
	 * 
	 * @return
	 */
	CommonResultVO<?> addOrUpdateunit(HttpServletRequest request, List<UnitVO> unitList);

	/**
	 * 删除单位
	 * 
	 * @param supplierId
	 * @return
	 */
	CommonResultVO<?> deleteunit(HttpServletRequest request, List<UnitVO> unitList);

	/**
	 * 查询单位
	 * 
	 * @param supplierName
	 * @return
	 */
	CommonResultVO<?> queryunit(HttpServletRequest request, UnitVO unit);
}
