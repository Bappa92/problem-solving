package com.jds.dsalgo.algoandds;

public class EvenAndOddSegregation {

	public static void main(String[] args) {
		int[] ar = { 12, 34, 45, 9, 8, 90, 3 };
		System.out.println(minMove(ar));
	}

	public static int minMove(int[] ar) {
		int count = 0;
		int i = 0;
		int j = ar.length - 1;
		int odd = -1;
		int even = -1;
		while (i < j) {
			if (odd == -1) {
				if (ar[i] % 2 != 0) {
					odd = i;
				} else {
					i++;
				}
			}
			if (even == -1) {
				if (ar[j] % 2 == 0) {
					even = j;
				} else {
					j--;
				}
			}
			if (even != -1 && odd != -1 && odd < even) {
				count++;
				int temp = ar[even];
				ar[even] = ar[odd];
				ar[odd] = temp;
				i++;
				j--;
				even = -1;
				odd = -1;
			}
		}
		return count;

	}
}
