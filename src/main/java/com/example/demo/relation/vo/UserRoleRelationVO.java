package com.example.demo.relation.vo;

import com.example.demo.common.vo.CommonBaseVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRoleRelationVO extends CommonBaseVo {

	/** id */
	private int id;
	/** 用户id */
	private int userId;
	/** 角色 */
	private int roleId;
}
