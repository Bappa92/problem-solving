package com.jds.dsalgo.algoandds.dynamicprog;

class FindSumFromArray {
	static int count = 0;

	public static void main(String[] args) {
		int[] ar = { 1, 5, 7, -1 };
		countSum(ar, ar[0], 6, 1);
		System.out.println(count);
	}

	private static void countSum(int[] ar, int temp, int sum, int k) {
		if (temp == sum) {
			count++;
			return;
		}
		if (temp > sum) {
			return;
		}
		for (; k < ar.length; k++) {
			countSum(ar, temp + ar[k], sum, k + 1);
		}

	}

}
