package com.zifeng.pas.service;

import com.zifeng.pas.exception.Result;

public interface GenReportService {
	public Result<String> genReport(String appraiseTpNo, String circle);
}
