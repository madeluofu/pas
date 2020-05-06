package com.zifeng.pas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zifeng.pas.entity.PasAppraise;
import com.zifeng.pas.entity.PasCell;
import com.zifeng.pas.entity.PasPara;
import com.zifeng.pas.entity.PasSheet;
import com.zifeng.pas.entity.PasSheetInstr;
import com.zifeng.pas.exception.CustomException;
import com.zifeng.pas.exception.Result;
import com.zifeng.pas.service.GenReportService;
import com.zifeng.pas.service.PasAppraiseService;
import com.zifeng.pas.service.PasCellService;
import com.zifeng.pas.service.PasSheetInstrService;
import com.zifeng.pas.service.PasSheetService;
import com.zifeng.pas.util.ThreadUtils;

@Service("GenExcelService")
public class GenReportServiceImpl implements GenReportService {
	@Autowired
	private PasAppraiseService pasAppraiseService;
	@Autowired
	private PasSheetService pasSheetService;
	@Autowired
	private PasSheetInstrService pasSheetInstrService;
	@Autowired
	private PasCellService pasCellService;

	@Override
	public Result<String> genReport(String appraiseTpNo, String circle) {
		PasPara pasPara = (PasPara) ThreadUtils.getHolder("para");
		String readDirect = pasPara.getReadDirect();
		String writeDirect = pasPara.getWriteDirect();
		String genFileTp = pasPara.getGenFileTp();
		System.out.println(
				"readDirect = " + readDirect + ", writeDirect = " + writeDirect + ", genFileTp = " + genFileTp);

		PasAppraise pasAppraise = pasAppraiseService.getOneByKey(appraiseTpNo);
		String fileName = pasAppraise.getFileName();
		String fileNameTp = pasAppraise.getFileNameTp();
		String fullFileName = null;
		if (fileNameTp.equals("1")) {
			fullFileName = writeDirect + fileName + pasAppraise.getAppraiseCycTp() + "." + genFileTp;
		} else {
			fullFileName = writeDirect + fileName + "." + genFileTp;
		}
		System.out.println("fullFileName = " + fullFileName);

		List<PasSheet> pasSheetList = pasSheetService.listByAppraiseTpNo(appraiseTpNo);
		for (int i = 0; i < pasSheetList.size(); i++) {
			PasSheet pasSheet = pasSheetList.get(i);
			String sheetNo = pasSheet.getSheetNo();
			System.out.println(pasSheet.toString());

			/* 页头说明项 */
			List<PasSheetInstr> pasSheetInstrList = pasSheetInstrService.listHeadBySheetNo(sheetNo);
			if (pasSheetInstrList == null || pasSheetInstrList.size() == 0) {
				continue;
			}
			for (int j = 0; j < pasSheetInstrList.size(); j++) {
				PasSheetInstr pasSheetInstr = pasSheetInstrList.get(j);
				System.out.println(pasSheetInstr.toString());
			}

			/* 页显示表头 */
			List<PasCell> pasCellList = pasCellService.listBySheetNo(pasSheet.getSheetNo());
			if (pasCellList != null && pasCellList.size() > 0) {
				for (int j = 0; j < pasCellList.size(); j++) {
					PasCell pasCell = pasCellList.get(j);
					String showBeg = pasCell.getShowBeg();
					String showEnd = pasCell.getShowEnd();
					String showContent = pasCell.getShowContent();

					System.out.println(pasCell.toString());
				}
			}

			/* 页显示数据 */

			/* 页尾说明项 */
			pasSheetInstrList = pasSheetInstrService.listTailBySheetNo(pasSheet.getSheetNo());
			if (pasSheetInstrList == null || pasSheetInstrList.size() == 0) {
				continue;
			}
			for (int j = 0; j < pasSheetInstrList.size(); j++) {
				PasSheetInstr pasSheetInstr = pasSheetInstrList.get(j);
				System.out.println(pasSheetInstr.toString());
			}
		}

		return Result.success("123");
	}

}
