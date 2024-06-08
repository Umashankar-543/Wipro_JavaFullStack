package Day_25;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		Map<String, Integer> wordCounts = new HashMap<>();
		try (FileReader fr = new FileReader(inputFile); Scanner scanner = new Scanner(fr)) {
			while (scanner.hasNext()) {
				String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
				if (!word.isEmpty()) {
					wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileWriter fw = new FileWriter(outputFile)) {
			for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
				fw.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}