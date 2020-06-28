package com.jds.dsalgo.algoandds.backtracking;

public class ArrayPossibleCombination {
	static int count = 0;

	public static void main(String[] args) {

		int[] ar = { 4, 5, 1, 6, 2, 8, 1 };
		calculate(ar, 0, ar.length, 0, Integer.MAX_VALUE);
	}

	static boolean calculate(int[] ar, int start, int end, int sum, int min) {
		count++;
		if (sum > 10) {
			return false;
		}
		System.out.println(String.format("Count %s:%d", count, sum));
		for (int i = start; i < end; i++) {
			boolean isExceed=calculate(ar, i + 1, end, sum + ar[i],min);
		}
		return true;
	}

}
