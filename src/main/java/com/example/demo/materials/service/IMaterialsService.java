package com.example.demo.materials.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.vo.MaterialsVO;

public interface IMaterialsService {

	/**
	 * 批量创建物料
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> addOrUpdateWl(HttpServletRequest request, List<MaterialsVO> materialsList);

	/**
	 * 批量删除物料
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> deleteWl(HttpServletRequest request, List<MaterialsVO> materialsList);

	/**
	 * 查询物料
	 * 
	 * @param request
	 * @param materialsNeedList
	 * @return
	 */
	CommonResultVO<?> queryWl(HttpServletRequest request, MaterialsVO materials);
}
