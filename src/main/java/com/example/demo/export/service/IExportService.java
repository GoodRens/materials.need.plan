package com.example.demo.export.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.materials.vo.MaterialsPlanVO;

public interface IExportService {

	/**
	 * 导出物料需求
	 * 
	 * @return
	 */
	void exportMaterialsNeeds(HttpServletRequest request, HttpServletResponse response, MaterialsPlanVO materialsPan)
			throws Exception;
}
