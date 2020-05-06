package com.zifeng.pas.util.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.plaf.synth.Region;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by dell on 2018/5/3.
 */
public class CreateExcel {
	public static void main(String args[]) {
		CreateExcel createExcel = new CreateExcel();
		String path = "D:\test.xlsx";// 路径可随意替换
		try {
			// 随意创建一个Excel
			createExcel.createExcel(path);
			// 读取上一行创建的Excel
			createExcel.getExcel(path);
			System.out.println("----------我是分割线----------");
			// 创建Excel的表头
			createExcel.createExcelTop(path);
			// 读取上一行创建的Excel
			createExcel.getExcel(path);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 创建Excel文件
	public void createExcel(String path) throws Exception {
		// 创建Excel文件对象
		HSSFWorkbook wb = new HSSFWorkbook();
		// 用文件对象创建sheet对象  
		HSSFSheet sheet = wb.createSheet("第一个sheet页");
		// 用sheet对象创建行对象  
		HSSFRow row = sheet.createRow(0);
		// 创建单元格样式     
		CellStyle cellStyle = wb.createCellStyle();
		// 用行对象创建单元格对象Cell 
		Cell cell = row.createCell(0);
		// 用cell对象读写。设置Excel工作表的值
		cell.setCellValue(1);
		// 输出Excel文件
		FileOutputStream output = new FileOutputStream(path);
		wb.write(output);
		output.flush();
	}

	// 读取Excel文件的值
	public void getExcel(String path) throws Exception {

		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(path));
		// 得到Excel工作簿对象    
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		// 得到sheet页个数（从1开始数,但是取值的时候要从index=0开始）
		int scount = wb.getNumberOfSheets();
		System.out.println("sheet页的个数为：" + (scount));
		for (int a = 0; a < scount; a++) {
			String sheetName = wb.getSheetName(a);
			System.out.println("第" + (a + 1) + "个sheet页的名字为" + sheetName + ",内容如下：");
			// 得到Excel工作表对象(0代表第一个sheet页)    
			HSSFSheet sheet = wb.getSheetAt(a);
			HSSFSheet sheet1 = wb.getSheet("第一个sheet页");
			// 预定义单元格的值
			String c = "";
			// 得到工作表的有效行数(行数从0开始数，取值时从index=0开始)
			int rcount = sheet.getLastRowNum();
			System.out.println("第" + (a + 1) + "个sheet页有" + rcount + "行");
			for (int i = 0; i <= rcount; i++) {
				// 得到Excel工作表的行    
				HSSFRow row = sheet.getRow(i);
				if (null != row) {
					// 获取一行（row）的有效单元格（cell）个数(列数从1开始数，取值的时候从index=0开始取)
					int ccount = row.getLastCellNum();
					System.out.println("第" + (i + 1) + "行有" + ccount + "个单元格");
					for (int j = 0; j < ccount; j++) {
						// 得到Excel工作表指定行的单元格    
						HSSFCell cell = row.getCell(j);
						if (null != cell) {
							// 得到单元格类型
							CellType cellType = cell.getCellType();
							switch (cellType) {
							// 字符串类型  
							case NUMERIC:
								c = cell.getStringCellValue();
								if (c.trim().equals("") || c.trim().length() <= 0)
									c = " ";
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								c = String.valueOf(cell.getNumericCellValue());
							default:
								break;
							}
							// String c = cell.getStringCellValue();
							System.out.print("第" + (i + 1) + "行" + (j + 1) + "列的值为：" + c + "    ");
						} else {
							System.out.print("第" + (i + 1) + "行" + (j + 1) + "列的值为：空" + "    ");
						}
					}
					System.out.println();
				} else {
					System.out.println("第" + (i + 1) + "行的值为：空");
				}
			}
		}
	}

	// 创建excel的表头,设置字体及字体颜色，设置单元格填充色
	public void createExcelTop(String path) throws Exception {
		// 创建Excel对象
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		// Excel样式
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		// 垂直居中
		//style.setAlignment(HSSFCellStyle.VERTICAL_CENTER); 旧版写法
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		// 左右居中
		//style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 旧版写法
		style.setAlignment(HorizontalAlignment.CENTER);
		// Excel字体设置
		HSSFFont hssfFont = hssfWorkbook.createFont();
		hssfFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		hssfFont.setColor(HSSFColor.RED.index);
		style.setFont(hssfFont);
		// 创建sheet对象
		Sheet sheet = hssfWorkbook.createSheet();
		// 创建row
		Row row = sheet.createRow(1);
		// 创建cell
		Cell cell = row.createCell(0);
		// 设置cell的值
		cell.setCellValue("姓名");
		row.createCell(1).setCellValue("年龄");
		row.createCell(2).setCellValue("入学日期");
		row.createCell(3).setCellValue("分数");

		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中 
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		 // 背景色
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
		style.setFillBackgroundColor(HSSFColor.GREEN.index); 
		// 设置边框
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		// 自动换行  
		style.setWrapText(true);  
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setColor(HSSFColor.RED.index);
		//字体加粗
		//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  旧式写法
		font.setBold(true);  //新版写法
		font.setFontName("宋体");
		// 把字体 应用到当前样式
		style.setFont(font);
		//style设置好后，为cell设置样式
		cell.setCellStyle(style)//cell为已有的单元格
		// Excel设置单元格填充色
		HSSFCellStyle style2 = hssfWorkbook.createCellStyle();
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 设置前景填充样式
		style2.setFillForegroundColor(HSSFColor.RED.index);// 前景填充色

		for (int i = 2; i < 4; i++) {
			Row row2 = sheet.createRow(i);
			row2.createCell(0).setCellValue("李明");
			Cell cell2 = row2.createCell(1);
			cell2.setCellValue("21");
			cell2.setCellStyle(style2);
			row2.createCell(2).setCellValue("2017年01月01日");
			row2.createCell(3).setCellValue(78);
		}
		// 设置标题，以及设置单元格的样式，有些样式只对单元格有效
		Row row5 = sheet.createRow(0);
		Cell cell1 = row5.createCell(0);
		cell1.setCellValue("学生成绩表");
		cell1.setCellStyle(style);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// row5.createCell(3).setCellValue();

		// 合并日期占两行(4个参数，分别为起始行，结束行，起始列，结束列)
        // 行和列都是从0开始计数，且起始结束都会合并
        // 这里是合并excel中日期的两行为一行
        CellRangeAddress region = new CellRangeAddress(1, 2, 0, 0);
        sheet.addMergedRegion(region);

		// 输出Excel对象
		FileOutputStream output = new FileOutputStream(path);
		hssfWorkbook.write(output);
		output.flush();
	}

}