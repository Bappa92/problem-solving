package com.jds.dsalgo.algoandds.interviewbit;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = a.length;
		maxSubArraySum(a, n);
	}

	private static void maxSubArraySum(int[] a, int n) {
		int max_so_far = 0, max = Integer.MIN_VALUE, start = 0, end = 0;
		int s = 0;
		// adding positive max_so_far to postive ar[i] will give bigger number,

		// if max_so_far become negative,reset it to 0, adding negative will make more
		// negarive, adding positive will make less max_so_far than the postive number;
		for (int i = 0; i < n; i++) {
			max_so_far += a[i];
			if (max_so_far > max) {
				max = max_so_far;
				end = i;
				start = s;
			}
			if (max_so_far < 0) {
				max_so_far = 0;
				s = i + 1;
			}
		}
	}

}
