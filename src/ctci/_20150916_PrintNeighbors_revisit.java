package ctci;

/** Cracking 5.3:
 * Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation. */

/* Adopted the brute force method from Cracking, implemented the code all by myself. */

/* There are more delicate algorithms described in Cracking, but I didn't read. */

public class _20150916_PrintNeighbors_revisit {

	/*
	 * With this function we count how many 1s there are in a's binary
	 * representation.
	 */
	public static int count1s(int a) {
		int count = 0, temp = a;
		/*
		 * We use temp here to replace a, because otherwise a will be changed at
		 * the end of this while loop, which won't be able for future use.
		 */
		for (; temp != 0; temp = temp >> 1) {
			count += temp & 1;
		}
		return count;
	}

	public static void printNextSmallest(int a) {
		if (a == 0) {
			System.out
					.println("Invalid input, please enter a number that is non-zero.");
		} else {
			long startTime = System.currentTimeMillis();
			int numOf1s = count1s(a);
			System.out.println("There are " + numOf1s + " 1s in " + a + ".");
			int smallest = a + 1;
			while (smallest > a) {
				int numOf1sformax = count1s(smallest);
				if (numOf1sformax == numOf1s)
					break;
				else
					smallest++;
			}
			long endTime = System.currentTimeMillis();
			System.out.println("The input number is " + a
					+ ", and its binary representation is "
					+ Integer.toBinaryString(a) + ".");
			System.out.println("The next smallest number of " + a + " is "
					+ smallest + ", \nand its binary representation is "
					+ Integer.toBinaryString(smallest)
					+ ", \nwhich has the same number of 1 bits.");
			long timeDuration = endTime - startTime;
			System.out.println("It took the machine " + timeDuration
					+ " milliseconds to find this next smallest number.");
		}
	}

	/*
	 * Notice that it's always very fast to find the next smallest number,
	 * because you only need to increment one by one and then compare, it makes
	 * sense that it does so. But if the input number is very small, it might
	 * take quite a while to find the next largest number, b/c we decrement the
	 * Integer.MAX_VALUE one by one and compare.
	 */

	public static void printNextLargest(int a) {
		if (a == 0) {
			System.out
					.println("\nInvalid input, please enter a number that is non-zero.");
		} else {
			long startTime = System.currentTimeMillis();
			int numOf1s = count1s(a);
			System.out.println("\nThere are " + numOf1s + " 1s in " + a + ".");
			int largest = Integer.MAX_VALUE;
			while (largest > a) {
				int numOf1sforlargest = count1s(largest);
				if (numOf1sforlargest == numOf1s)
					break;
				else
					largest--;
			}
			long endTime = System.currentTimeMillis();
			System.out.println("The input number is " + a
					+ ", and its binary representation is "
					+ Integer.toBinaryString(a) + ".");

			System.out.println("The next largest number of " + a + " is "
					+ largest + ", \nand its binary representation is "
					+ Integer.toBinaryString(largest)
					+ ", \nwhich has the same number of 1 bits.");
			long timeDuration = endTime - startTime;
			System.out.println("It took the machine " + timeDuration
					+ " milliseconds to find this next largest number.");
		}
	}

	public static void main(String args[]) {
		printNextSmallest(13948);
		printNextLargest(13948);
	}
}

