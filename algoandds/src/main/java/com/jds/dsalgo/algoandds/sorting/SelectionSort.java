package com.jds.dsalgo.algoandds.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = { 1, 4, 2, 6, 9, 10, 7, 8 };
		sort(a);
		Arrays.stream(a).forEach(e -> System.out.print(e + ","));
	}

	private static void sort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;

				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;			
		}
	}

}
