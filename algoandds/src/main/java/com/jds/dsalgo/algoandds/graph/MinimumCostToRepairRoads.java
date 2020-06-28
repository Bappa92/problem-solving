package com.jds.dsalgo.algoandds.graph;

public class MinimumCostToRepairRoads {

	public static void main(String[] args) {
		int[][] city = { { 0, 1, 1, 100, 0, 0 }, { 1, 0, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0 }, { 100, 0, 0, 0, 2, 2 },
				{ 0, 0, 0, 2, 0, 2 }, { 0, 0, 0, 2, 2, 0 } };
		;// { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
		// { 4, 7, 0, 0, 0 } };
		System.out.println(minCostEval(city));
	}

	private static int minCostEval(int[][] city) {
		int minCost = city[1][0];// cost between 1 to 2
		for (int i = 2; i < city.length; i++) {
			// minmum cost to reach ith city
			int minToThisNode = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (city[i][j] != 0) {
					minToThisNode = Math.min(minToThisNode, city[i][j]);
				}
			}
			minCost += minToThisNode;
		}
		return minCost;
	}

}
