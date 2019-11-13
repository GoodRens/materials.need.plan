package com.example.demo.materials.category.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.category.vo.MaterialsCategoryVO;

public interface IMaterialsCategoryService {

	/**
	 * 增加物料分类
	 * 
	 * @param request
	 * @param materialsCategoryList
	 * @return
	 */
	CommonResultVO<?> addOrUpdateWlCategory(HttpServletRequest request,
			List<MaterialsCategoryVO> materialsCategoryList);

	/**
	 * 删除物料分类
	 * 
	 * @param request
	 * @param materialsCategoryList
	 * @return
	 */
	CommonResultVO<?> deleteWlCategory(HttpServletRequest request, List<MaterialsCategoryVO> materialsCategoryList);

	/**
	 * 查询物料分类
	 * 
	 * @param request
	 * @param materialsCategory
	 * @return
	 */
	CommonResultVO<?> queryWlCategory(HttpServletRequest request, MaterialsCategoryVO materialsCategory);
}
