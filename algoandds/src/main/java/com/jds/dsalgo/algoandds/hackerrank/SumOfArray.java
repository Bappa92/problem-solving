package com.jds.dsalgo.algoandds.hackerrank;

import java.util.Arrays;

public class SumOfArray {

	public static void main(String[] args) {
		double[] ar= {1,2,3};
		double s=Arrays.stream(ar).sum();
		System.out.println(s);
	}

}
