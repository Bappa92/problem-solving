package com.jds.dsalgo.test;

public class CountInRangeOfNo {

	public static void main(String[] args) {
		System.out.println(solution(6, 20));
	}

	static int solution(int A, int B) {
		int count = 0;
		for (int i = A; i <= B; i++) {
			int a = (int) Math.sqrt(i);
			if (a * (a + 1) == i) {
				count++;
			}
		}
		return count;
	}
}
