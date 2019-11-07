package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.department.vo.DepartmentVo;
import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.relation.service.IDepartmentUserRelationService;
import com.example.demo.relation.vo.DepartmentUserRelationVO;
import com.example.demo.role.service.IRoleService;
import com.example.demo.role.vo.RoleVO;
import com.mysql.cj.util.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Materials Need Plan Controller")
@RequestMapping("/")
@CrossOrigin
public class MaterialsNeedPlanController {

	// cookie变量用来装我们的cookies信息
	private static Cookie cookie;

	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IDepartmentUserRelationService departmentUserRelationService;
	@Autowired
	private IRoleService roleService;

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "用户登录校验", notes = "根据用户用户名检验")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CommonResultVo<?> getUser(HttpServletResponse response, @RequestBody UserInfoVO userInfo) {
		CommonResultVo<UserInfoVO> result = userInfoService.getUser(userInfo);
		if (result.getCode() == 200) {
			cookie = new Cookie("userId", result.getResultList().get(0).getId() + "");
			response.addCookie(cookie);
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}
		return result;
	}

	@ApiOperation(value = "用户注销", notes = "根据用户ID")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public CommonResultVo<?> logoutUser(HttpServletResponse response, HttpServletRequest request,
			@RequestBody UserInfoVO userInfo) {
		CommonResultVo<?> result = new CommonResultVo<UserInfoVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId) || !userId.equals(userInfo.getId() + "")) {
			result.setCode(400);
			result.setMsg(
					StringUtils.isNullOrEmpty(userInfo.getName()) ? "" : "[s" + userInfo.getName() + "]" + "未登录，注销失败！");
			return result;
		}
		result.setCode(200);
		result.setMsg("注销成功！");
		cookie = new Cookie("userId", null);
		response.addCookie(cookie);
		return result;
	}

	@ApiOperation(value = "用户注册", notes = "用户名和密码必填")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public CommonResultVo<?> insertUser(@RequestBody UserInfoVO userInfo) {
		return userInfoService.insertUser(userInfo);
	}

	@ApiOperation(value = "获取所有用户", notes = "获取所有用户")
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
	public CommonResultVo<?> getAllUsers(HttpServletRequest request) {
		return userInfoService.getAllUsers(request);
	}

	/******************** 华丽丽的分割线 ***************************/

	@ApiOperation(value = "获取部门", notes = "存在层级关系")
	@RequestMapping(value = "/getDepartments", method = RequestMethod.POST)
	public CommonResultVo<?> getDepartments(HttpServletRequest request, @RequestBody DepartmentVo departmentVo) {
		return departmentService.getDepartments(request, departmentVo);
	}

	@ApiOperation(value = "创建部门", notes = "部门名称，部门层级，父部门id必填（无时为0）")
	@RequestMapping(value = "/createDepartments", method = RequestMethod.POST)
	public CommonResultVo<?> createDepartments(HttpServletRequest request,
			@RequestBody List<DepartmentVo> departmentVos) {
		return departmentService.createDepartments(request, departmentVos);
	}

	@ApiOperation(value = "删除部门", notes = "部门id必填")
	@RequestMapping(value = "/deleteDepartments", method = RequestMethod.POST)
	public CommonResultVo<?> deleteDepartments(HttpServletRequest request, @RequestBody List<Integer> departmentIds) {
		return departmentService.deleteDepartments(request, departmentIds);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "新增部门用户关系", notes = "部门id、,用户id必填")
	@RequestMapping(value = "/createDepartmentUserRelations", method = RequestMethod.POST)
	public CommonResultVo<?> createDepartmentUserRelations(HttpServletRequest request,
			@RequestBody List<DepartmentUserRelationVO> departmentUserRelationList) {
		return departmentUserRelationService.createDepartmentUserRelations(request, departmentUserRelationList);
	}

	@ApiOperation(value = "删除部门用户关系", notes = "部门id、,用户id必填")
	@RequestMapping(value = "/deleteDepartmentUserRelations", method = RequestMethod.POST)
	public CommonResultVo<?> deleteDepartmentUserRelations(HttpServletRequest request,
			@RequestBody List<DepartmentUserRelationVO> departmentUserRelationList) {
		return departmentUserRelationService.deleteDepartmentUserRelations(request, departmentUserRelationList);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "获取所有的角色", notes = "获取所有的角色")
	@RequestMapping(value = "/getAllRoles", method = RequestMethod.POST)
	public CommonResultVo<?> getAllRoles(HttpServletRequest request) {
		return roleService.getAllRoles(request);
	}

	@ApiOperation(value = "新增角色", notes = "角色名称必填")
	@RequestMapping(value = "/createRoles", method = RequestMethod.POST)
	public CommonResultVo<?> createRoles(HttpServletRequest request, @RequestBody List<RoleVO> roleList) {
		return roleService.createRoles(request, roleList);
	}

	@ApiOperation(value = "删除角色", notes = "角色id名称必填")
	@RequestMapping(value = "/deleteRoles", method = RequestMethod.POST)
	public CommonResultVo<?> deleteRoles(HttpServletRequest request, @RequestBody List<Integer> roleIds) {
		return roleService.deleteRoles(request, roleIds);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "查询角色部门", notes = "角色id必填")
	@RequestMapping(value = "/getDepartmentByUser", method = RequestMethod.POST)
	public CommonResultVo<?> getDepartmentByUser(HttpServletRequest request, @RequestBody UserInfoVO userInfo) {
		return departmentService.getDepartmentByUser(request, userInfo);
	}
	/******************** 华丽丽的分割线 ***************************/
	/******************** 华丽丽的分割线 ***************************/
	/******************** 华丽丽的分割线 ***************************/
	/******************** 华丽丽的分割线 ***************************/
}
