package com.jds.dsalgo.algoandds;

import java.util.Arrays;

public class LargestKElements {

	public static void main(String[] args) {

		int[] ar = { 1, 23, 12,30,9, 30, 2, 50 ,7};
		Arrays.stream(ar).forEach(e -> System.out.print(e + ","));
		System.out.println("----------------");
		kBubbleSort(ar,ar.length);
		Arrays.stream(ar).forEach(e -> System.out.print(e + ","));
	}

	private static void kBubbleSort(int[] ar, int length) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <length -i-1; j++) {
				if (ar[j ] >ar[j+1]) {
					ar[j+1] = ar[j] + ar[j+1];
					ar[j] = ar[j+1]- ar[j];
					ar[j +1] = ar[j+1] - ar[j];
				}
				Arrays.stream(ar).forEach(e -> System.out.print(e + ","));
				System.out.println();
			}
			System.out.println("end of " + i);
		}
	}

}
