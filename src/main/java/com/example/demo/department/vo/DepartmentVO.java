package com.example.demo.department.vo;

import java.util.List;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentVO extends CommonBaseVO{

	private int id;
	/** 部门编号 */
	private String departmentCode;
	/** 部门名称 */
	private String departmentName;
	/** 父节点id */
	private int parentId;
	/** 是否存在子部门 0存在1不存在 */
	private String isExistChilden;
	/** 部门层级 */
	private String departmentLevel;
	/** 子部门 */
	private List<DepartmentVO> departmentChildren;
}
