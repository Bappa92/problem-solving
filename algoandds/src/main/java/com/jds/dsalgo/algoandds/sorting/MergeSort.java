package com.jds.dsalgo.algoandds.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a= {1,5,5,6,3,7,9,2,8,1};
		sort(a,0,a.length-1);
		Arrays.stream(a).forEach(e->System.out.print(e+","));
	}

	private static void sort(int[] a, int l, int r) {
		if(l<r) 
		{
			int m=(l+r)/2;
			sort(a,l,m);
			sort(a,m+1,r);
			merge(a,l,m,r);
		}
	}

	private static void merge(int[] a, int l, int m, int r) {

		int temp[]=new int[r-l+1];
		int i=l;
		int j=m+1;
		int k=0;
		while(i<=m && j<=r) 
		{
			if(a[i]<=a[j])
			{
				temp[k++]=a[i++];
			}else 
			{
				temp[k++]=a[j++];
			}
		}
		while(i<=m)
		{
			temp[k++]=a[i++];
		}
		while(j<=r)
		{
			temp[k++]=a[j++];
		}
		
		int p=0;
		while(p<temp.length){
			a[l++]=temp[p++];
		}
	}

}
