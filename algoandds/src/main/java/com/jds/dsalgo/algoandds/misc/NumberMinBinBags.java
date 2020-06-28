package com.jds.dsalgo.algoandds.misc;

import java.util.Scanner;

public class NumberMinBinBags {
	public static void binPacking(int[] a, int size, int n) {
		int binCount = 1;
		int s = size;
		for (int i = 0; i < n; i++) {
			if (s - a[i] > 0) {
				s -= a[i];
				continue;
			} else {
				binCount++;
				s = size;
				i--;
			}
		}

		System.out.println("Number of bins required: " + binCount);
	}

	public static void main(String args[]) {
		System.out.println("BIN - PACKING Algorithm");
		System.out.println("Enter the number of items in Set: ");
		int n = 8;
		System.out.println("Enter " + n + " items:");
		int[] a = { 4, 5, 8, 3, 4, 5, 1, 6 };
		System.out.println("Enter the bin size: ");
		int size = 10;
		binPacking(a, size, n);
	}
}