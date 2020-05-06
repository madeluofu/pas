package com.zifeng.pas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zifeng.pas.service.GenReportService;

@RestController
@RequestMapping("/genReport")
public class GenReportController {
	@Autowired
	private GenReportService genReportService;

	@GetMapping("{appraiseTpNo}/{circle}")
	public String genExcel(@PathVariable("appraiseTpNo") String appraiseTpNo,
			@PathVariable("circle") String circle) {
		genReportService.genReport(appraiseTpNo, circle);
		return genReportService.toString();
	}
}
