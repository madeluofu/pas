package com.zifeng.pas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zifeng.pas.entity.PasCell;
import com.zifeng.pas.mapper.PasCellMapper;
import com.zifeng.pas.service.PasCellService;

@Service("PasCellService")
public class PasCellServiceImpl implements PasCellService{
	@Autowired
	PasCellMapper pasCellMapper;
	
	@Override
	public List<PasCell> listBySheetNo(String sheetNo) {
		List<PasCell> pasCellList = pasCellMapper.listBySheetNo(sheetNo);
		return pasCellList;
	}

}
