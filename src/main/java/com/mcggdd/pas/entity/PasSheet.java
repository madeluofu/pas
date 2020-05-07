package com.zifeng.pas.entity;

import lombok.Data;

@Data
public class PasSheet {
	private String appraiseTpNo;
	private int ser;
	private String sheetNo;
	private String sheetName;
	private String stat;
	private String sheetTp;
	private int maxRow;
	private int maxCol;
	private String appraiseCycTp;
	private String dataSrc;
	private String appraiseObjTp;
	private String objList;
	private String shortRmrk;
	private String midRmrk;
	private String longRmrk;
	private String dac;
}
