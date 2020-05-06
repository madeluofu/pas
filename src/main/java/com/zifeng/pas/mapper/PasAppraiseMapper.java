package com.zifeng.pas.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zifeng.pas.entity.PasAppraise;

public interface PasAppraiseMapper {
	@Select("SELECT * FROM t_pas_appraise WHERE appraise_tp_no = #{appraiseTpNo}")
	PasAppraise getOneByKey(@Param("appraiseTpNo") String appraiseTpNo);
}
