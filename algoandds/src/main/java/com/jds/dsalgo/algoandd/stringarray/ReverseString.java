package com.jds.dsalgo.algoandd.stringarray;

import java.lang.Character.UnicodeBlock;

/**
 * Reverse a string without changing the position of special char
 * 
 * @author Bappa
 *
 */
public class ReverseString {
	public static void main(String args[]) {
		char[] str = "Ab,c,de!$".toCharArray();
		int r = str.length - 1, l = 0;

		// Traverse string from both ends until
		// 'l' and 'r'
		while (l < r) {
			// Ignore special characters
			if (!Character.isAlphabetic(str[l]))
				l++;
			else if (!Character.isAlphabetic(str[r]))
				r--;

			// Both str[l] and str[r] are not spacial
			else {
				char tmp = str[l];
				str[l] = str[r];
				str[r] = tmp;
				l++;
				r--;
			}
		}
		System.out.println(str);
	}
}
