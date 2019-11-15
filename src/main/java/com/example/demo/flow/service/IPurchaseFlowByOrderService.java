package com.example.demo.flow.service;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.vo.MaterialsNeedVO;

/**
 * 采购需求管理流程 - 订单型
 * 
 * @author MaLongGui
 *
 */
public interface IPurchaseFlowByOrderService {

	/**
	 * 生产计划员发起申请
	 * 
	 * @param needVO
	 * @return
	 */
	CommonResultVO<?> startApply(MaterialsNeedVO needVO);

	/**
	 * 生产主管审批
	 * 
	 * @param needVO
	 * @return
	 */
	CommonResultVO<?> productionSupervisorApproval(MaterialsNeedVO needVO);

	/**
	 * 需求计划员需求编制
	 * 
	 * @param needVO
	 * @return
	 */
	CommonResultVO<?> needPlannerCompile(MaterialsNeedVO needVO);

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
