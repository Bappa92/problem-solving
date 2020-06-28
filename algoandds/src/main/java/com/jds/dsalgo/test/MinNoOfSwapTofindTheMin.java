package com.jds.dsalgo.test;

public class MinNoOfSwapTofindTheMin {

	public static void main(String[] args) {
		System.out.println(maximiser("1123",1));
	}

	static String maximiser(String input1, int input2) {
		char[] ins = input1.toCharArray();
		String max = new String(Integer.MIN_VALUE + "");
		for (int i = 0; i < input1.length() - input2; i++) {
			for(int j=i+input2;j>i;j--) {
				char c = ins[j];
				ins[j] = ins[j -1];
				ins[j-1] = c;	
			}
			String m = new String(ins);
			if (max.compareTo(m) < 0) {
				max = m;
			}
			for(int j=i;j<=i+input2-1;j++) {
				char c = ins[j];
				ins[j] = ins[j +1];
				ins[j+1] = c;	
			}
		}
		return max;
	}
}
