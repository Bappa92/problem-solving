package com.jds.dsalgo.algoandds.interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxNonNegativeSubArray {

	public static void main(String args[]) {
		List<Integer> list = Stream.of(76724  ).collect(Collectors.toList());
		System.out.println(maxset(list));
	}

	public static ArrayList<Integer> maxset(List<Integer> A) {
		int thismax = 0;
		ArrayList<Integer> list = null;
		ArrayList<Integer> thislist = new ArrayList();
		for (int a : A) {
			if (thismax < thismax + a) {
				thismax = thismax + a;
				thislist.add(a);
				if (list == null || thislist.size() > list.size()) {
					list = thislist;
				}
			} else {

				thismax = 0;
				thislist = new ArrayList();
			}
		}
		return list;
	}
}
