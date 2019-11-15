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
public class MaterialsNeedVO extends CommonBaseVO {

	/** id */
	private int id;
	/** 需求标题 */
	private String title;
	/** 物料类别 */
	private String materialsSort;
	/** 物料编码 */
	private int materialsCode;
	/** 需求数量 */
	private int needCount;
	/** 需求日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date needDate;
	/** 需求单位 */
	private String needUnit;
	/** 技术参数 */
	private String technicalParameters;
	/** 备注物料编码 */
	private String remark;
}
