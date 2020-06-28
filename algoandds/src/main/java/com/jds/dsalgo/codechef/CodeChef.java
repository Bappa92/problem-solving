package com.jds.dsalgo.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class CodeChef {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			if (n < 2 || n > 1000) {
				throw new Exception();
			}
			int k = sc.nextInt();
			int p = sc.nextInt();
			int ar[] = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextInt();
			}
			// int[] ar= {9,8,7,1,5,6};
			// int n=6;
			// int k=3;
			// int p=5;
			int output = findMagicSeq(ar, n, k, p);
			System.out.println(output);
			t--;
		}
	}

	private static int findMagicSeq(int[] ar, int n, int k, int p) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (ar[j] > ar[j + 1]) {
					int temp = ar[j + 1];
					ar[j + 1] = ar[j];
					ar[j] = temp;
				}

			}
		}
		// Arrays.stream(ar).forEach(e->System.out.print(e+","));
		// System.out.println();

		int[] subs = new int[k];
		int count = subSequence(ar, subs, n, k, 0, p, 0);
		return count;
	}

	private static int subSequence(int[] ar, int[] subs, int n, int k, int m, int p, int count) {
		if (k == 0) {
			// Arrays.stream(subs).forEach(e -> System.out.print(e + ","));
			// System.out.println();
			return count + countThisSequence(subs, p);
		}
		for (int i = m; i <= n - k; i++) {
			subs[k - 1] = ar[i];
			count = subSequence(ar, subs, n, k - 1, i + 1, p, count);
		}
		return count;
	}

	private static int countThisSequence(int[] subs, int p) {
		for (int i = 0; i < subs.length - 1; i++) {
			if (subs[i] - subs[i + 1] > p) {
				return 0;
			}
		}
		return 1;
	}

}
