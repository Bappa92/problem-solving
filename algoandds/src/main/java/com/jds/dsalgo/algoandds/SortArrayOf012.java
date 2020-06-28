package com.jds.dsalgo.algoandds;

import java.util.Arrays;

public class SortArrayOf012 {

	public static void main(String[] args) {
		int[] ar={2, 1, 2, 0, 1, 2};
		int lower=-1;
		int upper=ar.length;
		for(int i=0;i<ar.length;i++) 
		{
			if(ar[i]==0) 
			{
				ar[i]=ar[++lower];
				ar[lower]=0;
			}else if(ar[i]==2 && i<upper) 
			{
				ar[i]=ar[--upper];
				ar[upper]=2;
				i--;
			}
					
		}
		Arrays.stream(ar).forEach(e->System.out.print(e));
	}

}
