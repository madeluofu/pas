package com.zifeng.pas.service;

import java.util.List;

import com.zifeng.pas.entity.PasSheet;

public interface PasSheetService {
	public List<PasSheet> listByAppraiseTpNo(String appraiseTpNo);
}
