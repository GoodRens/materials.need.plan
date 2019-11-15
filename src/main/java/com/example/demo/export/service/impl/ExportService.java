package com.example.demo.export.service.impl;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.service.UserRequestContext;
import com.example.demo.common.statics.StaticVariables;
import com.example.demo.common.vo.CommonResultVO;
import com.example.demo.export.service.IExportService;
import com.example.demo.export.util.ExportUtils;
import com.example.demo.materials.dao.IMaterialsNeedDao;
import com.example.demo.materials.dao.IMaterialsPlanDao;
import com.example.demo.materials.vo.MaterialsNeedVO;
import com.example.demo.materials.vo.MaterialsPlanVO;
import com.example.demo.materials.vo.MaterialsVO;
import com.example.demo.supplier.vo.SupplierVO;
import com.mysql.cj.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExportService implements IExportService {

	@Autowired
	private IMaterialsPlanDao materialsPlanDao;

	@Override
	public void exportMaterialsNeeds(HttpServletRequest request, HttpServletResponse response,
			MaterialsPlanVO materialsPlan) throws Exception {
		// 设置默认的下载文件名
		String name = "物料需求详细信息.xlsx";
		// 避免文件名中文乱码，将UTF8打散重组成ISO-8859-1编码方式
		name = new String(name.getBytes("UTF8"), "ISO-8859-1");
		// 创建工作簿
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建工作表
		XSSFSheet sheet = xssfWorkbook.createSheet();
		// 设置sheet页面名称
		xssfWorkbook.setSheetName(0, "物料需求详细信息");
		// 数据源
		List<MaterialsPlanVO> list = materialsPlanDao.queryNeedPlan(materialsPlan);
		// 设置表格样式
		ExportUtils.setHeadCellStyle(xssfWorkbook, sheet, list.size());
		for (int i = 1; i <= list.size(); i++) {
			// 创建行,从第二行开始，所以for循环的i从1开始取
			MaterialsPlanVO materials = list.get(i - 1);
			// 创建单元格，并填充数据
			XSSFRow row = sheet.createRow(i);
			// 区分奇偶列设置背景颜色
			if (i % 2 == 0) {
				XSSFCell cell = row.createCell(0);
				cell.setCellValue(materials.getWlCategoryID());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(1);
				cell.setCellValue(materials.getWlCategoryName());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(2);
				cell.setCellValue(materials.getPlanCode());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(3);
				cell.setCellValue(materials.getPlanNmae());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(4);
				cell.setCellValue(materials.getSpecs());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(5);
				cell.setCellValue(materials.getModel());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(6);
				cell.setCellValue(materials.getUnitName());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(7);
				cell.setCellValue(materials.getNumber());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(8);
				cell.setCellValue(materials.getPlanMonth());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(9);
				cell.setCellValue(materials.getPlanDate());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(10);
				cell.setCellValue(materials.getIsSupplierFixed());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(11);
				cell.setCellValue(materials.getWishSupplierName());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(12);
				cell.setCellValue(materials.getFixedSupplierName());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
				cell = row.createCell(13);
				cell.setCellValue(materials.getPlanMemo());
				ExportUtils.setEvenCellStyle(xssfWorkbook, cell);
			} else {
				XSSFCell cell = row.createCell(0);
				cell.setCellValue(materials.getWlCategoryID());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(1);
				cell.setCellValue(materials.getWlCategoryName());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(2);
				cell.setCellValue(materials.getPlanCode());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(3);
				cell.setCellValue(materials.getPlanNmae());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(4);
				cell.setCellValue(materials.getSpecs());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(5);
				cell.setCellValue(materials.getModel());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(6);
				cell.setCellValue(materials.getUnitName());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(7);
				cell.setCellValue(materials.getNumber());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(8);
				cell.setCellValue(materials.getPlanMonth());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(9);
				cell.setCellValue(materials.getPlanDate());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(10);
				cell.setCellValue(materials.getIsSupplierFixed());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(11);
				cell.setCellValue(materials.getWishSupplierName());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(12);
				cell.setCellValue(materials.getFixedSupplierName());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
				cell = row.createCell(13);
				cell.setCellValue(materials.getPlanMemo());
				ExportUtils.setOddCellStyle(xssfWorkbook, cell);
			}
		}
		// 设置响应头的类型
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		// 让浏览器下载文件,name是上述默认文件下载名
		response.addHeader("Content-Disposition", "attachment;filename=\"" + name + "\"");
		OutputStream outputStream = response.getOutputStream();
		xssfWorkbook.write(outputStream);
		xssfWorkbook.close();
		outputStream.close();
	}

}