package com.jds.dsalgo.algoandds.codechef.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BearAndSpecies {

	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			if (t < 1 && t > 50) {
				throw new Exception();
			}
			while (t > 0) {
				int n = sc.nextInt();
				if (n < 2 && n > 50) {
					throw new Exception();
				}
				char[][] cell = new char[n][n];
				for (int i = 0; i < n; i++) {
					cell[i] = sc.next().toCharArray();
				}
				System.out.println(noOfWaysBearsInhabited(cell, 0, 0, 0, false));
				t--;
			}
		} catch (Exception exp) {
			throw new Exception();
		}
	}

	private static long noOfWaysBearsInhabited(char[][] cell, int i, int j, long count, boolean isQuestionMarkFound) {
		int n = cell.length;
		if (i == n - 1 && j == n) {

			return isQuestionMarkFound ? count + 1 : 0;
		}
		if (j == n) {
			j = 0;
			i++;
		}
		if (cell[i][j] == '?') {
			// long countb = 0, countp = 0, countg = 0;
			if (isTheBearFitInTheCell(cell, i, j, 'B')) {
				cell[i][j] = 'B';
				count = noOfWaysBearsInhabited(cell, i, j + 1, count, true);
				cell[i][j] = '?';
			}
			if (isTheBearFitInTheCell(cell, i, j, 'P')) {
				cell[i][j] = 'P';
				count = noOfWaysBearsInhabited(cell, i, j + 1, count, true);
				cell[i][j] = '?';
			}
			if (isTheBearFitInTheCell(cell, i, j, 'G')) {
				cell[i][j] = 'G';
				count = noOfWaysBearsInhabited(cell, i, j + 1, count, true);
				cell[i][j] = '?';
			}
			// count = countb + countp + countg;
		} else {
			return noOfWaysBearsInhabited(cell, i, j + 1, count, isQuestionMarkFound);
		}
		return count;
	}

	private static boolean isTheBearFitInTheCell(char[][] cell, int i, int j, char c) {
		switch (c) {
		case 'B':
			if (i - 1 >= 0 && (cell[i - 1][j] == 'G' || cell[i - 1][j] == 'P')) {
				return false;
			}
			if (j - 1 >= 0 && (cell[i][j - 1] == 'G' || cell[i][j - 1] == 'P')) {
				return false;
			}
			if (i + 1 < cell.length && (cell[i + 1][j] == 'G' || cell[i + 1][j] == 'P')) {
				return false;
			}
			if (j + 1 < cell.length && (cell[i][j + 1] == 'G' || cell[i][j + 1] == 'P')) {
				return false;
			}
			return true;
		case 'P':
			if (i - 1 >= 0 && (cell[i - 1][j] == 'G' || cell[i - 1][j] == 'B')) {
				return false;
			}
			if (j - 1 >= 0 && (cell[i][j - 1] == 'G' || cell[i][j - 1] == 'B')) {
				return false;
			}
			if (i + 1 < cell.length && (cell[i + 1][j] == 'G' || cell[i + 1][j] == 'B')) {
				return false;
			}
			if (j + 1 < cell.length && (cell[i][j + 1] == 'G' || cell[i][j + 1] == 'B')) {
				return false;
			}
			return true;
		case 'G':
			if (i - 1 >= 0 && (cell[i - 1][j] != '.')) {
				return false;
			}
			if (j - 1 >= 0 && (cell[i][j - 1] != '.')) {
				return false;
			}
			if (i + 1 < cell.length && (cell[i + 1][j] != '.')) {
				return false;
			}
			if (j + 1 < cell.length && (cell[i][j + 1] != '.')) {
				return false;
			}
			return true;
		}
		return false;
	}

}
