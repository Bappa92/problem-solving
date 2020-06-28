package com.jds.dsalgo.test;

public class AestheticallyPleasingTree {

	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 3, 7 };
		// output 3
		// int[] a={1,2,3,1};// output 0
		// int[] a={1,2,3,4};//output -1
		boolean islow = true;
		for (int i = 1; i < a.length; i++) {
			if (i == 1 && a[i] > a[i - 1]) {
				islow = false;
				return;
			}
			if(islow && a[i]<a[i-1]) {}
		}
	}
}
