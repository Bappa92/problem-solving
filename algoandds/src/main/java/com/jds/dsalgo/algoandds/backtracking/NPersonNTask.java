package com.jds.dsalgo.algoandds.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NPersonNTask {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int no = 1;// Integer.parseInt(br.readLine());
			while (no > 0) {
				int n = 16;// Integer.parseInt(br.readLine());
				String[] num = "19 22 22 79 31 2 77 47 8 28 9 57 54 81 18 8 2 61 78 98 51 47 63 55 7 93 27 59 49 24 56 27 4 22 70 68 93 75 68 35 68 13 27 80 29 87 9 72 36 87 60 76 5 98 5 37 50 29 52 73 18 17 77 95 87 68 9 9 29 94 93 28 25 65 62 50 73 77 22 92 1 71 94 71 71 36 36 20 66 88 95 76 23 39 84 73 96 28 19 50 54 81 31 67 50 2 34 65 22 77 16 51 100 24 30 17 27 45 54 60 14 43 29 6 50 66 80 43 43 93 23 52 13 54 7 87 95 18 70 100 40 77 40 30 53 16 60 68 19 48 88 37 73 86 69 10 13 74 26 84 88 9 14 18 51 38 44 52 27 34 39 40 95 6 66 35 97 29 49 16 57 3 17 96 37 29 37 81 94 42 73 33 75 34 31 65 44 25 20 19 68 21 48 19 83 96 57 37 78 72 41 63 19 40 50 44 81 4 61 22 8 55 98 88 29 52 51 87 4 78 35 75 49 73 50 44 69 14 66 33 33 37 11 95 80 88 82 46 97 62 14 13 67 33 97 47"
						.split(" ");// br.readLine().split(" ");// "5,7,8,9,6,2,6,2,8,9,1,4,1,4,5,4".split(",");//
				int i = 0, j = 0;
				int[][] pt = new int[n][n];// { { 5, 7, 8, 9 }, { 6, 2, 6, 2 }, { 8, 9, 1, 4 }, { 1, 4, 5, 4 } };
				for (String d : num) {
					pt[i][j++] = Integer.parseInt(d);
					if (j % n == 0) {
						i++;
						j = 0;
					}
				}
				int[] taskToPerson = new int[n];
				System.out.println(minTimeCal(pt, taskToPerson, 0, Integer.MAX_VALUE, 0));
				no--;
			}
		} catch (Exception e) {
		}

	}

	private static int minTimeCal(int[][] pt, int[] taskToPerson, int sum, int min, int person) {
		for (int i = 0; i < pt.length; i++) {
			if (taskToPerson[i] == 0) {
				sum = sum + pt[person][i];
				if (sum < min) {
					taskToPerson[i] = i + 1;
					int thismin = person == pt.length - 1 ? sum : minTimeCal(pt, taskToPerson, sum, min, person + 1);
					min = Math.min(min, thismin);
					taskToPerson[i] = 0;
				}
				sum = sum - pt[person][i];
			}
		}
		return min;
	}
}
