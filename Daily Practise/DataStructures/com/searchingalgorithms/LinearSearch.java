package com.searchingalgorithms;

public class LinearSearch {
	static String find(int [] arr, int ele) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==ele) {
				return "Element at index "+ i;
			}
			
		}
		return "Element not found";
	}

}
