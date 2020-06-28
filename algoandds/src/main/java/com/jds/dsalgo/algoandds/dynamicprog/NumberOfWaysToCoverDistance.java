package com.jds.dsalgo.algoandds.dynamicprog;

import java.time.Instant;
import java.util.Arrays;

public class NumberOfWaysToCoverDistance {

	public static void main(String[] args) {
		 int input=10;
		long start = Instant.now().toEpochMilli();
		int out = waysToCoverRec(input);
		System.out.println(out + "=" + (Instant.now().toEpochMilli() - start));

		int[] dp = new int[input+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		long start1 = Instant.now().toEpochMilli();
		int out1 = waysToCoverDp(4, input, dp);
		System.out.println(out1 + "=" + (Instant.now().toEpochMilli() - start1));
	}

	private static int waysToCoverRec(int i) {
		if (i == 0)
			return 1;
		if (i < 0) {
			return 0;
		}
		return waysToCoverRec(i - 1) + waysToCoverRec(i - 2) + waysToCoverRec(i - 3);
	}

	private static int waysToCoverDp(int i, int n, int[] dp) {

//		if (dp[i] != 0) {
//			return dp[i];
//		}
		for (; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

}
