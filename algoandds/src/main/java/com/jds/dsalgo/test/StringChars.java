package com.jds.dsalgo.test;

public class StringChars {

	public static void main(String[] args) {
		String name1 = "namesss1";
		String name2 = "s";
		char c = name2.charAt(0);
		int count = 0;
		for (int i = 0; i < name1.length(); i++) {
			if (c == name1.charAt(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

}
