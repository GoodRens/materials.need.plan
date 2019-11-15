package com.example.demo.flow.service;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.vo.MaterialsNeedVO;

/**
 * 采购需求管理流程 - 紧急型
 * 
 * @author MaLongGui
 *
 */
public interface IPurchaseFlowOfInstancyService {

	/**
	 * 需求提报员发起申请
	 * 
	 * @param needVO
	 * @return
	 */
	CommonResultVO<?> startApply(MaterialsNeedVO needVO);

	/**
	 * 需求部门主管审批
	 * 
	 * @param needVO
	 * @return
	 */
	CommonResultVO<?> needSupervisorApproval(MaterialsNeedVO needVO);


	/**
	 * 需求计划员审批
	 * 
	 * @param needVO
	 * @return
	 */
	CommonResultVO<?> needPlannerApproval(MaterialsNeedVO needVO);

	/**
	 * 需求计划员需求处理-形成采购计划
	 * 
	 * @param needVO
	 * @return
	 */
	CommonResultVO<?> needPlannerDispose(MaterialsNeedVO needVO);

}
