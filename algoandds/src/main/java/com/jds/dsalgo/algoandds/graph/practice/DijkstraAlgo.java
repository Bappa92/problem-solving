package com.jds.dsalgo.algoandds.graph.practice;

import java.util.Arrays;

public class DijkstraAlgo {

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		shortestPath(graph);
	}

	private static void shortestPath(int[][] g) {
		int v = g.length;
		int[] dis = new int[v];
		Arrays.fill(dis, Integer.MAX_VALUE);
		boolean[] sptSet = new boolean[v];

		int e = 0;
		dis[0] = 0;
		while (e < v - 1) {
			e++;
			int u = minDistance(dis, sptSet);
			sptSet[u]=true;
			for(int i=0;i<v;i++) 
			{
				if(sptSet[i]==false && g[u][i]!=0 && dis[u]+g[u][i]<dis[i]) {
					dis[i]=dis[u]+g[u][i];
				}
			}
		}
		printShortestPath(dis);

	}

	private static void printShortestPath(int[] dis) {
		for(int i=1;i<dis.length;i++) {
			System.out.println("0 to "+i+" shortest path:"+dis[i]);
//			tance from Source
//			0 tt 0
//			1 tt 4
//			2 tt 12
//			3 tt 19
//			4 tt 21
//			5 tt 11
//			6 tt 9
//			7 tt 8
//			8 tt 14
		}
	}

	private static int minDistance(int[] dis, boolean[] sptSet) {
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dis.length; i++) {
			if (sptSet[i] == false && dis[i] < min) {
				min = dis[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
