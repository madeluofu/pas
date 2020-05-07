package com.mcggdd.pas.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

//使用EventAPI读取Excel
//HSSFWorkbook和XSSFWorkbook需要将Excel内容全部读取到内存才能操作，对于二进制Excel大文件的读取必须使用HSSFListener。
//不过03版二进制Excel能支持的最大行数为65536
public class HSSFListenerExample implements HSSFListener {
	private SSTRecord sstrec;

	// 实现接口方法
	public void processRecord1(Record record) {
		switch (record.getSid()) {
		case BOFRecord.sid: // Beginning Of File
			BOFRecord bof = (BOFRecord) record;
			if (bof.getType() == bof.TYPE_WORKBOOK) {
				System.out.println("Encountered workbook");
			} else if (bof.getType() == bof.TYPE_WORKSHEET) {
				System.out.println("Encountered sheet reference");
			}
			break;
		case BoundSheetRecord.sid:
			BoundSheetRecord bsr = (BoundSheetRecord) record;
			System.out.println("New sheet named:" + bsr.getSheetname());
			break;
		case RowRecord.sid: // 行
			RowRecord rowrec = (RowRecord) record;
			System.out.println("first column:" + rowrec.getFirstCol() + "," + "last column:" + rowrec.getLastCol());
			break;
		case NumberRecord.sid: // 数字单元格
			NumberRecord numrec = (NumberRecord) record;
			System.out.println("Row:" + numrec.getRow() + "," + "Column:" + numrec.getColumn() + "," + "Number value:"
					+ numrec.getValue());
			break;
		case SSTRecord.sid: // Static String Table Record
			sstrec = (SSTRecord) record;
			System.out.println("String table value:");
			for (int k = 0; k < sstrec.getNumUniqueStrings(); k++) {
				System.out.println(k + " = " + sstrec.getString(k));
			}
			break;
		case LabelSSTRecord.sid:
			LabelSSTRecord lrec = (LabelSSTRecord) record;
			System.out.println("String cell value:" + sstrec.getString(lrec.getSSTIndex()));
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("/path/to/file");
		POIFSFileSystem poifs = new POIFSFileSystem(fin);
		InputStream din = poifs.createDocumentInputStream("Workbook");
		// 构造 HSSFRequest 对象
		HSSFRequest req = new HSSFRequest();
		// 监听所有的Record
		req.addListenerForAllRecords(new HSSFListenerExample());
		// 创建EventFactory
		HSSFEventFactory factory = new HSSFEventFactory();
		// 将输入流交给EventFactory解析生成事件
		factory.processEvents(req, din);
		// 事件处理完后关闭输入流
		fin.close();
		din.close();
		System.out.println("done.");
	}

	@Override
	public void processRecord(Record record) {
		// TODO Auto-generated method stub

	}
}
