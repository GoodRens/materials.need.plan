package com.example.demo.materials.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.example.demo.common.vo.CommonResultVo;
import com.example.demo.materials.service.IMaterialsNeedService;
import com.example.demo.materials.vo.MaterialsNeedVO;

@Service
public class MaterialsNeedService implements IMaterialsNeedService {

	@Override
	public CommonResultVo<?> createMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResultVo<?> deleteMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResultVo<?> updateMaterialNeeds(HttpServletRequest request, List<MaterialsNeedVO> materialsNeedList) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
