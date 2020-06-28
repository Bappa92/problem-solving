package com.jds.dsalgo.algoandds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KthSmallestElement {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				int[] ar = Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
				int k =  Integer.parseInt(br.readLine());
				sort(ar, k);
				System.out.println(ar[k - 1]);
				t--;
			}
		} catch (Exception exp) {
			System.err.println();
		}
	}

	private static void sort(int[] ar, int k) {
		int n = ar.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(ar, i, n);
		}
		for (int i = n - 1; i >= k - 1; i--) {
			int temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;

			heapify(ar, 0, i);
		}
	}

	private static void heapify(int[] ar, int i, int n) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (l < n && ar[largest] < ar[l]) {
			largest = l;
		}
		if (r < n && ar[largest] < ar[r]) {
			largest = r;
		}
		if (largest != i) {
			int temp = ar[i];
			ar[i] = ar[largest];
			ar[largest] = temp;
			heapify(ar, largest, n);
		}
	}

}
