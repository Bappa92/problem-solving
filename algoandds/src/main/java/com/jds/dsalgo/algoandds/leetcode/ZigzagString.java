package com.jds.dsalgo.algoandds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ZigzagString {

	public static void main(String[] args) {
		int n = 4;
		String str = "paypalishiring";
		ArrayList<Character>[] list = new ArrayList[n];
		IntStream.range(0, 4).forEach(e -> list[e] = new ArrayList<Character>());
		int k = 0;
		boolean goDown = true;
		for (int i = 0; i < str.length(); i++) {
			list[k].add(str.charAt(i));
			if (k == n - 1) {
				goDown = false;
			} else if (k == 0) {
				goDown = true;
			}
			if (goDown) {
				k++;
			} else {
				k--;
			}
		}
		List<Integer> str1 = Arrays.asList(1, 2, 3);
		String num = str1.stream().map(String::valueOf).collect(Collectors.joining());
		System.out.println(num);
		System.out.println(Arrays.stream(list).map(e -> e.stream().map(String::valueOf).collect(Collectors.joining()))
				.collect(Collectors.joining()));

	}

}
