package com.jds.dsalgo.algoandds.leetcode;

import java.util.Arrays;

public class FlipZerosToOneToGetMax {

	public static void main(String[] args) {
		int[] ar = { 0, 0, 0, 1 };// , 1, 0, 1, 0, 1, 1, 1 };
		int m = 4;
		int[] output = flipToMax(ar, m);
		Arrays.stream(output).forEach(e -> System.out.print(e + ","));
	}

	public static int[] flipToMax(int ar[], int m) {
		//also queue can be used instead of array
		int[] zero_pos = new int[ar.length];
		int z_index = 0;
		int cur_index = 0;
		int max = 0;
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 1) {
				count++;
			} else if (m > 0) {
				m--;
				count++;
				zero_pos[cur_index++] = i;
			} else {
				count = count - zero_pos[z_index++];
				zero_pos[cur_index++] = i;
			}
			max = Math.max(count, max);
		}
		int[] output = new int[cur_index - z_index];
		for (int i = z_index; i < cur_index; i++) {
			output[i - z_index] = zero_pos[i];
		}
		return output;
	}

}
