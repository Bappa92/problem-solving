package com.jds.dsalgo.algoandds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProductSubArray {

	public static void main(String[] args) {
		// Integer[] A = { 1, 0, 0, 0, 0, 0, -2, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 0, 0,
		// 0, 0, -1, 0, 0, 0, 0, 0, 0,
		// 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, -3, 0, 0,
		// 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0,
		// 1, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 2, 0, 0, 0, 0, 0,
		// 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 2, 0,
		// 0, 0, 0, 0, 0, -2, 3, 0, 0, 0, 0, 0, 0, -2, -3, -3, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 1, 0, 2, 0, 0, 2, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, -2, 0, 0, 0, 2, -3, 0, 0, 0,
		// 0 };
		// Integer[] A = { 0, -2, 3, 0, -2, -3, -3 };
		Integer[] A = { 2, 3, -1, 4 };
		System.out.println(maxProduct(Arrays.asList(A)));
	}

	public static int maxProduct(final List<Integer> A) {
		int n = A.size();
		List<Integer> maxarray = new ArrayList<Integer>();
		List<Integer> minarray = new ArrayList<Integer>();
		maxarray.add(A.get(0));
		minarray.add(A.get(0));
		int result = A.get(0);
		for (int i = 1; i < n; i++) {
			if (A.get(i) > 0) {
				maxarray.add(Math.max(A.get(i), maxarray.get(i - 1) * A.get(i)));
				minarray.add(Math.min(A.get(i), minarray.get(i - 1) * A.get(i)));
			} else {
				maxarray.add(Math.max(A.get(i), minarray.get(i - 1) * A.get(i)));
				minarray.add(Math.min(A.get(i), maxarray.get(i - 1) * A.get(i)));
			}
			result = Math.max(result, maxarray.get(i));
		}

		return result;
	}

}
