package com.mcggdd.pas.util;

// http://poi.apache.org/components/spreadsheet/quick-guide.html
//1、HSSF支持.xls为后缀的二进制格式，并提供了流解析模式的HSSFListener相关API以及基于内存模型的HSSFWorkbook相关API。
//2、XSSF支持.xlsx为后缀的OpenXML格式。因为是底层文件是XML所以可以使用SAX解析，POI提供了XSSFReader用来获取压缩包中的各个XML文件相应的输入流；另外提供了基于DOM解析模式的XSSFWorkbook相关API。
//https://www.cnblogs.com/aeolian/p/10340664.html

public class ReadExcel {
	// 使用XSSFWorkbook读取.xlsx文件的例子
	// 打开指定位置的Excel文件
	FileInputStream file = new FileInputStream(new File(fileLocation));
	Workbook workbook = new XSSFWorkbook(file);
	// 打开Excel中的第一个Sheet
	Sheet sheet = workbook.getSheetAt(0);

	// 读取Sheet中的数据
	Map<Integer, List<String>> data = new HashMap<>();
	int i = 0;for(
	Row row:sheet)
	{ // 行
	    data.put(i, new ArrayList<String>());
	    for (Cell cell : row) { // 单元格
	        switch (cell.getCellType()) { // 不同的数据类型
	            case STRING: ... break; // 字符串类型
	            case NUMERIC: ... break; // 数值类型
	            case BOOLEAN: ... break; // 布尔类型
	            case FORMULA: ... break; // 公式类型
	            case BLANK: ... break; // 空白类型
	        }
	    }
	    i++;
	}

	// POI有不同的方法来读取每种类型的数据
	switch(cell.getCellType())
	{
    case CellType.STRING:
        data.get(i).add(cell.getRichStringCellValue().getString());
        break;
    case CellType.NUMERIC:
        if(DateUtil.isCellDateFormatted(cell)) {
            data.get(i).add(cell.getDateCellValue));
        } else {
            data.get(i).add(cell.getNumericCellValue());
        }
        break;
    case CellType.BOOLEAN:
        data.get(i).add(cell.getBooleanCellValue());
        break;
    case CellType.FORMULA:
        data.get(i).add(cell.getCellFormula());
        break;
    case CellType.BLANK:
        data.get(i).add("")
        break;
	}
	
//	Workbook API也支持Excel的写入：
	Workbook workbook = new XSSFWorkbook(); // 创建工作簿

	Sheet sheet = workbook.createSheet("Persons"); // 创建Sheet
	sheet.setColumnWidth(1, 4000);

	Row header = sheet.createRow(0); // 创建表头行

	CellStyle headerStyle = workbook.createCellStyle(); // 表头单元格样式
	headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
	headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	XSSFFont font = ((XSSFWorkbook) workbook).createFont(); // 字体样式
	font.setFontName("Arial");
	font.setFontHeightInPoints((short) 16);
	font.setBold(true);
	headerStyle.setFont(font);

	Cell headerCell = header.createCell(0); // 创建表头单元格
	headerCell.setCellValue("Name");
	headerCell.setCellStyle(headerStyle);

	headerCell = header.createCell(1); // 创建表头单元格
	headerCell.setCellValue("Age");
	headerCell.setCellStyle(headerStyle);

	CellStyle style = workbook.createCellStyle(); // 普通单元格样式
	style.setWrapText(true);

	Row row = sheet.createRow(2); // 写入单元格
	Cell cell = row.createCell(0);
	cell.setCellValue("John Smith");
	cell.setCellStyle(style);

	cell = row.createCell(1); // 写入单元格
	cell.setCellValue(20);
	cell.setCellStyle(style);

	// 最后写出到文件
	FileOutputStream outputStream = Files.newOutputStream("/path/to/excel");
	workbook.write(outputStream);
	workbook.close();

}
