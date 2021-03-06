package com.example.demo.login.vo;

import com.example.demo.common.vo.CommonBaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfoVO extends CommonBaseVO {

	/** ID */
	private int id;
	/** 用户名 */
	private String name;
	/** 用户密码 */
	private String passWord;

}
