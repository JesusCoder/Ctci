package ctci;

/* Cracking 9.3:
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i]
 * = i. Given a sorted array of distinct integers, write a method to find a magic
 * index, if one exists, in array A. */

/* I wrote my own algorithm, basically brute force, but the cost isn't that large,
 * Cracking used binary search. I didn't really read it. */

public class _20150916_FindMagicIndex_revisit {
	public static void findMagic(int a[]) {
		int i = 0;
		while (i < a.length) {
			if (a[i] == i) {
				System.out.println("The number " + i + " magic index in "
						+ "this array is " + i + ".");
				i++;
			} else
				i++;
		}
		System.out.println("There's no more magic index in this array.");

	}

	public static void main(String args[]) {
		int[] a = { -10, 0, 2, 3, 4, 5, 9, 8, 8, 10, 10 };
		findMagic(a);
	}
}
