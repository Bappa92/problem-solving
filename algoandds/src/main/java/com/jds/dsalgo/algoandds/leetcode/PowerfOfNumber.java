package com.jds.dsalgo.algoandds.leetcode;

public class PowerfOfNumber {

	public static void main(String[] args) {
		System.out.println(myPow(2.00000, -2147483648));
		System.out.println(Math.pow(2.00000,  -2147483648));
	}

	public static double myPow(double x, int n) {
		double ans = 1;
		double multi = x;
		for (int i = Math.abs(n); i >= 1; i = i / 2) {
			if (i % 2 != 0) {
				ans = ans * multi;
			}
			multi = multi * multi;
		}
		return n == 0 ? 1 : n < 0 ? 1 / ans : ans;
	}
}
