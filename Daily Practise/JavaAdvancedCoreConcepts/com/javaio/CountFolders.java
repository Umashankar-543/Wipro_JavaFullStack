package com.javaio;

import java.io.File;

public class CountFolders {

	public static void main(String[] args) {
		int folderCount = 0;
		File directory = new File("C:\\Sample");
		String[] filesAndFolders = directory.list();
		if (filesAndFolders != null) {
			for (String name : filesAndFolders) {
				File item = new File(directory, name);
				if (item.isDirectory()) {
					folderCount++;
					System.out.println(name);
				}
			}
		}
		System.out.println("Total folders: " + folderCount);
	}
}