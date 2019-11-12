package com.example.demo.supplier.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierVO extends CommonBaseVO {
	/** 供应商id */
	private int SupplierID;
	/** 供应商名称 */
	private String SupplierName;
}
