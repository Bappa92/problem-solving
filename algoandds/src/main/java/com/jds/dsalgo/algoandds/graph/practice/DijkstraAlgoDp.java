package com.jds.dsalgo.algoandds.graph.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DijkstraAlgoDp {

	public static void main(String[] args) {
		 int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0,
		 0, 0, 11, 0 },
		 { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9,
		 0, 10, 0, 0, 0 },
		 { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0,
		 0, 0, 0, 1, 0, 7 },
		 { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		shortestPath(graph);
	}

	private static void shortestPath(int[][] g) {

		for (int k = 0; k < g.length; k++) {
			for (int i = 0; i < g.length; i++) {
				for (int j = 0; j < g.length; j++) {
					if (i == j || i == k || j == k) {
						continue;
					}
					if (g[i][k] != 0 && g[k][j] != 0) {
						g[i][j] = g[i][j] == 0 ? g[i][k] + g[k][j] : Math.min(g[i][k] + g[k][j], g[i][j]);
					}
				}
			}
		}
		print2DArray(g);

	}

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
