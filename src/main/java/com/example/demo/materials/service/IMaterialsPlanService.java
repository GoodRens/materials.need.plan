package com.example.demo.materials.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.vo.MaterialsNeedVO;

public interface IMaterialsPlanService {

	/**
	 * 批量创建物料需求
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> AddNeedPlan(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList);

	/**
	 * 批量删除物料需求
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> DeleteNeedPlan(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList);

	/**
	 * 批量更新物料需求
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> QueryNeedPlan(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList);
}
