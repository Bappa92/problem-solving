package com.jds.dsalgo.algoandds.hackerrank;

import java.util.stream.IntStream;

public class NoOfTallestCandles {

	public static void main(String[] args) {
		int[] arr = { 942381765, 627450398, 954173620, 583762094, 236817490 };
		miniMaxSum(arr);

	}

	static void miniMaxSum(int[] arr) {
		long max = 0, min = Long.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			long sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					sum += arr[j];
				}
			}
			if (sum >= max) {
				max = sum;
			}
			if (sum < min) {
				min = sum;
			}
		}
		System.out.println(min + " " + max);
	}

}
