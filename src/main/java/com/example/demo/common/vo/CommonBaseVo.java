package com.example.demo.common.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 ** 公共的VO，所有的VO必须集成此类
 * 
 * @author MaLongGui
 *
 */
@Getter
@Setter
@ToString
public class CommonBaseVo {
	/** 创建人 */
	private int createrBy;
	/** 创建时间 */
	private Date createDate;
	/** 最后更新人 */
	private int lastUpdateBy;
	/** 最后更新时间 */
	private Date lastUpdateDate;
}
