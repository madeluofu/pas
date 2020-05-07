package com.zifeng.pas.util;

public class StringUtils {

	// 字母转数字 A-Z ：1-26
	public int letterToNumber(String letter) {
		int length = letter.length();
		int num = 0;
		int number = 0;
		for (int i = 0; i < length; i++) {
			char ch = letter.charAt(length - i - 1);
			num = (int) (ch - 'A' + 1);
			num *= Math.pow(26, i);
			number += num;
		}
		return number;
	}

	// 数字转字母 1-26 ： A-Z
	public String numberToLetter(int num) {
		if (num <= 0) {
			return null;
		}
		String letter = "";
		num--;
		do {
			if (letter.length() > 0) {
				num--;
			}
			letter = ((char) (num % 26 + (int) 'A')) + letter;
			num = (int) ((num - num % 26) / 26);
		} while (num > 0);

		return letter;
	}
}
