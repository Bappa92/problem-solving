package com.jds.dsalgo.test;

public class ASSS {

	public static void main(String[] args) {
		int x = 2;
		int y = 10;
		int z = 15;
		int count = 0;
		for (int n = y; n <= z; n++) {
			char[] m = String.valueOf(n * x).toCharArray();
			for (int i = 0; i < m.length; i++) {
				if (String.valueOf(n).contains("" + m[i])) {
					break;
				}
				if (i == m.length - 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
