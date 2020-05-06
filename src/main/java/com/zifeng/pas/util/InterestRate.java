package com.zifeng.pas.util;

public class InterestRate {
	public static void main(String argv[]) {
		int totalYear = 3; // total year
		int totalMonth = totalYear * 12; // total month
		double dayCreditInterestRate = 0.00016; // per day
		double debitInterestRate = 1.04; // per year
		double creditAmt = 58000;
		double monthCreditInterestRate = dayCreditInterestRate * 30; // per month
		double yearCreditInterestRate = 0.0612; // per year

		double totalInterest = 0.00;
		double totalAmt = creditAmt * Math.pow((1.0000+yearCreditInterestRate), totalYear);
		System.out.println("totalInterest = " + totalInterest);
		System.out.println("totalAmt = " + totalAmt);
		System.out.println("perMonth = " + (totalInterest + creditAmt)/(totalYear*12));
	}
}
