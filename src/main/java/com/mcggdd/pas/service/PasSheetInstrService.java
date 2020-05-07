package com.zifeng.pas.service;

import java.util.List;

import com.zifeng.pas.entity.PasSheetInstr;

public interface PasSheetInstrService {
	public List<PasSheetInstr> listHeadBySheetNo(String sheetNo);

	public List<PasSheetInstr> listTailBySheetNo(String sheetNo);
}
