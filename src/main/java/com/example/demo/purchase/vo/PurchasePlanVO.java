package com.example.demo.purchase.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 采购计划VO
 * 
 * @author MaLongGui
 *
 */
@Getter
@Setter
public class PurchasePlanVO {

	/** id */
	private int id;
	/** 采购编号 */
	private String code;
	/** 采购名称 */
	private String name;
	/** 采购类型 */
	private String type;
	/** 申请状态 */
	private String approveStatus;
	/** 采购订单 */
	private String makeOrder;
}
