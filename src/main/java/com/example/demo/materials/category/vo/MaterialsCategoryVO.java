package com.example.demo.materials.category.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialsCategoryVO extends CommonBaseVO {

	/** id */
	private int id;
	/** 物料分类名称 */
	private String WlCategoryName;
}
