package com.example.demo.materials.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.vo.MaterialsNeedVO;

public interface IMaterialsNeedService {

	/**
	 * 批量创建物料需求
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> createMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList);

	/**
	 * 批量删除物料需求
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> deleteMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList);

	/**
	 * 批量更新物料需求
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> updateMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList);
}
