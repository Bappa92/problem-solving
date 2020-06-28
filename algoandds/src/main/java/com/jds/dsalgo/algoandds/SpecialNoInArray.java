package com.jds.dsalgo.algoandds;


public class SpecialNoInArray {

	public static void main(String[] args) {
		int size = 2;
		int[] ar = { 12, 3 };
		int output = 0;
		for (int i = 0; i < size; i++) {
			int n = ar[i];
			for (int j = n / 2; j >= 1; j--) {
				if (j + Integer.parseInt(new StringBuffer(""+j).reverse().toString()) == n) {
					output++;
					break;
				}
			}
		}
		System.out.println(output);
	}

}
