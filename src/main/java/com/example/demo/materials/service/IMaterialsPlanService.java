package com.example.demo.materials.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.vo.MaterialsPlanVO;

public interface IMaterialsPlanService {

	/**
	 * 批量创建物料计划
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> AddNeedPlan(HttpServletRequest request, List<MaterialsPlanVO> materialsNeedList);

	/**
	 * 批量删除物料计划
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> DeleteNeedPlan(HttpServletRequest request, List<MaterialsPlanVO> materialsNeedList);

	/**
	 * 批量更新物料计划
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> QueryNeedPlan(HttpServletRequest request, MaterialsPlanVO materialsNeed);
}
