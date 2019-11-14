package com.example.demo.materials.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaterialsVO extends CommonBaseVO {

	/** id */
	private int id;
	/** 物料名称 */
	private String WlName;
	/** 物料编码 */
	private String WlCID;
}
