package com.example.demo.department.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.department.vo.DepartmentVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Department Controller")
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

	@Autowired
	IDepartmentService service;

	@ApiOperation(value = "获取部门", notes = "存在层级关系")
	@RequestMapping(value = "/getDepartments", method = RequestMethod.POST)
	public CommonResultVo<?> getDepartments(HttpServletRequest request, @RequestBody DepartmentVo departmentVo) {
		return service.getDepartments(request, departmentVo);
	}

	@ApiOperation(value = "创建部门", notes = "部门名称，部门层级，父部门id必填（无时为0）")
	@RequestMapping(value = "/createDepartments", method = RequestMethod.POST)
	public CommonResultVo<?> createDepartments(HttpServletRequest request,
			@RequestBody List<DepartmentVo> departmentVos) {
		return null;
	}
}
