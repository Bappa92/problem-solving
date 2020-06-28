package com.jds.dsalgo.algoandds.dynamicprog;

public class NoOfMinBins {

	public static void main(String[] args) {
		int[] ar = { 2, 5, 4, 7, 1, 3, 8 };
		int binSize = 10;
		int outputby = minBinsByBacktracking(ar, 0, binSize, 0, Integer.MAX_VALUE);
		System.out.println(outputby);
	}

	private static int minBinsByBacktracking(int[] ar, int start, int binSize, int min, int outPut) {
		for (int i = start; i < ar.length; i++) {
			if(binSize-ar[i]>0) 
			{
				minBinsByBacktracking(ar, start + 1, binSize - ar[i], min, outPut);
			}else {
				min=min+1;
			}
			//int thismin=;
			//outPut = Math.min(min + , outPut);
		}
		return outPut;
	}

}
