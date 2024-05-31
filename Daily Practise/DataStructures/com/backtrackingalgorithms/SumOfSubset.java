package com.backtrackingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfSubset {
	static void findSubsets(int[] set, int target) {
		Arrays.sort(set); // Optional: Sorting helps in pruning the search space
		List<Integer> currentSubset = new ArrayList<>();
		findSubsetsHelper(set, target, 0, currentSubset);
	}

	static void findSubsetsHelper(int[] set, int target, int index, List<Integer> currentSubset) {
		if (target == 0) {
			System.out.println(currentSubset);
			return;
		}
		for (int i = index; i < set.length; i++) {
			if (set[i] > target) {
				break;
			}
			currentSubset.add(set[i]);
			findSubsetsHelper(set, target - set[i], i + 1, currentSubset);
			currentSubset.remove(currentSubset.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] set = { 10, 20, 30, 40 };
		int target = 50;
		System.out.println("Subsets with sum " + target + ":");
		findSubsets(set, target);
	}
}