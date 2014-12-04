package DynamicProgramming;

import Basic.ArrayPrinter;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "abcdbab";
		String s2 = "bdcaba";

		System.out.println("==> s1: " + s1 + " , s2: " + s2);
		System.out.println("LCS:" + LCS(s1, s2));
	}

	public static int LCS(String s1, String s2) {

		int s1len = s1.length();
		int s2len = s2.length();
		char[] s1c = s1.toCharArray();
		char[] s2c = s2.toCharArray();

		Integer[][] lcs = new Integer[s1len + 1][s2len + 1];

		for (int i = 0; i <= s1len; i++) {
			for (int j = 0; j <= s2len; j++) {
				lcs[i][j] = 0;
			}
		}

		for (int i = 1; i <= s1len; i++) {
			for (int j = 1; j <= s2len; j++) {
				if (s1c[i - 1] == s2c[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		ArrayPrinter.twoDimension(lcs);

		int max = lcs[s1len][s2len];
		char[] seq = new char[max];
		int i = s1len, j = s2len;
		while (max > 0) {
			if (lcs[i][j] != lcs[i - 1][j - 1]) {
				if (lcs[i - 1][j] == lcs[i][j - 1]) {
					seq[max - 1] = s1c[i - 1];
					max--;
					i--;
					j--;
				} else {
					if (lcs[i - 1][j] > lcs[i][j - 1]) {
						i--;
					} else {
						j--;
					}
				}
			} else {
				i--;
				j--;
			}
		}

		System.out.println(seq);
		return max;
	}
}
