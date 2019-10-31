package com.example.demo.login.vo;

import com.example.demo.common.vo.CommonBaseVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoVO extends CommonBaseVo {

	/** ID */
	private int id;
	/** 用户名 */
	private String name;
	/** 用户密码 */
	private String passWord;

}
