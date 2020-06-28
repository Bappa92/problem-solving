package com.jds.dsalgo.algoandds.hackerrank;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FormingMagicSquare {

	public static void main(String[] args) {
		int[][] s = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 5 } };
		int min = 0;
		for (int i = 0; i < 9; i++) {
			int lefttoright = 0, uptodwon = 0, diagonal = 0;
			for (int j = 0; j < 3; j++) {
				if (j != i % 3) {
					lefttoright += s[i / 3][j];
				}
			}
			for (int k = 0; k < 3; k++) {
				if (k != i / 3) {
					uptodwon += s[k][i % 3];
				}
			}
			for (int l = 0; l < 3; l++) {
				if (l != i % 3 && l != i / 3) {
					diagonal += s[l][l];
				}
			}
			if ((diagonal != 0 && lefttoright == uptodwon && uptodwon == diagonal)
					|| diagonal == 0 && lefttoright == uptodwon) {
				min = 15 - lefttoright - s[i / 3][i % 3];
				s[i / 3][i % 3] = 15 - lefttoright;

			}
		}
		Arrays.stream(s[0]).forEach(e->System.out.print(e+","));
		System.out.println();
		Arrays.stream(s[1]).forEach(e->System.out.print(e+","));
		System.out.println();
		Arrays.stream(s[2]).forEach(e->System.out.print(e+","));


	}
}