package com.example.demo.role.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleVO extends CommonBaseVO {

	/** id */ 
	private int id;
	/** 角色名称 */ 
	private String roleName;
	/** 角色编号 */
	private int roleCode;
}
