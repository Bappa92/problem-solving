package com.jds.dsalgo.algoandds.dynamicprog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MiniOfOperations {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t > 0) {
				int n = sc.nextInt();
				System.out.println(minNoOfOperationsDp(n));
				t--;
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	private static int minNoOfOperationsDp(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) {
			if (i % 2 == 0) {
				dp[i] = 1 + dp[i / 2];
			} else {
				dp[i] = 1 + dp[i - 1];
			}
		}
		return dp[n];
	}

	private static int minNoOfOperationsRecursion(int n, int min) {
		if (n == 0) {
			return min;
		}
		if (n % 2 != 0) {
			n = n - 1;
			min++;
		} else {
			n = n / 2;
			min++;
		}
		return minNoOfOperationsRecursion(n, min);
	}

}
