package ctci;

/** Cracking 5.5:
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * e.g. 
 * Input: 31, 14
 * Output: 2
 */

/**
 * I figured this out all by myself! It's actually a bit different from the
 * solution provided by Cracking! I didn't continue to use bit manipulation
 * after using XOR.
 * 
 * In order to practice bit manipulation, I should continue with that.
 */
public class _20150916_BitsNeededToConvertIntegers_revisit {
	public static void calculateBits(int a, int b) {
		int diffBitsNum = a ^ b;

		String s = Integer.toBinaryString(diffBitsNum);
		char[] charArray = s.toCharArray();
		int result = 0;
		for (char c : charArray) {
			if (c == '1') {
				result++;
			}
		}
		System.out.println("The number of bits required to convert integer "
				+ a + " to integer " + b + " is " + result + ".");
	}

	public static void main(String args[]) {
		calculateBits(31, 14);
	}
}
