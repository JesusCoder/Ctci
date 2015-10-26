package ctci;


/* Cracking 5.4:
 * Explain what the following code does:
 * ((n & (n - 1)) == 0) */

/* I got this one correctly!
 * This code simply tests if n is a number that is 2 to the power of something. */

public class _20150916_ExplainCode_revisit {
	public static void testNum(int a) {
		if (((a & (a - 1)) == 0))
			System.out.println(a + " is a number that is the power of 2.");
		else
			System.out.println(a + " is NOT a number that is the power of 2.");
	}

	public static void main(String args[]) {
		testNum(16);
		testNum(15);
	}
}
