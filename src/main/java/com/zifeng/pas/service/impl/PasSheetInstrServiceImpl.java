package com.zifeng.pas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zifeng.pas.entity.PasSheetInstr;
import com.zifeng.pas.mapper.PasSheetInstrMapper;
import com.zifeng.pas.service.PasSheetInstrService;

@Service("PasSheetInstrService")
public class PasSheetInstrServiceImpl implements PasSheetInstrService {
	@Autowired
	PasSheetInstrMapper pasSheetInstrMapper;
	
	@Override
	public List<PasSheetInstr> listHeadBySheetNo(String sheetNo) {
		// TODO Auto-generated method stub
		List<PasSheetInstr> pasSheetInstr= pasSheetInstrMapper.listHeadBySheetNo(sheetNo);
		return pasSheetInstr;
	}

	@Override
	public List<PasSheetInstr> listTailBySheetNo(String sheetNo) {
		// TODO Auto-generated method stub
		List<PasSheetInstr> pasSheetInstr= pasSheetInstrMapper.listTailBySheetNo(sheetNo);
		return pasSheetInstr;
	}

}
