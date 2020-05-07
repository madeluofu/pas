package com.zifeng.pas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zifeng.pas.entity.PasSheet;

public interface PasSheetMapper {
	@Select("SELECT * FROM t_pas_sheet WHERE appraise_tp_no = #{appraiseTpNo}")
	List<PasSheet> listByAppraiseTpNo(@Param("appraiseTpNo") String appraiseTpNo);
}
