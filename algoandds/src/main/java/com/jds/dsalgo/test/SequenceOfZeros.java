package com.jds.dsalgo.test;

public class SequenceOfZeros {

	public static void main(String[] args) {
		int[] a = { 2, -2, 3, 0, 4, -7 };
		int n = a.length;
		boolean isAllZero = true;
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int sum = a[i];
			if (sum == 0) {
				count++;
				continue;
			} else {
				isAllZero = false;
			}
			for (int j = i + 1; j < n; j++) {
				sum = +a[j];
				if (sum == 0) {
					count++;
				}

			}
		}
		System.out.println(count);
	}
}
