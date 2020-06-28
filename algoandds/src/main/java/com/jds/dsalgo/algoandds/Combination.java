package com.jds.dsalgo.algoandds;

public class Combination {

	static String[] str = new String[20];
	static int i = 0;

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5 };
		combination(ar, ar[0], 0, ar.length - 1);
	}

	private static void combination(int[] ar, int element, int start, int end) {
		for (int i = start; i < end; i++) {
			System.out.print(element + "," + ar[i] + ">");
			combination(ar, ar[i], i + 1, end);
		}
	}
}
