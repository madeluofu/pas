package com.zifeng.pas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zifeng.pas.entity.PasSheet;
import com.zifeng.pas.mapper.PasSheetMapper;
import com.zifeng.pas.service.PasSheetService;

@Service("PasSheetService")
public class PasSheetServiceImpl implements PasSheetService{
	@Autowired
	private PasSheetMapper pasSheetMapper;

	public List<PasSheet> listByAppraiseTpNo(String appraiseTpNo){
		List<PasSheet> pasSheetList = pasSheetMapper.listByAppraiseTpNo(appraiseTpNo);
	
		return pasSheetList;
	}
}
