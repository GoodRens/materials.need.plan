package com.example.demo.materials.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaterialsNeedVO extends CommonBaseVO {

	/** id */
	private int id;
	/** 需求标题 */
	private String title;
	/** 物料类别 */
	private String materialsSort;
	/** 物料编码 */
	private String materialsCode;
	/** 需求数量 */
	private String needCount;
	/** 需求日期 */
	private String needDate;
	/** 需求单位 */
	private String needUnit;
	/** 技术参数 */
	private String technicalParameters;
	/** 备注物料编码 */
	private String remark;
}
