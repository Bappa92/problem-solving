package com.jds.dsalgo.algoandds.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given a square grid of size N, each cell of which contains integer cost which
 * represents a cost to traverse through that cell, we need to find a path from
 * top left cell to bottom right cell by which total cost incurred is minimum.
 * 
 * Note : It is assumed that negative cost cycles do not exist in input matrix.
 * 
 * <pre>
 * Input:
 *  2 
 *  5 
 *  31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41
 *  20
 *  2 
 *  42 93 7 14 
 *  Output:
 *  327 
 *  63
 * </pre>
 * 
 * @author Bappa
 *
 */
public class MinCostPath {

	public static void main(String[] args) {
		int[][] g = { { 31, 100, 65, 12, 18 }, { 10, 13, 47, 157, 6 }, { 100, 113, 174, 11, 33 },
				{ 88, 124, 41, 20, 140 }, { 99, 32, 111, 41, 20 } };
		print2DArray(g);
		int n = g.length;
		boolean[][] b = new boolean[n][n];
		System.out.println(minCostBacktrackking(g, n - 1, n - 1, b));
		// minCostDp(g);

	}

	private static int minCostBacktrackking(int[][] g, int i, int j, boolean b[][]) {
		if (i == 0 && j == 0) {
			return g[i][j];
		}
		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}
		b[i][j]=true;
		int left = minCostBacktrackking(g, i - 1, j, b);
	     if (left!=Integer.MAX_VALUE ) {
	    	 b[i-1][j]=false;
	     }

		int up = minCostBacktrackking(g, i, j - 1, b);
		if (up!=Integer.MAX_VALUE ) {
	    	 b[i][j-1]=false;
	     }
		int right = minCostBacktrackking(g, i, j + 1, b);
		if (right!=Integer.MAX_VALUE ) {
	    	 b[i][j+1]=false;
	     }
		int down = minCostBacktrackking(g, i + 1, j, b);
		if (down!=Integer.MAX_VALUE ) {
	    	 b[i+1][j]=false;
	     }
		return g[i][j] + Math.min(Math.min(left, up), Math.min(right, down));
	}

	private static void minCostDp(int[][] g) {
		int n = g.length;
		for (int d = 1; d <= n; d++) {
			for (int i = 0; i < d; i++) {
				// g[i][d]=g[i][d]+Math.4(g[i][d-1], g[d-1][d-1]+g[d-1][d]);
				// g[d][i]=g[d][i]+Math.min(g[d-1][i], g[]);
			}
			g[d][d] = g[d][d] + Math.min(g[d][d - 1], g[d - 1][d]);
		}
		print2DArray(g);

	}

	/**
	 * @param dp
	 */
	private static void print2DArray(int[][] dp) {
		System.out.println("{");
		IntStream.range(0, dp.length).forEachOrdered(i -> {
			System.out.print("{");
			Arrays.stream(dp[i]).forEach(e -> System.out.print(e + ",\t"));
			System.out.println("}");
		});
		System.out.println("}");
	}

}
