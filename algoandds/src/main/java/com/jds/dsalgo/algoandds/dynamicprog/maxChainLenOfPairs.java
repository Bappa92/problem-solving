package com.jds.dsalgo.algoandds.dynamicprog;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class maxChainLenOfPairs {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = 1;// sc.nextInt();
			while (t > 0) {
				int n = 34;// sc.nextInt();
				String inputStr = "778 887 794 916 336 387 493 650 363 422 28 691 60 764 541 927 173 427 212 737 369 568 430 783 531 863 68 124 136 930 23 803 59 70 168 394 12 457 43 230 374 422 785 920 199 538 316 325 371 414 92 527 957 981 863 874 171 997 282 306 85 926 328 337 506 847 314 730"
						+ "";// sc.nextLine();
				Pair[] pairs = new Pair[n];
				String as[] = inputStr.split(" ");
				Pair pair = null;
				for (int i = 0; i < as.length; i++) {
					if (i % 2 == 0) {
						pair = new Pair();
						pair.x = Integer.parseInt(as[i]);
					} else {
						pair.y = Integer.parseInt(as[i]);
						pairs[i / 2] = pair;
					}

				}
				System.out.println(maxChainLengths(pairs, n));
				t--;
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	private static int maxChainLengths(Pair[] pairs, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		Arrays.sort(pairs, (p, p1) -> {
			return p.x - p1.x;
		});
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (pairs[i].x > pairs[j].y && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		return Arrays.stream(dp).max().getAsInt();
	}

}

class Pair {
	int x, y;
}
