package com.jds.dsalgo.algoandds.dynamicprog;

import java.util.Arrays;

public class DistinctOccurrences {

	public static void main(String[] args) {
		String t = "banana";
		String s = "ban";
		System.out.println(subsequenceCount(s, t));
	}

	static int subsequenceCount(String S, String T) {
		int sl = S.length();
		int tl = T.length();
		int[][] st = new int[sl + 1][tl + 1];

		for (int i = 0; i <= sl; i++) {
			for (int j = 0; j <= tl; j++) {
				if (i == 0 || j == 0) {
					st[i][j] = 0;
					continue;
				}
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					st[i][j] = i==1 ?1+st[i][j-1]:st[i][j - 1]+st[i-1][j];
				} else {
					st[i][j] = st[i][j - 1];
				}
			}
		}
		System.out.println(Arrays.toString(T.toCharArray()));
		System.out.println(Arrays.toString(st[0]));
		System.out.println(Arrays.toString(st[1]));
		System.out.println(Arrays.toString(st[2]));
		System.out.println(Arrays.toString(st[3]));		
		return st[sl][tl];
	}
}
