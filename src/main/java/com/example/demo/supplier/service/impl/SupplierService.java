package com.example.demo.supplier.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.CommonService;
import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.supplier.dao.ISupplierDao;
import com.example.demo.supplier.service.ISupplierService;
import com.example.demo.supplier.vo.SupplierVO;
import com.mysql.cj.util.StringUtils;

@Service
public class SupplierService implements ISupplierService {

	@Autowired
	private ISupplierDao supplierDao;

	@Override
	public CommonResultVO<?> addOrUpdateSupplier(HttpServletRequest request, List<SupplierVO> supplierList) {
		CommonResultVO<SupplierVO> result = new CommonResultVO<SupplierVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		// 数据校验及重复校验
		for (int i = 0; i < supplierList.size(); i++) {
			if (StringUtils.isNullOrEmpty(supplierList.get(i).getSupplierName())) {
				supplierList.remove(i);
				continue;
			}
			List<SupplierVO> existSuppliers = supplierDao.QueryWl(supplierList.get(i));
			if (!existSuppliers.isEmpty()) {
				supplierList.remove(i);
			}
		}
		if (supplierList.isEmpty()) {
			result.setCode(400);
			result.setMsg("供应商已存在！");
			return result;
		}
		// 添加创建人
		CommonService.addCreateByToParamList(request, supplierList);
		List<SupplierVO> suppliers = supplierDao.AddOrUpdateSupplier(supplierList);
		result.setCode(200);
		result.setMsg("添加成功！");
		result.setResultList(suppliers);
		return result;
	}

	@Override
	public CommonResultVO<?> deleteSupplier(HttpServletRequest request, List<SupplierVO> supplierList) {
		CommonResultVO<SupplierVO> result = new CommonResultVO<SupplierVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		// 数据校验
		for (int i = 0; i < supplierList.size(); i++) {
			if (supplierList.get(i).getSupplierID() == 0) {
				supplierList.remove(i);
			}
		}
		// 是否为空
		if (supplierList.isEmpty()) {
			result.setCode(400);
			result.setMsg("数据格式不正确！");
			return result;
		}
		supplierDao.DeleteSupplier(supplierList);
		result.setCode(200);
		result.setMsg("删除成功！");
		return result;
	}

	@Override
	public CommonResultVO<?> queryWl(HttpServletRequest request, SupplierVO supplier) {
		CommonResultVO<SupplierVO> result = new CommonResultVO<SupplierVO>();
		// 权限校验
		String userId = UserRequestContext.getCurrentUser(request);
		if (StringUtils.isNullOrEmpty(userId)) {
			result.setCode(403);
			result.setMsg("您还未登录！");
			return result;
		}
		List<SupplierVO> suppliers = supplierDao.QueryWl(supplier);
		result.setCode(200);
		result.setMsg("查询成功！");
		result.setResultList(suppliers);
		return result;
	}

}
