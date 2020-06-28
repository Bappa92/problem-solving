package com.jds.dsalgo.algoandds.dynamicprog;

import java.util.Arrays;

public class LongestIncreasingSequence {

	public static void main(String[] args) {
		int[] ar = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int[] ar1 = { 3, 10, 8, 9, 20, 30 };
		int[] ar2 = { 50, 3, 10, 7, 40, 80 };
		// int output=lisUsingRecursion(ar,ar[0],0,ar.length);
		// System.out.println(output);
		int output2 = lisUsingDP(ar, ar.length);
		System.out.println(output2);

		output2 = lisUsingDP(ar1, ar1.length);
		System.out.println(output2);
		output2 = lisUsingDP(ar2, ar2.length);
		System.out.println(output2);

	}

	private static int lisUsingDP(int[] ar, int n) {
		int lis[] = new int[n];
		Arrays.fill(lis, 1);
		Arrays.stream(lis).forEach(e -> System.out.print(e + ","));
		System.out.println();
//		for (int i = n - 2; i >= 0; i--) {
//			for (int j = i + 1; j < n; j++) {
//				if (ar[i] <= ar[j]) {
//					lis[i] = 1 + lis[j];
//					break;
//				}
//			}
//		}
		 for ( int i = 1; i < n; i++ ) 
             for ( int j = 0; j < i; j++ )  
                        if ( ar[i] > ar[j] && lis[i] < lis[j] + 1) 
                   lis[i] = lis[j] + 1; 
		 
		Arrays.stream(lis).forEach(e -> System.out.print(e + ","));
		System.out.println();
		return Arrays.stream(lis).summaryStatistics().getMax();
	}

	private static int lisUsingRecursion(int[] ar, int element, int start, int length) {
		if (start == length) {
			return 0;
		}
		for (int i = start; i < length; i++) {
			if (ar[i] >= element) {
				return 1 + Math.max(lisUsingRecursion(ar, ar[i], start + 1, length),
						lisUsingRecursion(ar, element, start + 1, length));
			} else {
				return lisUsingRecursion(ar, element, start + 1, length);
			}
		}
		return 0;
	}

}
