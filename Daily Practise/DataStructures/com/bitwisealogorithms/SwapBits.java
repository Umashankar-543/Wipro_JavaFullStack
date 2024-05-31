package com.bitwisealogorithms;

public class SwapBits {
	public static int swapBits(int n, int i, int j) {
		int bitAtI = (n >> i) & 1;
		int bitAtJ = (n >> j) & 1;
		if (bitAtI == bitAtJ) {
			return n;
		}
		int mask = (1 << i) | (1 << j);
		n = n ^ mask;
		return n;
	}

	public static void main(String[] args) {
		int num = 77;
		int i = 5;
		int j = 2;
		System.out.println("Original number: " + num + " (" + Integer.toBinaryString(num) + ")");
		int result = swapBits(num, i, j);
		System.out.println("Number after swapping bits at positions " + i + " and " + j + ": " + result + " ("
				+ Integer.toBinaryString(result) + ")");
	}
}
