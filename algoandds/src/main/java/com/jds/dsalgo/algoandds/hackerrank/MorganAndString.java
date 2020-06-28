package com.jds.dsalgo.algoandds.hackerrank;

public class MorganAndString {

	public static void main(String[] args) {
		System.out.println(morganAndString("JACK", "DANIEL"));
	}

	static String morganAndString(String a, String b) {
		int i = 0, j = 0;
		char[] output = new char[a.length() + b.length()];
		int k = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) <= b.charAt(j)) {
				output[k++] = a.charAt(i);
				i++;
			} else {
				output[k++] = b.charAt(j);
				j++;
			}
		}
		while (i < a.length()) {
			output[k++] = a.charAt(i);
			i++;
		}
		while (j < b.length()) {
			output[k++] = b.charAt(j);
			j++;
		}
		return new String(output);

	}

}
