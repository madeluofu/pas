package com.zifeng.pas.entity;

import lombok.Data;

@Data
public class PasPara {
	private String sysStat;
	private String readDirect;
	private String writeDirect;
	private String genFileTp;
	private String shortRmrk;
	private String midRmrk;
	private String longRmrk;
//	@JsonProperty(access = Access.WRITE_ONLY) //在输出的Json数据中隐藏密码，只能输入不输出
	private String dac;
}