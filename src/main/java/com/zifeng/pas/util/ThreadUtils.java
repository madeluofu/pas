package com.zifeng.pas.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadUtils {
	//private static final ThreadLocal<Map<String, Object>> holder = new ThreadLocal<>();
	private static final ThreadLocal<Map<String, Object>> threadHolder = new ThreadLocal<Map<String, Object>>() {
		protected synchronized Map<String, Object> initialValue(){
			return new HashMap<String, Object>();
		}
	};

	public static void remove() {
		threadHolder.remove();
	}

	public static void setHolder(String key, Object obj) {
		threadHolder.get().put(key, obj);
	}

	public static Object getHolder(String key) {
		return threadHolder.get().get(key);
	}
}
