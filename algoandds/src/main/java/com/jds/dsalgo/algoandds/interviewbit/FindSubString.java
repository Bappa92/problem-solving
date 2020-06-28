package com.jds.dsalgo.algoandds.interviewbit;

public class FindSubString {

	public static void main(String[] args) {
		System.out.println(strStr("apple", "webapple"));
	}

	/**
	 * Find a string in another string
	 * @param A String to be searched
	 * @param B String to search
	 * @return index in B if A is found in B otherwise -1
	 */
	public static int strStr(final String A, final String B) {
		int hashA = 0;
		//Evaluate the hash of String A
		for (int i = 0; i < A.length(); i++) {
			hashA = hashA*10 + A.charAt(i);
		}
		int hashB = 0;
		for (int i = 0; i < B.length(); i++) {
			hashB = hashB*10 + B.charAt(i);
			//hashB is calculated of same length of String A
			if (i >= A.length() - 1) {
				if (hashA == hashB) {
					int k = 0;
					// hashA and hashB is equal, check if they are same or not.
					for (int j = i + 1 - A.length(); j <= i; j++) {
						if (B.charAt(j) != A.charAt(k++)) {
							break;
						}
						if (k == A.length()) {
							return i + 1 - k;
						}
					}
				}
				// remove the contribution of first index of curent length of hash from hashB
				hashB -= (int) Math.pow(10, A.length() - 1) * B.charAt(i + 1 - A.length());
			}
		}
		return -1;
	}
}
