package com.example.demo.supplier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.supplier.vo.SupplierVO;

@Mapper
public interface ISupplierDao {

	/**
	 * 添加供应商
	 * 
	 * @param supplierList
	 * @return
	 */
	List<SupplierVO> AddOrUpdateSupplier(List<SupplierVO> supplierList);

	/**
	 * 删除供应商
	 * 
	 * @param supplierList
	 */
	void DeleteSupplier(List<SupplierVO> supplierList);

	/**
	 * 查询供应商
	 * 
	 * @param supplier
	 * @return
	 */
	List<SupplierVO> QueryWl(@Param("supplier") SupplierVO supplier);

}
