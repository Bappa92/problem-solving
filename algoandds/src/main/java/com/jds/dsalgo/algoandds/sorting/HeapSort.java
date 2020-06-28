package com.jds.dsalgo.algoandds.sorting;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] a = { 2, 4, 7, 2, 8, 3, 9, 10 };
		int n = a.length;
		// building the heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(a, n, i);
		}
		// After building the heaf parent always bigger than it left and right children
		// but not sure who is bigger than and left and right children
		// extract root element and heapify the new root node
		for(int i=n-1;i>=0;i--)
		{
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			heapify(a,n,0);
		}
		System.out.println("After sorted:");
		Arrays.stream(a).forEach(e->System.out.print(e+","));
	}

	public static void heapify(int[] ar, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && ar[largest] > ar[l]) {
			largest = l;
		}
		if (r < n && ar[largest] > ar[r]) {
			largest = r;
		}
		if (largest != i) {
			int temp = ar[largest];
			ar[largest] = ar[i];
			ar[i] = temp;
			heapify(ar, n, largest);
		}
	}

}
