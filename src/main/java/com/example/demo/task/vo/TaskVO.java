package com.example.demo.task.vo;

import com.example.demo.common.vo.CommonBaseVO;

public class TaskVO extends CommonBaseVO {

	private int id;
	/** 任务发起人id */
	private int assignee;
	/** 任务发起人姓名 */
	private String assigneeName;
	/** 任务处理id */
	private int taskTo;
	/** 任务处理人姓名 */
	private String taskToName;
	/** 任务主键 */
	private int business_key;
	/** 任务状态1待审批2已审批 */
	private String taskStatue;
	/** 任务标题 */
	private String taskTitle;
	/** 处理意见 */
	private String todoRemark;
}
