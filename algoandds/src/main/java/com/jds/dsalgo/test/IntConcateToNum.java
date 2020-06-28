package com.jds.dsalgo.test;

public class IntConcateToNum {

	public static void main(String[] args) {
		 long n=3;
		 String num="";
		for(long i=1;i<=n;i++) {
			num=num+Long.toBinaryString(i);
		}
		long output = Long.parseLong(num, 2);
		System.out.println(output);
	}

}
