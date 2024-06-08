package com.javaio;

import java.io.File;

public class CountFile {

	public static void main(String[] args) {

		int fileCount = 0;
		File directory = new File("C:\\Sample");
		String[] filesAndFolders = directory.list();
		if (filesAndFolders != null) {
			for (String name : filesAndFolders) {
				File item = new File(directory, name);
				if (item.isFile()) {
					fileCount++;
					System.out.println(name);
				}
			}
		}
		System.out.println("Total files: " + fileCount);
	}
}