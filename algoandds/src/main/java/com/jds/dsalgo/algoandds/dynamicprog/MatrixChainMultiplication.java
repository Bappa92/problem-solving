package com.jds.dsalgo.algoandds.dynamicprog;

/**
 * 
 * Input: p[] = {40, 20, 30, 10, 30} Output: 26000 There are 4 matrices of
 * dimensions 40x20, 20x30, 30x10 and 10x30. Let the input 4 matrices be A, B, C
 * and D. The minimum number of multiplications are obtained by putting
 * parenthesis in following way (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 * 
 * @author Bappa
 *
 */
public class MatrixChainMultiplication {
	// Dynamic Programming Python implementation of Matrix
	// Chain Multiplication.
	// See the Cormen book for details of the following algorithm // Matrix Ai has
	// dimension p[i-1] x p[i] for i = 1..n
	static int MatrixChainOrder(int p[], int n) {
		/*
		 * For simplicity of the program, one extra row and one extra column are
		 * allocated in m[][]. 0th row and 0th column of m[][] are not used
		 */
		int m[][] = new int[n][n];

		int i, j, k, L, q;

		/*
		 * m[i, j] = Minimum number of scalar multiplications needed to compute the
		 * matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is p[i-1] x p[i]
		 */

		// cost is zero when multiplying one matrix.
		for (i = 1; i < n; i++)
			m[i][i] = 0;

		// L is chain length.
		for (L = 2; L < n; L++) {
			for (i = 1; i < n - L + 1; i++) {
				j = i + L - 1;
				if (j == n)
					continue;
				m[i][j] = Integer.MAX_VALUE;
				for (k = i; k <= j - 1; k++) {
					// q = cost/scalar multiplications
					q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j])
						m[i][j] = q;
				}
			}
		}

		return m[1][n - 1];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 3, 4 };
		int size = arr.length;

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, size));
	}
}
