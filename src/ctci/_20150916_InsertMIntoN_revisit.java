package ctci;

/* Cracking 5.1: 
 * 
 * I figured this out all by myself! 
 * And it's almost exactly the same with the Cracking solution! So excited! */

/* The major problem here is to clear the i to j bits in N, to do this, we need to create a mask
 * which has all 1s except for i to j bits are all 0s.
 * To create this mask, I'll need two masks and then OR them to get it. */

public class _20150916_InsertMIntoN_revisit {
	public static void insert(int N, int M, int i, int j) {

		int mask1 = ~((1 << (j + 1)) - 1);// Create a mask that is like this:
											// 1110000000
		// System.out.println(mask1);
		int mask2 = ((1 << i) - 1);// create a mask that is like this:
									// 0000000111
		// System.out.println(mask2);
		int mask = mask1 | mask2;// OR these two mask, I get something like:
									// 1110000111
		// System.out.println(mask);
		int clearitojbits = (N & mask);// use this mask to clear the i to j bits
										// of N
		// System.out.println(clearitojbits);
		int leftShiftM = M << i;// to line M with N from i to j bits
		// System.out.println(leftShiftM);
		int result = clearitojbits | leftShiftM;// OR them to get the final
												// result
		// System.out.println(result);

		String N_bin = Integer.toBinaryString(N);
		String M_bin = Integer.toBinaryString(M);
		String result_bin = Integer.toBinaryString(result);
		System.out.println("The input " + N_bin + " and " + M_bin
				+ " with index " + i + " and " + j + " produces result: "
				+ result_bin + ".");
	}

	public static void main(String args[]) {
		insert(1024, 19, 2, 6);
	}
}
