package com.javaio;

import java.io.File;

public class FileExample2 {

	public static void main(String[] args) {
		File f = new File("C:\\Sample");
		int count = 0;
		String[] s = f.list();
		for (String s1 : s) {
			count = count + 1;
			System.out.println(s1);
		}
		System.out.println("Count of files " + count);
	}
}