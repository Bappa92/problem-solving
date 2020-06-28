package com.jds.dsalgo.algoandds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		Integer[] Ar = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3 };
		List<Integer> A = Arrays.stream(Ar).collect(Collectors.toList());
		int count = removeDuplicates(A);
		for (int i = 0; i < count; i++) {
			System.out.print(A.get(i) + "");
		}

	}

	public static int removeDuplicates(List<Integer> a) {
		if (a == null || a.size() == 0) {
			return 0;
		}
		int last = a.get(0);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(last);
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i) != last) {
				list.add(a.get(i));
			}
			last = a.get(i);
		}
		// for(int i=0;i<list.size();i++) {
		a.addAll(0, list);
		// }
		return list.size();
	}
}
