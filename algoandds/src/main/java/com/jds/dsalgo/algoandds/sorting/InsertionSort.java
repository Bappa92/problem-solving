package com.jds.dsalgo.algoandds.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 1, 4, 2, 6, 9, 10, 7, 8 };
		sort(a);
		Arrays.stream(a).forEach(e -> System.out.print(e + ","));
	}

	private static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			System.out.println("at i="+i);
			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
			Arrays.stream(arr).forEach(e -> System.out.print(e + ","));
			System.out.println();
		}
	}

}
