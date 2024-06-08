package com.javaio;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritingExample {

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("example.txt", true);
		fw.write("Hi!");
		fw.write("This Batch\n is a very good batch");
		fw.write('\n');
		char[] ch = { 'a', 'b', 'c' };
		fw.write(ch);
		fw.write('\n');
		fw.flush();
		fw.close();
	}
}