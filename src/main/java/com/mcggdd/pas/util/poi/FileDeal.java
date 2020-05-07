package com.zifeng.pas.util.poi;

import java.io.File;

public class FileDeal {
	public boolean createDir(String dirPath) {
		File dir = new File(dirPath);
		if( !dir.exists() && !dir.isDirectory() ) {
			System.out.println(dir + "不存在， 即将创建");
			dir.mkdir();
		}else {
			System.out.println(dir + "已存在，无需创建");
		}
		return true;
	}
}
