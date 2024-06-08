package com.javaio;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample2 {

	public static void main(String[] args) {

		try (FileOutputStream outputStream = new FileOutputStream("example.txt")) {
			String text = "Hello, World!";
			outputStream.write(text.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}