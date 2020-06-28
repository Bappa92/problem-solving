package com.jds.dsalgo.algoandds.sorting;

import java.util.Arrays;

public class QickSort {

	public static void main(String[] args) {
		int[] a = { 3, 7, 4, 5, 9, 1, 8, 2, 6 };
		sort(a, 0, a.length - 1);
		System.out.println("After Sorted:");
		Arrays.stream(a).forEach(e -> System.out.print(e + ","));
	}

	public static void sort(int[] a, int low, int high) {
		if (low < high) {
			int pi = partition(a, low, high);
			sort(a, low, pi - 1);
			sort(a, pi + 1, high);
		}
	}

	public static int partition(int[] a, int low, int high) {
		int pivot = a[high];// a[k];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		;
		int temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return i + 1;
	}
}
