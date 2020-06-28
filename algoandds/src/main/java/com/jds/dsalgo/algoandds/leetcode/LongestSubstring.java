package com.jds.dsalgo.algoandds.leetcode;

import java.util.Arrays;

public class LongestSubstring {
	public static void main(String[] args) {
		String str = "abba";

		System.out.println(lengthOfLongestSubstring(str));
	}

	public static int lengthOfLongestSubstring(String s) {
		int[] index = new int[128];
		int max = 0;
		int len = max;
		int start = 0;
		Arrays.fill(index, -1);
		for (int i = 0; i < s.length(); i++) {
			int pos = s.codePointAt(i);
			if (index[pos] == -1) {
				len++;
			} else {
				if (index[pos] >= start) {
					len = i - index[pos];
					start = index[pos] + 1;
				} else {
					len++;
				}
			}
			index[pos] = i;
			max = Math.max(max, len);
		}
		return max;
	}
}
