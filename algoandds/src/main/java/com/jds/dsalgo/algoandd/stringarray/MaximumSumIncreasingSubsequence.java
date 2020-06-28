package com.jds.dsalgo.algoandd.stringarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int arSize = Integer.parseInt(br.readLine());
			int[] ar = new int[arSize];
			String str[] = br.readLine().split(" ");
			for (int i = 0; i < str.length; i++) {
				ar[i] = Integer.parseInt(str[i]);
			}
			int max[] = new int[arSize];
			max[0] = ar[0];
			for (int i = 1; i < ar.length; i++) {
				int m = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (ar[j] < ar[i]) {
						m = max[j] > m ? max[j] : m;
					}
				}

				max[i] = m + ar[i];

			}
			System.out.println(Arrays.stream(max).max().getAsInt());
			t--;
		}
	}
}
