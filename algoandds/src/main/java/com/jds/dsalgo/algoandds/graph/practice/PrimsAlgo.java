package com.jds.dsalgo.algoandds.graph.practice;

import java.security.Principal;
import java.util.Arrays;

public class PrimsAlgo {

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
            { 2, 0, 3, 8, 5 }, 
            { 0, 3, 0, 0, 7 }, 
            { 6, 8, 0, 0, 9 }, 
            { 0, 5, 7, 9, 0 } }; 
            primMinCost(graph);
	}
	private static void primMinCost(int[][] g) 
	{
		int v=g.length;
		boolean[] mstSet=new boolean[v];
		int[] w=new int[v];
		int parent[]=new int[v];
		Arrays.fill(w, Integer.MAX_VALUE);
		int e=0;
		w[0]=0;
		while(e<v-1) {
			e++;
			int u=minWeight(mstSet, w);
			
			mstSet[u]=true;
			for(int i=0;i<v;i++) {
				if(mstSet[i]==false && g[u][i]!=0 && g[u][i]<w[i]) 
				{
					w[i]=g[u][i];
					parent[i]=u;
				}
			}
		}
		printMst(parent,g);
	}
	private static void printMst(int[] parent, int[][] g) {
		for(int i=1;i<parent.length;i++) {
			System.out.println(parent[i]+" to "+i+":"+g[parent[i]][i]);
		}
	}
	private static int minWeight(boolean mstSet[], int[] w) 
	{
		int  minIndex=-1, min=Integer.MAX_VALUE;
		for(int i=0;i<w.length;i++) 
		{
			if(mstSet[i]==false && w[i]<min) 
			{
				min=w[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
}
