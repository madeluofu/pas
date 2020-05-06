package com.zifeng.pas.service;

import java.util.List;

import com.zifeng.pas.entity.PasCell;

public interface PasCellService {
	public List<PasCell> listBySheetNo(String sheetNo);
}
