package com.example.demo.export.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.materials.vo.MaterialsNeedVO;
import com.example.demo.materials.vo.MaterialsPlanVO;
import com.example.demo.materials.vo.MaterialsVO;

public interface IExportService {

	/**
	 * 导出物料需求
	 * 
	 * @return
	 */
	void exportMaterialsNeeds(HttpServletRequest request, HttpServletResponse response, MaterialsPlanVO materialsPan)
			throws Exception;
}
