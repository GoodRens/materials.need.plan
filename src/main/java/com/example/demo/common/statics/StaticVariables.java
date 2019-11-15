package com.example.demo.common.statics;

import java.lang.annotation.ElementType;

/**
 * 静态变量
 * 
 * @author MaLongGui
 *
 */
public class StaticVariables {

	public static ElementType[] userStatus = {};

	// 生产计划员
	public static String productionPlanner = "生产计划员";

	// 生产主管
	public static String productionSupervisor = "生产主管";

	// 需求计划员
	public static String needPlanner = "需求计划员";

	// 需求提报员
	public static String needSubmiter = "需求提报员";

	// 需求部门主管
	public static String needSupervisor = "需求部门主管";

	//
	public static String[] materialsNeedExportHeads = { "物料分类编码", "物料分类名称", "物料编码", "物料名称", "规格", "型号", "单位",
			"需求数量", "需求月份", "需求日期", "货源是否确定", "期望供应商", "固定供应", "备注" };
}
