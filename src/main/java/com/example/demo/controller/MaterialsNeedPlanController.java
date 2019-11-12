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
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.department.vo.DepartmentVO;
import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.materials.service.IMaterialsNeedService;
import com.example.demo.materials.vo.MaterialsNeedVO;
import com.example.demo.relation.service.IDepartmentRoleRelationService;
import com.example.demo.relation.service.IDepartmentUserRelationService;
import com.example.demo.relation.service.IUserRoleRelationService;
import com.example.demo.relation.vo.DepartmentRoleRelationVO;
import com.example.demo.relation.vo.DepartmentUserRelationVO;
import com.example.demo.relation.vo.UserRoleRelationVO;
import com.example.demo.role.service.IRoleService;
import com.example.demo.role.vo.RoleVO;
import com.example.demo.supplier.service.ISupplierService;
import com.example.demo.supplier.vo.SupplierVO;
import com.example.demo.unit.service.IUnitService;
import com.example.demo.unit.vo.UnitVO;
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

	@Autowired
	private IUserRoleRelationService userRoleRelationService;

	@Autowired
	private IMaterialsNeedService materialsNeedService;

	@Autowired
	private IDepartmentRoleRelationService departmentRoleRelationService;

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IUnitService unitService;

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "用户登录校验", notes = "根据用户用户名检验")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CommonResultVO<?> getUser(HttpServletResponse response, @RequestBody UserInfoVO userInfo) {
		CommonResultVO<UserInfoVO> result = userInfoService.getUser(userInfo);
		if (result.getCode() == 200) {
			cookie = new Cookie("userId", result.getResultList().get(0).getId() + "");
			response.addCookie(cookie);
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}
		return result;
	}

	@ApiOperation(value = "用户注销", notes = "根据用户ID")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public CommonResultVO<?> logoutUser(HttpServletResponse response, HttpServletRequest request,
			@RequestBody UserInfoVO userInfo) {
		CommonResultVO<?> result = new CommonResultVO<UserInfoVO>();
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
	public CommonResultVO<?> insertUser(@RequestBody UserInfoVO userInfo) {
		return userInfoService.insertUser(userInfo);
	}

	@ApiOperation(value = "获取所有用户", notes = "获取所有用户")
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
	public CommonResultVO<?> getAllUsers(HttpServletRequest request) {
		return userInfoService.getAllUsers(request);
	}

	/******************** 华丽丽的分割线 ***************************/

	@ApiOperation(value = "获取部门", notes = "存在层级关系")
	@RequestMapping(value = "/getDepartments", method = RequestMethod.POST)
	public CommonResultVO<?> getDepartments(HttpServletRequest request, @RequestBody DepartmentVO departmentVo) {
		return departmentService.getDepartments(request, departmentVo);
	}

	@ApiOperation(value = "创建部门", notes = "部门名称，部门层级，父部门id必填（无时为0）")
	@RequestMapping(value = "/createDepartments", method = RequestMethod.POST)
	public CommonResultVO<?> createDepartments(HttpServletRequest request,
			@RequestBody List<DepartmentVO> departmentVos) {
		return departmentService.createDepartments(request, departmentVos);
	}

	@ApiOperation(value = "删除部门", notes = "部门id必填")
	@RequestMapping(value = "/deleteDepartments", method = RequestMethod.POST)
	public CommonResultVO<?> deleteDepartments(HttpServletRequest request, @RequestBody List<Integer> departmentIds) {
		return departmentService.deleteDepartments(request, departmentIds);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "新增部门用户关系", notes = "部门id、,用户id必填")
	@RequestMapping(value = "/createDepartmentUserRelations", method = RequestMethod.POST)
	public CommonResultVO<?> createDepartmentUserRelations(HttpServletRequest request,
			@RequestBody List<DepartmentUserRelationVO> departmentUserRelationList) {
		return departmentUserRelationService.createDepartmentUserRelations(request, departmentUserRelationList);
	}

	@ApiOperation(value = "删除部门用户关系", notes = "部门id、,用户id必填")
	@RequestMapping(value = "/deleteDepartmentUserRelations", method = RequestMethod.POST)
	public CommonResultVO<?> deleteDepartmentUserRelations(HttpServletRequest request,
			@RequestBody List<DepartmentUserRelationVO> departmentUserRelationList) {
		return departmentUserRelationService.deleteDepartmentUserRelations(request, departmentUserRelationList);
	}

	@ApiOperation(value = "查询角色部门", notes = "角色id必填")
	@RequestMapping(value = "/getDepartmentByUser", method = RequestMethod.POST)
	public CommonResultVO<?> getDepartmentByUser(HttpServletRequest request, @RequestBody UserInfoVO userInfo) {
		return departmentUserRelationService.getDepartmentByUser(request, userInfo);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "获取所有的角色", notes = "获取所有的角色")
	@RequestMapping(value = "/getAllRoles", method = RequestMethod.POST)
	public CommonResultVO<?> getAllRoles(HttpServletRequest request) {
		return roleService.getAllRoles(request);
	}

	@ApiOperation(value = "新增角色", notes = "角色名称必填")
	@RequestMapping(value = "/createRoles", method = RequestMethod.POST)
	public CommonResultVO<?> createRoles(HttpServletRequest request, @RequestBody List<RoleVO> roleList) {
		return roleService.createRoles(request, roleList);
	}

	@ApiOperation(value = "删除角色", notes = "角色id名称必填")
	@RequestMapping(value = "/deleteRoles", method = RequestMethod.POST)
	public CommonResultVO<?> deleteRoles(HttpServletRequest request, @RequestBody List<Integer> roleIds) {
		return roleService.deleteRoles(request, roleIds);
	}

	/******************** 华丽丽的分割线 ***************************/

	@ApiOperation(value = "批量新增用户的角色", notes = "批量新增用户的角色")
	@RequestMapping(value = "/createUserRoleRelations", method = RequestMethod.POST)
	public CommonResultVO<?> createUserRoleRelations(HttpServletRequest request,
			@RequestBody List<UserRoleRelationVO> userRoleRelationList) {
		return userRoleRelationService.createUserRoleRelations(request, userRoleRelationList);
	}

	@ApiOperation(value = "批量删除用户角色", notes = "批量删除用户角色")
	@RequestMapping(value = "/deleteUserRoleRelations", method = RequestMethod.POST)
	public CommonResultVO<?> deleteUserRoleRelations(HttpServletRequest request,
			@RequestBody List<UserRoleRelationVO> userRoleRelationList) {
		return userRoleRelationService.deleteUserRoleRelations(request, userRoleRelationList);
	}

	@ApiOperation(value = "查询用户的角色", notes = "获取所有的角色")
	@RequestMapping(value = "/getRolesByUser", method = RequestMethod.POST)
	public CommonResultVO<?> getRolesByUser(HttpServletRequest request, @RequestBody UserInfoVO userInfo) {
		return userRoleRelationService.getRolesByUser(request, userInfo);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "批量创建物料需求", notes = "批量创建物料需求")
	@RequestMapping(value = "/createMaterialNeeds", method = RequestMethod.POST)
	public CommonResultVO<?> createMaterialNeeds(HttpServletRequest request,
			@RequestBody List<MaterialsNeedVO> materialsNeedList) {
		return materialsNeedService.createMaterialNeeds(request, materialsNeedList);
	}

	@ApiOperation(value = "批量删除创建物料需求", notes = "id必传")
	@RequestMapping(value = "/deleteMaterialNeeds", method = RequestMethod.POST)
	public CommonResultVO<?> deleteMaterialNeeds(HttpServletRequest request,
			@RequestBody List<MaterialsNeedVO> materialsNeedList) {
		return materialsNeedService.deleteMaterialNeeds(request, materialsNeedList);
	}

	@ApiOperation(value = "批量更新物料需求", notes = "id必传")
	@RequestMapping(value = "/updateMaterialNeeds", method = RequestMethod.POST)
	public CommonResultVO<?> updateMaterialNeeds(HttpServletRequest request,
			@RequestBody List<MaterialsNeedVO> materialsNeedList) {
		return materialsNeedService.updateMaterialNeeds(request, materialsNeedList);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "批量创建部门角色", notes = "部门id、角色id必传")
	@RequestMapping(value = "/createDepartmentRoleRelations", method = RequestMethod.POST)
	public CommonResultVO<?> createDepartmentRoleRelations(HttpServletRequest request,
			@RequestBody List<DepartmentRoleRelationVO> departmentRoleRelationList) {
		return departmentRoleRelationService.createDepartmentRoleRelations(request, departmentRoleRelationList);
	}

	@ApiOperation(value = "批量删除部门角色", notes = "部门id、角色id必传")
	@RequestMapping(value = "/deleteDepartmentRoleRelations", method = RequestMethod.POST)
	public CommonResultVO<?> deleteDepartmentRoleRelations(HttpServletRequest request,
			@RequestBody List<DepartmentRoleRelationVO> departmentRoleRelationList) {
		return departmentRoleRelationService.deleteDepartmentRoleRelations(request, departmentRoleRelationList);
	}

	@ApiOperation(value = "获取部门下所有角色", notes = "部门id必传")
	@RequestMapping(value = "/getRoleByDepartmentId", method = RequestMethod.POST)
	public CommonResultVO<?> getRoleByDepartmentId(HttpServletRequest request, @RequestBody DepartmentVO department) {
		return departmentRoleRelationService.getRoleByDepartmentId(request, department);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "添加供应商", notes = "有id时更新，无时新建")
	@RequestMapping(value = "/AddOrUpdateSupplier", method = RequestMethod.POST)
	public CommonResultVO<?> AddOrUpdateSupplier(HttpServletRequest request,
			@RequestBody List<SupplierVO> supplierList) {
		return supplierService.AddOrUpdateSupplier(request, supplierList);
	}

	@ApiOperation(value = "删除供应商", notes = "id必传")
	@RequestMapping(value = "/DeleteSupplier", method = RequestMethod.POST)
	public CommonResultVO<?> DeleteSupplier(HttpServletRequest request, @RequestBody List<SupplierVO> supplierList) {
		return supplierService.DeleteSupplier(request, supplierList);
	}

	@ApiOperation(value = "查询供应商", notes = "name无时查询所有")
	@RequestMapping(value = "/QueryWl", method = RequestMethod.POST)
	public CommonResultVO<?> QueryWl(HttpServletRequest request, @RequestBody SupplierVO supplier) {
		return supplierService.QueryWl(request, supplier);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "添加物料单位", notes = "有id时更新，无时新建")
	@RequestMapping(value = "/AddOrUpdateunit", method = RequestMethod.POST)
	public CommonResultVO<?> AddOrUpdateunit(HttpServletRequest request, @RequestBody List<UnitVO> unitList) {
		return unitService.AddOrUpdateunit(request, unitList);
	}

	@ApiOperation(value = "删除物料单位", notes = "id必传")
	@RequestMapping(value = "/Deleteunit", method = RequestMethod.POST)
	public CommonResultVO<?> Deleteunit(HttpServletRequest request, @RequestBody List<UnitVO> unitList) {
		return unitService.Deleteunit(request, unitList);
	}

	@ApiOperation(value = "查询物料单位", notes = "无name时查询所有")
	@RequestMapping(value = "/Queryunit", method = RequestMethod.POST)
	public CommonResultVO<?> Queryunit(HttpServletRequest request, @RequestBody UnitVO unit) {
		return unitService.Queryunit(request, unit);
	}

}
