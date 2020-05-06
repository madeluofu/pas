package com.zifeng.pas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zifeng.pas.entity.PasPara;
import com.zifeng.pas.exception.CustomException;
import com.zifeng.pas.mapper.PasParaMapper;
import com.zifeng.pas.service.PasParaService;

@Service("PasParaService")
public class PasParaServiceImpl implements PasParaService {
	@Autowired
	private PasParaMapper pasParaMapper;

	public PasPara get() {
		System.out.println("开始取平台参数表");

		// 检查平台状态
		PasPara pasPara = pasParaMapper.get();
		if (pasPara == null) {
			throw new CustomException(300, "平台参数表记录数为空");
		}
		String sysStat = pasPara.getSysStat();
		if (sysStat == null || !(sysStat.toUpperCase().equals("Y"))) {
			throw new CustomException(300, "平台非工作状态");
		}
		
		return pasPara;
	}

}
