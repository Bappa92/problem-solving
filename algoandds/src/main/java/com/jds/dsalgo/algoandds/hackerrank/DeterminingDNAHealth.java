package com.jds.dsalgo.algoandds.hackerrank;

import java.awt.geom.CubicCurve2D;

public class DeterminingDNAHealth {

	public static void main(String[] args) {
		int n = 6;
		String[] genes = { "a", "b", "c", "aa", "d", "b" };
		int[] health = { 1, 2, 3, 4, 5, 6 };
		int s = 3;

		int start = 1;
		int end = 5;
		String d = "caaab";
		int dh = getHeath(genes, health, n, start, end, d);
		System.out.println(dh);
	}

	private static int getHeath(String[] genes, int[] health, int n, int start, int end, String d) {
		int h = 0;
		for (int i = start; i <= end; i++) {
			String thisgene = genes[i];
			int ghash = 0;
			for (int j = 0; j < thisgene.length(); j++) {
				ghash += ((int) thisgene.charAt(j) - 96) * Math.pow(10, thisgene.length() - j - 1);
			}
			int max = 0;
			int thishash = 0;
			for (int j = 0; j < d.length(); j++) {
				thishash = thishash * 10 + ((int) d.charAt(j) - 96);
				if (j + 1 >= thisgene.length()) {
					// if(thishash == ghash && ) {
					// max++;
					// }
					thishash = (int) (thishash
							- ((int) d.charAt(j + 1 - thisgene.length()) - 96) * Math.pow(10, thisgene.length() - 1));
				}
			}
			h += health[i] * max;
		}
		return h;
	}

	private static String findGenes(String gene, String pattern) {
		int i = -1;
		if ((i = pattern.indexOf(gene)) != -1) {
			String d = "";
			for (int j = 0; j < pattern.length(); j++) {
				if (j != i) {
					d += pattern.charAt(j);
				}
			}
			return d;
		}
		return pattern;
	}

}
