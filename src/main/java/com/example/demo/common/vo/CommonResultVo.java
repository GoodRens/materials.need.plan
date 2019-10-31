package com.example.demo.common.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResultVo<T> {

	/** 返回状态 */
	private int code;
	/** 返回信息 */
	private String msg;
	/** 返回结果 */
	private String result;
	
	private T resultVo;
}
