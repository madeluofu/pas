package com.zifeng.pas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zifeng.pas.entity.PasAppraise;
import com.zifeng.pas.exception.CustomException;
import com.zifeng.pas.mapper.PasAppraiseMapper;
import com.zifeng.pas.service.PasAppraiseService;

@Service("PasAppraiseService")
public class PasAppraiseServiceImpl implements PasAppraiseService {
	@Autowired
	private PasAppraiseMapper pasAppraiseMapper;
	
	@Override
	public PasAppraise getOneByKey(String appraiseTpNo) {
		PasAppraise pasAppraise = pasAppraiseMapper.getOneByKey(appraiseTpNo);
		if( pasAppraise == null ) {
			throw new CustomException(300, "指定评价类型编号[" + appraiseTpNo + "]无效");
		}
		if( pasAppraise.getStat() == null || !(pasAppraise.getStat().toUpperCase().equals("Y")) ) {
			throw new CustomException(300, "指定评价类型编号[" + appraiseTpNo + "]非开通状态");
		}
		return pasAppraise;
	}

}
