package com.jds.dsalgo.algoandd.stringarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Suduku {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
//				int s[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
//						{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
//						{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
//						{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

				 int s[][] = new int[9][9];
				String[] row = br.readLine().split("\\s");
				for (int i = 0; i <9; i++) {
					for (int j = 0; j < 9; j++) {
						s[i][j] = Integer.parseInt(row[i*9+j]);
					}
				}
				fillTheSuduku(s, 0, 0);
				t--;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static boolean fillTheSuduku(int[][] s, int si, int sj) {
		if (si == 8 && sj == 9) {
			print2DArray(s);
			return true;
		}
		if (sj == 9) {
			si++;
			sj = 0;
		}
		boolean b = false;
		for (int i = si; i < 9; i++) {
			for (int j = sj; j < 9; j++) {
				if (s[i][j] == 0) {
					Integer[] thisSet = findSetAt(s, i, j);
					if (thisSet.length == 0) {
						return false;
					}
					// print1DArray(thisSet);
					for (int e : thisSet) {
						s[i][j] = e;
						b = fillTheSuduku(s, i, j + 1);
						if (!b) {
							s[i][j] = 0;
						} else {
							return b;
						}
					}
					return b;

				}
				sj = 0;
			}

		}
		return false;
	}

	// private static void print1DArray(int[] thisSet) {
	// Arrays.stream(thisSet).forEachOrdered(e -> System.out.print(e + ","));
	// System.out.println();
	// }

	private static Integer[] findSetAt(int[][] s, int i, int j) {
		Boolean exist[] = new Boolean[9];
		for (int k = 0; k < 9; k++) {
			if (s[k][j] != 0) {
				exist[s[k][j] - 1] = true;
			}
		}
		for (int k = 0; k < 9; k++) {
			if (s[i][k] != 0) {
				exist[s[i][k] - 1] = true;
			}
		}
		for (int k = (i / 3) * 3; k < (i / 3 + 1) * 3; k++) {
			for (int l = (j / 3) * 3; l < (j / 3 + 1) * 3; l++) {
				if (s[k][l] != 0) {
					exist[s[k][l] - 1] = true;
				}
			}
		}
		List<Integer> arList = new ArrayList<>();
		for (int k = 0; k < exist.length; k++) {
			if (exist[k] == null) {
				arList.add(k + 1);
			}
		}
		return arList.toArray(new Integer[arList.size()]);
	}

	private static void print2DArray(int[][] s) {
		for (int i = 0; i < 9; i++) {
          for(int j=0;j<9;j++){
			System.out.print(s[i][j]);
			if(i!=8 || j!=8) {
			System.out.print(" ");}
		   }
		}
	}

}
