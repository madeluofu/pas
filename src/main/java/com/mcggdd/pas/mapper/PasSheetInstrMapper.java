package com.zifeng.pas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zifeng.pas.entity.PasSheetInstr;

public interface PasSheetInstrMapper {
	@Select("SELECT * FROM t_pas_sheet_relat WHERE sheet_no = #{sheetNo} AND instr_tp = 'H' ORDER BY ser")
	List<PasSheetInstr> listHeadBySheetNo(@Param("sheetNo") String sheetNo);

	@Select("SELECT * FROM t_pas_sheet_relat WHERE sheet_no = #{sheetNo} AND instr_tp = 'T' ORDER BY ser")
	List<PasSheetInstr> listTailBySheetNo(@Param("sheetNo") String sheetNo);
}
