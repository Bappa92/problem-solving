package com.jds.dsalgo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestInRowSmallestInColumn {

	public static void main(String[] args) {

		// 66 32 4
		// 56 31 320
		// 10 9 20
		//
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		List<Integer> matrix0 = new ArrayList<Integer>();
		matrix0.add(60);
		matrix0.add(32);
		matrix0.add(4);
		matrix.add(matrix0);

		List<Integer> matrix1 = new ArrayList<Integer>();
		matrix1.add(56);
		matrix1.add(31);
		matrix1.add(320);
		matrix.add(matrix1);

		List<Integer> matrix2 = new ArrayList<Integer>();
		matrix2.add(10);
		matrix2.add(9);
		matrix2.add(20);
		matrix.add(matrix2);

		System.out.println(find_largest_in_row_smallest_in_column_element_in_matrix(matrix));
	}

	public static int find_largest_in_row_smallest_in_column_element_in_matrix(List<List<Integer>> matrix) {
		int[] row = new int[matrix.size()];
		Arrays.fill(row, -1);
		int[] col = new int[matrix.get(0).size()];
		Arrays.fill(col, Integer.MAX_VALUE);
		for (int i = 0; i < matrix.size(); i++) {
			List<Integer> mrow = matrix.get(i);
			for (int j = 0; j < mrow.size(); j++) {
				if (row[i] == -1 || mrow.get(j) > matrix.get(i).get(row[i])) {
					row[i] = j;
				}
				if (col[j] == Integer.MAX_VALUE || matrix.get(col[j]).get(j) > mrow.get(j)) {
					col[j] = i;
				}
			}
		}
		for (int i = 0; i < row.length; i++) {
			if (i == col[row[i]]) {
				return matrix.get(i).get(row[i]);
			}
		}
		return -1;
	}

}
