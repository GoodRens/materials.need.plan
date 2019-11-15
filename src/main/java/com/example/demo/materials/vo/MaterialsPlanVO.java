package com.example.demo.materials.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.common.vo.CommonBaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaterialsPlanVO extends CommonBaseVO {

	/** id */
	private int id;
	/** 需求计划编码 */
	private String PlanCode;
	/** 计划类型 年度计划(PP_YEAR ) 月度计划(PP_MONTH) 和紧急计划(PP_Worry) */
	private String PlanType;
	/** 计划名称 */
	private String PlanNmae;
	/** 备注 */
	private String PlanMemo;
	/** 需求部门ID */
	private int PlanDepartID;
	/** 需求部门名称 */
	private String PlanDepartName;
	/** 需求人员 */
	private int PlanUserID;
	/** 需求人员 */
	private String PlanUserName;
	/**
	 * 审批状态 未提交(NoSubmit) 审批中(Approval) 审批通过(ApprovalSuccess) 审批退回 (ApprovalCancel)
	 */
	private String ApprovalStatus;
	/** 是否预算内计划 bool类型 默认为是 */
	private String IsBudget;
	/** 需求计划状态 自由(Free) 已删除(Delete) 已提交 汇总(Submit) 已计划 (Plan) */
	private String PlanStatus;
	/** 物料分类id */
	private int WlCategoryID;
	/** 物料分类名称 */
	private String WlCategoryName;
	/** 物料id */
	private int WlID;
	/** 物料名称 */
	private String WlName;
	/** 规格 */
	private String Specs;
	/** 型号 */
	private String Model;
	/** 单位id */
	private String UnitID;
	/** 单位名称 */
	private String UnitName;
	/** 数量 */
	private int Number;
	/** 需求月份 需求计划类型为年度计划，此字段必填，格式为“年度+月度 */
	private String PlanMonth;
	/** 需求计划月份 需求计划类型为年度计划，此字段必填，格式为“年度+月度 */
	private String needPlanMonth;
	/** 需求日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date PlanDate;
	/** 货源是否固定 bool类型 默认为是 */
	private String IsSupplierFixed;
	/** 期望供应商id */
	private int WishSupplier;
	/** 期望供应商名称 */
	private String WishSupplierName;
	/** 固定供应商id */
	private int FixedSupplier;
	/** 固定供应商名称 */
	private String FixedSupplierName;
	/** 需求库存组 */
	private String PlanStockOrganize;
	/** 物料追踪码 隐藏字段，用于物料追踪，保存时自动生成，格式为需求计划编码+随机编码，物料追踪码不可重复 */
	private String materialTraceCode;
}
