package com.example.demo.export.util;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.common.statics.StaticVariables;

public class ExportUtils {

	/**
	 * 设置样式
	 * 
	 * @param xssfWorkbook
	 * @param sheet
	 */
	public static void setHeadCellStyle(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, int rowCount) {

		// 创建styleHead
		CellStyle styleHead = xssfWorkbook.createCellStyle();
		styleHead.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());// 背景色
		styleHead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleHead.setAlignment(HorizontalAlignment.CENTER);// 水平居中
		XSSFFont font = xssfWorkbook.createFont();
		font.setBold(true);// 加粗
		font.setFontHeight((short) 240);// 字体大小
		styleHead.setFont(font);
		// 创建style1
		CellStyle style1 = xssfWorkbook.createCellStyle();
		style1.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());// 背景色
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style1.setAlignment(HorizontalAlignment.CENTER);// 水平居中
		// 创建style2
		CellStyle style2 = xssfWorkbook.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());// 背景色
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setAlignment(HorizontalAlignment.CENTER);// 水平居中
		XSSFRow row = sheet.createRow(0);
		String[] headNames = StaticVariables.materialsNeedExportHeads;
		for (int i = 0; i < headNames.length; i++) {

			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(styleHead);
			cell.setCellValue(headNames[i]);
		}
		
	}

	public static void setOddCellStyle(XSSFWorkbook xssfWorkbook,XSSFCell cell) {
		// 创建style
		CellStyle style = xssfWorkbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());// 背景色
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setAlignment(HorizontalAlignment.CENTER);// 水平居中
		cell.setCellStyle(style);
	}
	public static void setEvenCellStyle(XSSFWorkbook xssfWorkbook,XSSFCell cell) {
		// 创建style
		CellStyle style = xssfWorkbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());// 背景色
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setAlignment(HorizontalAlignment.CENTER);// 水平居中
		cell.setCellStyle(style);
	}

	/**
	 * 设置列头
	 * 
	 * @param sheet
	 * @param headNames
	 */
	public static void setRowHead(XSSFSheet sheet, String[] headNames) {
		int length = headNames.length;
		XSSFRow head = sheet.createRow(0);
		for (int i = 0; i < length; i++) {
			XSSFCell cell = head.createCell(i);
			cell.setCellValue(headNames[i]);
		}
	}
}
