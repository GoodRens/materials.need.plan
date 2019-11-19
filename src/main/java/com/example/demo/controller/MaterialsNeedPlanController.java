package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.department.service.IDepartmentService;
import com.example.demo.department.vo.DepartmentVO;
import com.example.demo.export.service.IExportService;
import com.example.demo.login.service.IUserInfoService;
import com.example.demo.login.vo.UserInfoVO;
import com.example.demo.materials.category.service.IMaterialsCategoryService;
import com.example.demo.materials.category.vo.MaterialsCategoryVO;
import com.example.demo.materials.service.IMaterialsNeedService;
import com.example.demo.materials.service.IMaterialsPlanService;
import com.example.demo.materials.service.IMaterialsService;
import com.example.demo.materials.vo.MaterialsNeedVO;
import com.example.demo.materials.vo.MaterialsPlanVO;
import com.example.demo.materials.vo.MaterialsVO;
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

	@Autowired
	private IMaterialsPlanService materialsPlanService;

	@Autowired
	private IMaterialsCategoryService materialsCategoryService;

	@Autowired
	private IMaterialsService materialsService;

	@Autowired
	private IExportService exportService;

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "用户登录校验", notes = "根据用户用户名检验")
	@PostMapping(value = "/login")
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
	@PostMapping(value = "/logout")
	public CommonResultVO<?> logoutUser(HttpServletResponse response, HttpServletRequest request,
			@RequestBody UserInfoVO userInfo) {
		CommonResultVO<?> result = new CommonResultVO<UserInfoVO>();
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId) || !userId.equals(userInfo.getId() + "")) {
			result.setCode(400);
			result.setMsg(
					StringUtils.isNullOrEmpty(userInfo.getName()) ? "" : "[" + userInfo.getName() + "]" + "未登录，注销失败！");
			return result;
		}
		result.setCode(200);
		result.setMsg("注销成功！");
		cookie = new Cookie("userId", null);
		response.addCookie(cookie);
		return result;
	}

	@ApiOperation(value = "用户注册", notes = "用户名和密码必填")
	@PostMapping(value = "/register")
	public CommonResultVO<?> insertUser(@RequestBody UserInfoVO userInfo) {
		return userInfoService.insertUser(userInfo);
	}

	@ApiOperation(value = "获取所有用户", notes = "获取所有用户")
	@PostMapping(value = "/getAllUsers")
	public CommonResultVO<?> getAllUsers(HttpServletRequest request) {
		return userInfoService.getAllUsers(request);
	}

	/******************** 华丽丽的分割线 ***************************/

	@ApiOperation(value = "获取部门", notes = "存在层级关系")
	@PostMapping(value = "/getDepartments")
	public CommonResultVO<?> getDepartments(HttpServletRequest request, @RequestBody DepartmentVO departmentVo) {
		return departmentService.getDepartments(request, departmentVo);
	}

	@ApiOperation(value = "创建部门", notes = "部门名称，部门层级，父部门id必填（无时为0）")
	@PostMapping(value = "/createDepartments")
	public CommonResultVO<?> createDepartments(HttpServletRequest request,
			@RequestBody List<DepartmentVO> departmentVos) {
		return departmentService.createDepartments(request, departmentVos);
	}

	@ApiOperation(value = "删除部门", notes = "部门id必填")
	@PostMapping(value = "/deleteDepartments")
	public CommonResultVO<?> deleteDepartments(HttpServletRequest request, @RequestBody List<Integer> departmentIds) {
		return departmentService.deleteDepartments(request, departmentIds);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "新增部门用户关系", notes = "部门id、,用户id必填")
	@PostMapping(value = "/createDepartmentUserRelations")
	public CommonResultVO<?> createDepartmentUserRelations(HttpServletRequest request,
			@RequestBody List<DepartmentUserRelationVO> departmentUserRelationList) {
		return departmentUserRelationService.createDepartmentUserRelations(request, departmentUserRelationList);
	}

	@ApiOperation(value = "删除部门用户关系", notes = "部门id、,用户id必填")
	@PostMapping(value = "/deleteDepartmentUserRelations")
	public CommonResultVO<?> deleteDepartmentUserRelations(HttpServletRequest request,
			@RequestBody List<DepartmentUserRelationVO> departmentUserRelationList) {
		return departmentUserRelationService.deleteDepartmentUserRelations(request, departmentUserRelationList);
	}

	@ApiOperation(value = "查询角色部门", notes = "角色id必填")
	@PostMapping(value = "/getDepartmentByUser")
	public CommonResultVO<?> getDepartmentByUser(HttpServletRequest request, @RequestBody UserInfoVO userInfo) {
		return departmentUserRelationService.getDepartmentByUser(request, userInfo);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "获取所有的角色", notes = "获取所有的角色")
	@PostMapping(value = "/getAllRoles")
	public CommonResultVO<?> getAllRoles(HttpServletRequest request) {
		return roleService.getAllRoles(request);
	}

	@ApiOperation(value = "新增角色", notes = "角色名称必填")
	@PostMapping(value = "/createRoles")
	public CommonResultVO<?> createRoles(HttpServletRequest request, @RequestBody List<RoleVO> roleList) {
		return roleService.createRoles(request, roleList);
	}

	@ApiOperation(value = "删除角色", notes = "角色id名称必填")
	@PostMapping(value = "/deleteRoles")
	public CommonResultVO<?> deleteRoles(HttpServletRequest request, @RequestBody List<Integer> roleIds) {
		return roleService.deleteRoles(request, roleIds);
	}

	/******************** 华丽丽的分割线 ***************************/

	@ApiOperation(value = "批量新增用户的角色", notes = "批量新增用户的角色")
	@PostMapping(value = "/createUserRoleRelations")
	public CommonResultVO<?> createUserRoleRelations(HttpServletRequest request,
			@RequestBody List<UserRoleRelationVO> userRoleRelationList) {
		return userRoleRelationService.createUserRoleRelations(request, userRoleRelationList);
	}

	@ApiOperation(value = "批量删除用户角色", notes = "批量删除用户角色")
	@PostMapping(value = "/deleteUserRoleRelations")
	public CommonResultVO<?> deleteUserRoleRelations(HttpServletRequest request,
			@RequestBody List<UserRoleRelationVO> userRoleRelationList) {
		return userRoleRelationService.deleteUserRoleRelations(request, userRoleRelationList);
	}

	@ApiOperation(value = "查询用户的角色", notes = "获取所有的角色")
	@PostMapping(value = "/getRolesByUser")
	public CommonResultVO<?> getRolesByUser(HttpServletRequest request, @RequestBody UserInfoVO userInfo) {
		return userRoleRelationService.getRolesByUser(request, userInfo);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "批量创建物料需求", notes = "批量创建物料需求")
	@PostMapping(value = "/createMaterialNeeds")
	public CommonResultVO<?> createMaterialNeeds(HttpServletRequest request,
			@RequestBody List<MaterialsNeedVO> materialsNeedList) {
		return materialsNeedService.createMaterialNeeds(request, materialsNeedList);
	}

	@ApiOperation(value = "批量删除创建物料需求", notes = "id必传")
	@PostMapping(value = "/deleteMaterialNeeds")
	public CommonResultVO<?> deleteMaterialNeeds(HttpServletRequest request,
			@RequestBody List<MaterialsNeedVO> materialsNeedList) {
		return materialsNeedService.deleteMaterialNeeds(request, materialsNeedList);
	}

	@ApiOperation(value = "批量更新物料需求", notes = "id必传")
	@PostMapping(value = "/updateMaterialNeeds")
	public CommonResultVO<?> updateMaterialNeeds(HttpServletRequest request,
			@RequestBody List<MaterialsNeedVO> materialsNeedList) {
		return materialsNeedService.updateMaterialNeeds(request, materialsNeedList);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "批量创建部门角色", notes = "部门id、角色id必传")
	@PostMapping(value = "/createDepartmentRoleRelations")
	public CommonResultVO<?> createDepartmentRoleRelations(HttpServletRequest request,
			@RequestBody List<DepartmentRoleRelationVO> departmentRoleRelationList) {
		return departmentRoleRelationService.createDepartmentRoleRelations(request, departmentRoleRelationList);
	}

	@ApiOperation(value = "批量删除部门角色", notes = "部门id、角色id必传")
	@PostMapping(value = "/deleteDepartmentRoleRelations")
	public CommonResultVO<?> deleteDepartmentRoleRelations(HttpServletRequest request,
			@RequestBody List<DepartmentRoleRelationVO> departmentRoleRelationList) {
		return departmentRoleRelationService.deleteDepartmentRoleRelations(request, departmentRoleRelationList);
	}

	@ApiOperation(value = "获取部门下所有角色", notes = "部门id必传")
	@PostMapping(value = "/getRoleByDepartmentId")
	public CommonResultVO<?> getRoleByDepartmentId(HttpServletRequest request, @RequestBody DepartmentVO department) {
		return departmentRoleRelationService.getRoleByDepartmentId(request, department);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "添加供应商", notes = "有id时更新，无时新建")
	@PostMapping(value = "/AddOrUpdateSupplier")
	public CommonResultVO<?> addOrUpdateSupplier(HttpServletRequest request,
			@RequestBody List<SupplierVO> supplierList) {
		return supplierService.addOrUpdateSupplier(request, supplierList);
	}

	@ApiOperation(value = "删除供应商", notes = "id必传")
	@PostMapping(value = "/DeleteSupplier")
	public CommonResultVO<?> deleteSupplier(HttpServletRequest request, @RequestBody List<SupplierVO> supplierList) {
		return supplierService.deleteSupplier(request, supplierList);
	}

	@ApiOperation(value = "查询供应商", notes = "name无时查询所有")
	@PostMapping(value = "/QuerySupplier")
	public CommonResultVO<?> querySupplier(HttpServletRequest request, @RequestBody SupplierVO supplier) {
		return supplierService.querySupplier(request, supplier);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "添加物料单位", notes = "有id时更新，无时新建")
	@PostMapping(value = "/AddOrUpdateunit")
	public CommonResultVO<?> addOrUpdateunit(HttpServletRequest request, @RequestBody List<UnitVO> unitList) {
		return unitService.addOrUpdateunit(request, unitList);
	}

	@ApiOperation(value = "删除物料单位", notes = "id必传")
	@PostMapping(value = "/Deleteunit")
	public CommonResultVO<?> deleteunit(HttpServletRequest request, @RequestBody List<UnitVO> unitList) {
		return unitService.deleteunit(request, unitList);
	}

	@ApiOperation(value = "查询物料单位", notes = "无name时查询所有")
	@PostMapping(value = "/Queryunit")
	public CommonResultVO<?> queryunit(HttpServletRequest request, @RequestBody UnitVO unit) {
		return unitService.queryunit(request, unit);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "创建物料计划", notes = "创建物料计划")
	@PostMapping(value = "/AddNeedPlan")
	public CommonResultVO<?> addNeedPlan(HttpServletRequest request,
			@RequestBody List<MaterialsPlanVO> materialsNeedList) {
		return materialsPlanService.addNeedPlan(request, materialsNeedList);
	}

	@ApiOperation(value = "删除物料计划", notes = "id必传")
	@PostMapping(value = "/DeleteNeedPlan")
	public CommonResultVO<?> deleteNeedPlan(HttpServletRequest request,
			@RequestBody List<MaterialsPlanVO> materialsNeedList) {
		return materialsPlanService.deleteNeedPlan(request, materialsNeedList);
	}

	@ApiOperation(value = "创建物料计划", notes = "创建物料计划")
	@PostMapping(value = "/QueryNeedPlan")
	public CommonResultVO<?> queryNeedPlan(HttpServletRequest request, @RequestBody MaterialsPlanVO materialsNeed) {
		return materialsPlanService.queryNeedPlan(request, materialsNeed);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "创建物料分类", notes = "创建物料分类")
	@PostMapping(value = "/AddOrUpdateWlCategory")
	public CommonResultVO<?> addOrUpdateWlCategory(HttpServletRequest request,
			@RequestBody List<MaterialsCategoryVO> materialsCategoryList) {
		return materialsCategoryService.addOrUpdateWlCategory(request, materialsCategoryList);
	}

	@ApiOperation(value = "删除物料分类", notes = "id必传")
	@PostMapping(value = "/DeleteWlCategory")
	public CommonResultVO<?> deleteWlCategory(HttpServletRequest request,
			@RequestBody List<MaterialsCategoryVO> materialsCategoryList) {
		return materialsCategoryService.deleteWlCategory(request, materialsCategoryList);
	}

	@ApiOperation(value = "查询物料分类", notes = "无名称时查所有")
	@PostMapping(value = "/QueryWlCategory")
	public CommonResultVO<?> queryWlCategory(HttpServletRequest request,
			@RequestBody MaterialsCategoryVO materialsCategory) {
		return materialsCategoryService.queryWlCategory(request, materialsCategory);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "添加物料", notes = "添加物料")
	@PostMapping(value = "/AddOrUpdateWl")
	public CommonResultVO<?> addOrUpdateWl(HttpServletRequest request, @RequestBody List<MaterialsVO> materialsList) {
		return materialsService.addOrUpdateWl(request, materialsList);
	}

	@ApiOperation(value = "删除物料", notes = "id必传")
	@PostMapping(value = "/DeleteWl")
	public CommonResultVO<?> deleteWl(HttpServletRequest request, @RequestBody List<MaterialsVO> materialsList) {
		return materialsService.deleteWl(request, materialsList);
	}

	@ApiOperation(value = "查询物料", notes = "无查所有")
	@PostMapping(value = "/QueryWl")
	public CommonResultVO<?> queryWl(HttpServletRequest request, @RequestBody MaterialsVO materials) {
		return materialsService.queryWl(request, materials);
	}

	/******************** 华丽丽的分割线 ***************************/
	@ApiOperation(value = "导出物料需求", notes = "导出物料需求")
	@PostMapping(value = "/exportMaterialsNeeds")
	public void exportMaterialsNeeds(HttpServletRequest request, HttpServletResponse response,
			@PathParam("materialsPan") MaterialsPlanVO materialsPan) throws Exception {
		exportService.exportMaterialsNeeds(request, response, materialsPan);
	}

	/******************** 华丽丽的分割线 ***************************/
}
