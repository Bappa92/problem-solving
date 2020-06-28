package com.jds.dsalgo.algoandds.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int a[]= {2,4,1,7,3,8,4,9,10,7};
		sort(a,a.length-1);
		Arrays.stream(a).forEach(e->System.out.print(e+","));
	}

	private static void sort(int[] a, int n) {
		for(int i=0;i<n;i++) 
		{
			for(int j=1;j<n-i;j++) 
			{
				if(a[j]<=a[j-1]) 
				{
					int temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
	}

}
