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
	CommonResultVO<?> addNeedPlan(HttpServletRequest request, List<MaterialsPlanVO> materialsNeedList);

	/**
	 * 批量删除物料计划
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> deleteNeedPlan(HttpServletRequest request, List<MaterialsPlanVO> materialsNeedList);

	/**
	 * 查询物料计划
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> queryNeedPlan(HttpServletRequest request, MaterialsPlanVO materialsNeed);
}
