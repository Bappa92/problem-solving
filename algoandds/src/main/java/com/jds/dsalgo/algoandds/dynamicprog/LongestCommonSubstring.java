package com.jds.dsalgo.algoandds.dynamicprog;

import java.util.Scanner;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			while (t > 0) {
				// String[] lenStr = sc.nextLine().split(" ");
				int lenA = 6;// Integer.parseInt(lenStr[0]);
				int lenB = 6;// Integer.parseInt(lenStr[1]);
				String aStr = "ABCDGH"; // sc.nextLine();
				String bStr = "ACDGHR";// sc.nextLine();
				System.out.println(countLongestSubString(aStr, lenA, bStr, lenB));
				t--;
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	private static int countLongestSubString(String aStr, int lenA, String bStr, int lenB) {
		int[][] dp = new int[lenA + 1][lenB + 1];
		int max = 0;
		for (int i = 0; i <= lenA; i++) {
			for (int j = 0; j <= lenB; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}
				if (aStr.charAt(i-1) == bStr.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max;
	}
}
