package com.example.demo.relation.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentUserRelationVO extends CommonBaseVO {

	/** id */
	private int id;
	/** 部门id */
	private int departmentId;
	/** 部门编号 */
	private int departmentCode;
	/** 用户id */
	private int userId;
}
