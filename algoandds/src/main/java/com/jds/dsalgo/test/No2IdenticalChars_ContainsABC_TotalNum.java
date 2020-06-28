package com.jds.dsalgo.test;

import java.util.ArrayList;
import java.util.Arrays;

public class No2IdenticalChars_ContainsABC_TotalNum {

	public static void main(String[] args) {
		int N = 3, K = 4;

		Arrays.stream(solution(N, K)).forEach(e -> System.out.print(e + ","));
	}

	public static String[] solution(int N, int K) {
		if (N == 0 || K == 0) {
			return new String[] { "" };
		}

		ArrayList<String> result = new ArrayList<String>();
		for (String p : solution(N - 1, K - 1)) {
			for (char l : new char[] { 'a', 'b', 'c' }) {
				int pLen = p.length();
				if (pLen == 0 || p.charAt(pLen - 1) != l) {
					result.add(p + l);
				}
			}
		}
		int prefSize = Math.min(result.size(), K);
		return result.subList(0, prefSize).toArray(new String[prefSize]);
	}
}
