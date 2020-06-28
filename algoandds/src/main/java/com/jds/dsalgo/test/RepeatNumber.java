package com.jds.dsalgo.test;

import java.util.stream.IntStream;

public class RepeatNumber {

	public static void main(String[] args) {
		int x = 2;
		int y = 10;
		int z = 15;
		int count = 0;
		for (int n = z; n <= y; n++) {
			char[] m = String.valueOf(n * x).toCharArray();
			for (int i = 0; i < m.length; i++) {
				if (!String.valueOf(n).contains("" + m[i])) {
					break;
				}
				if (i == m.length - 1) {
					count++;
				}
			}
		}
	}

}
