package com.computationalalgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
	static class Item {
		int weight;
		int value;

		Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	public static double fractionalKnapsack(int capacity, Item[] items) {
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				double r1 = (double) o1.value / o1.weight;
				double r2 = (double) o2.value / o2.weight;
				return Double.compare(r2, r1);
			}
		});
		double totalValue = 0.0;
		for (Item item : items) {
			if (capacity - item.weight >= 0) {
				capacity -= item.weight;
				totalValue += item.value;
			} else {
				double fraction = ((double) capacity / item.weight);
				totalValue += (item.value * fraction);
				break;
			}
		}
		return totalValue;
	}

	public static void main(String[] args) {
		Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
		int capacity = 50;
		System.out.println("Maximum value in Knapsack = " + fractionalKnapsack(capacity, items));
	}
}