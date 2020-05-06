package com.zifeng.pas.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zifeng.pas.exception.CustomException;

/*
 * HSSF提供读写Microsoft Excel XLS格式档案的功能。
 * XSSF提供读写Microsoft Excel OOXML XLSX格式档案的功能。
 * HWPF提供读写Microsoft Word DOC格式档案的功能。
 * HSLF提供读写Microsoft PowerPoint格式档案的功能。
 * HDGF提供读Microsoft Visio格式档案的功能。
 * HPBF提供读Microsoft Publisher格式档案的功能。
 * HSMF提供读Microsoft Outlook格式档案的功能。
 */
public class ExcelUtils {

	public String createExcel(String fileName) throws IOException {
		String[] fileNameSplit = fileName.split(".");
		String excelType = fileNameSplit[fileNameSplit.length - 1];

		if (excelType.equals(Constants.EXCEL_XLS)) {
			HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件(Workbook)
			HSSFSheet sheet = workbook.createSheet();// 创建工作表(Sheet)
			sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
			HSSFRow row = sheet.createRow(0);// 创建行,从0开始
			HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
			cell.setCellValue("zifeng");// 设置单元格内容
			row.createCell(1).setCellValue(false);// 设置单元格内容,重载
			row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
			row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
			FileOutputStream out = new FileOutputStream(fileName);
			workbook.write(out);// 保存Excel文件
			out.close();// 关闭文件流
			workbook.close();
			System.out.println("OK!");
		} else if (excelType.equals(Constants.EXCEL_XLSX)) {
			XSSFWorkbook workbook = new XSSFWorkbook();// 创建Excel文件(Workbook)
			XSSFSheet sheet = workbook.createSheet();// 创建工作表(Sheet)
			sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
			XSSFRow row = sheet.createRow(0);// 创建行,从0开始
			XSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
			cell.setCellValue("zifeng");// 设置单元格内容
			row.createCell(1).setCellValue(false);// 设置单元格内容,重载
			row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
			row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
			FileOutputStream out = new FileOutputStream(fileName);
			workbook.write(out);// 保存Excel文件
			out.close();// 关闭文件流
			workbook.close();
			System.out.println("OK!");
		} else {
			throw new CustomException(300, "输入文件名对应Excel类型无效");
		}

		return null;
	}
}
