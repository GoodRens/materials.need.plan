package com.example.demo.common.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 ** 公共的VO，所有的VO必须集成此类
 * 
 * @author MaLongGui
 *
 */
@Getter
@Setter
public class CommonBaseVO {
	/** 创建人 */
	private int createBy;
	/** 创建时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;
	/** 最后更新人 */
	private int lastUpdateBy;
	/** 最后更新时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lastUpdateDate;

}
