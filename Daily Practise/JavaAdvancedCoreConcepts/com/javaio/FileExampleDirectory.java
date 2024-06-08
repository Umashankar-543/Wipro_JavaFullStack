package com.javaio;

import java.io.File;
import java.io.IOException;

public class FileExampleDirectory {

	public static void main(String[] args) throws IOException {

		File f = new File("Sample");
		System.out.println(f.exists());
		f.mkdir();
		System.out.println(f.exists());
	}
}