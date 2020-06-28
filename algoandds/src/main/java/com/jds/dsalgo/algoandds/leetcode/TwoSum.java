package com.jds.dsalgo.algoandds.leetcode;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		LinkedHashMap<String, String> cache = new LinkedHashMap<>(3);
		Set<Entry<String, String>> eset = cache.entrySet();
		cache.put("123", "344");
		cache.put("233", "daadd");
		cache.put("adad", "sdassdsad");
		cache.put("sdada", "sadada");
		System.out.println(cache);
	}
	// public static int[] twoSum(int[] nums, int target) {
	//
	// }
}
