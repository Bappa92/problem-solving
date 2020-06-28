package com.jds.dsalgo.algoandds.dynamicprog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SortestSubString {

	public static void main(String[] args) {
		String s = "asdfkjeghfalawefhaef"; //
		// String s = "bab";
		shortestSubstring(s);

	}

	public static int shortestSubstring(String s) {

		int min = Integer.MAX_VALUE;
		Set<Character> setOut = new HashSet();
		for (int j = 0; j < s.length(); j++) {
			setOut.add(s.charAt(j));
		}
		for (int i = 0; i < s.length(); i++) {
			String minStr = "";
			Set<Character> setT = new HashSet();
			for (int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				minStr = minStr + c;
				setT.add(c);
				if (setT.size() == setOut.size()) {
					min = Math.min(min, minStr.length());
				}
			}
		}

		System.out.println(min);
		return min;

	}
}
