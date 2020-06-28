package com.jds.dsalgo.algoandds.hackerrank;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class BuildPalindrom {

	public static void main(String[] args) {
		buildPalindrome("bac", "bac");
	}

	static String buildPalindrome(String a, String b) {
		if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
			return "-1";
		}
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;
		String output = "-1";

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					continue;
				}
				if (a.charAt(m - i) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;

					if (max <= dp[i][j]) {
						
						max = dp[i][j];
						
						char[] outputChars = new char[2 * max + 1];
						int k = 0;

						// making first of the palindrom
						for (int si = m - i; si < m - i + max; si++) {
							outputChars[k++] = a.charAt(si);
						}
						// making middle element of the palindrom
						char mc = 0;
						if (m - i + max < m) {
							mc = a.charAt(m - i + max);
						}
						if (j - max - 1 >= 0 && (int) mc > b.codePointAt(j - max - 1)) {
							mc = b.charAt(j - max - 1);
						}
						// String ms = mc != 255 ? "" + (char) mc : "";
						if (mc != 0) {
							outputChars[k++] = mc;
						}

						// making first of the palindrom
						for (int si = max - 1; si >= 0; si--) {
							outputChars[k++] = outputChars[si];
						}
						String thisStr = new String(outputChars, 0, k);
						if (output.equals("-1")) {
							output = thisStr;
						} else if (thisStr.compareTo(output) < 0) {
							output = thisStr;
						}
						System.out.println(output);
					}
				}

			}
		}

		 System.out.println(output);
		return output;
	}
}
