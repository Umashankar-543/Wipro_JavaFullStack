package Day_23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumberCalculator {

	public static void main(String[] args) {
		int maxNumber = 100;
		ExecutorService executor = Executors.newFixedThreadPool(4);
		List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
		for (int i = 2; i <= maxNumber; i += 25) {
			int start = i;
			int end = Math.min(i + 24, maxNumber);
			futures.add(CompletableFuture.supplyAsync(() -> calculatePrimes(start, end), executor));
		}
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRunAsync(() -> {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
				for (CompletableFuture<List<Integer>> future : futures) {
					List<Integer> primes = future.join();
					for (int prime : primes) {
						writer.write(prime + "\n");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}, executor).join();
		executor.shutdown();
	}

	private static List<Integer> calculatePrimes(int start, int end) {
		List<Integer> primes = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	private static boolean isPrime(int number) {
		if (number < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
}