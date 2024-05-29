package Day_18;

public class UniqueElementsIdentification {
	public static int[] findNonRepeatingElements(int[] nums) {
		int[] result = new int[2];
		int xor = 0;
		for (int num : nums) {
			xor ^= num;
		}
		int rightmostSetBit = xor & -xor;
		int group1XOR = 0, group2XOR = 0;
		for (int num : nums) {
			if ((num & rightmostSetBit) == 0) {
				group1XOR ^= num;
			} else {
				group2XOR ^= num;
			}
		}
		result[0] = group1XOR;
		result[1] = group2XOR;
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 4, 5, 2, 3, 3, 1 };
		int[] nonRepeatingElements = findNonRepeatingElements(nums);
		System.out.println("Non-repeating elements are: " + nonRepeatingElements[0] + ", " + nonRepeatingElements[1]);
	}
}