package com.zifeng.pas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zifeng.pas.entity.PasCell;

public interface PasCellMapper {
	@Select("SELECT * FROM t_pas_cell WHERE sheet_no = #{sheetNo} ORDER BY ROW_NO, COL_NO")
	List<PasCell> listBySheetNo(@Param("sheetNo") String sheetNo);
}
