package com.zifeng.pas.mapper;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zifeng.pas.entity.PasPara;

public interface PasParaMapper {
	@Select("SELECT * FROM t_pas_para")
	@Results({
		// @Result(property = "stat", column = "stat", javaType=PasParaStatEnum.class),
		@Result(property = "stat", column = "stat"),
		@Result(property = "readDirect", column = "read_direct"),
		@Result(property = "writeDirect", column = "write_direct"),
		@Result(property = "genFileTp", column = "gen_file_tp"),
		@Result(property = "dac", column = "dac")
	})
	PasPara get();

	@Update("UPDATE t_pas_para SET stat = #{stat}")
	void updateStat(String stat);

	@Update("UPDATE t_pas_para SET def_path = ${defPath}")
	void updateDefPath(String defPath);

	@Delete("DELETE FROM t_pas_para")
	void delete();
	
	@Insert("INSERT INTO t_pas_para(stat, def_path) VALUES(#{stat}, #{defPath})")
	void insert(PasPara pasPara);
}
