package com.jds.dsalgo.test;

public class ShiftNumber {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3 };
		int i = 0;
		int n = ar.length;
		while (i < n - 1) {
			ar[i] = ar[i] + ar[i + 1];
			i++;
			if (i == n - 1) {
				i = 0;
				n = n - 1;
			}
		}
		System.out.println(ar[0]);
	}

}
