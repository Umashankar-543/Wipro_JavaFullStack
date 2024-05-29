package Day_18;

public class BitManipulationBasics {
	public static int countSetBits(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int num = 88;
		System.out.println("Number of set bits in " + num + ": " + countSetBits(num));
	}
}
