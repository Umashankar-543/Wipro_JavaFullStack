package Assignment_4;

public class RabinKarpAlgorithm {
	public static void search(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();
		int d = 256;
		int q = 101;
		int p = 0;
		int t = 0;
		int h = 1;
		int comparisons = 0;
		for (int i = 0; i < m - 1; i++) {
			h = (h * d) % q;
		}
		for (int i = 0; i < m; i++) {
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}
		for (int i = 0; i <= n - m; i++) {
			if (p == t) {
				int j;
				for (j = 0; j < m; j++) {
					comparisons++;
					if (text.charAt(i + j) != pattern.charAt(j)) {
						break;
					}
				}
				if (j == m) {
					System.out.println("Pattern found at index " + i);
				}
			}
			if (i < n - m) {
				t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
				if (t < 0) {
					t = t + q;
				}
			}
		}
		System.out.println("Total comparisons: " + comparisons);
	}
}