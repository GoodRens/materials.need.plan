package com.example.demo.unit.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;

/**
 * 物料单位VO
 * 
 * @author MaLongGui
 *
 */
@Getter
@Setter
public class UnitVO extends CommonBaseVO {
	/** id */
	private int UnitID;
	/** 单位名称 */
	private String UnitName;
}
