package com.jds.dsalgo.test;

public class CountFromArrays {

	public static void main(String[] args) {
		int[] A = { 2, -2, 3, 0, 4, -7 };
		System.out.println(solution(A));
	}

	static int solution(int[] A) {
		int count = 0;
		int[] dp = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				count++;
				continue;
			}
			for (int j = 0; j < A.length - i; j++) {
				dp[j] += A[j + i];
				if (dp[j] == 0) {
					count++;
				}
			}
		}
		if (count == A.length) {
			return -1;
		}
		return count;
	}
}
