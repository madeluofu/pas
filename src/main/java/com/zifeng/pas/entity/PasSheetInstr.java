package com.zifeng.pas.entity;

import lombok.Data;

@Data
public class PasSheetInstr {
	private String sheetNo;
	private String instrTp;
	private int ser;
	private String instrCont;
	private String shortRmrk;
	private String midRmrk;
	private String longRmrk;
	private String dac;
}
