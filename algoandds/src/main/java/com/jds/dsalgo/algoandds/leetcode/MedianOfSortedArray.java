package com.jds.dsalgo.algoandds.leetcode;

public class MedianOfSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {1,3 };
		int[] nums2 = {2,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = 0;
		int n = 0;
		int mn = nums1.length + nums2.length;
		double sum = 0;
		int i = 0;
		while (i <= mn / 2) {
			int num = 0;
			if (m < nums1.length && n < nums2.length) {
				if (nums1[m] <= nums2[n]) {

					num = nums1[m];
					m++;
				} else {
					num = nums2[n];
					n++;
				}
			} else {
				if (m < nums1.length) {
					num = nums1[m];
					m++;
				} else {
					num = nums2[n];
					n++;
				}
			}

			if (mn % 2 == 0 && i == mn / 2 - 1) {
				sum += num;
			} else if (i == mn / 2) {
				sum += num;
			}
			i++;

		}

		return mn % 2 == 0 ? sum / 2 : sum;
	}
}
