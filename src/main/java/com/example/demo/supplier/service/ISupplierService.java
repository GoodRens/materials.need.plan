package com.example.demo.supplier.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.supplier.vo.SupplierVO;

public interface ISupplierService {

	/**
	 * 添加供应商
	 * 
	 * @return
	 */
	CommonResultVO<?> addOrUpdateSupplier(HttpServletRequest request,List<SupplierVO> supplierList);

	/**
	 * 删除供应商
	 * 
	 * @param supplierId
	 * @return
	 */
	CommonResultVO<?> deleteSupplier(HttpServletRequest request,List<SupplierVO> supplierList);

	/**
	 * 查询所有的供应商
	 * 
	 * @param supplierName
	 * @return
	 */
	CommonResultVO<?> querySupplier(HttpServletRequest request,SupplierVO supplier);
}
