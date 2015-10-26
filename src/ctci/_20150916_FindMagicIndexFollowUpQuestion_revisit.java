package ctci;

/* Cracking 9.3:
 * Follow up question:
 * What if the values are not distinct? */

/* I wrote my own algorithm, basically the same one as to the original question,
 * Cracking used binary search. I didn't really read it. */

public class _20150916_FindMagicIndexFollowUpQuestion_revisit {
	public static void findMagic(int a[]) {
		int i = 0;
		while (i < a.length) {
			if (a[i] == i) {
				System.out.println("The number " + i
						+ " magic index in this array is " + i + ".");
				i++;
			} else
				i++;
		}
		System.out.println("There's no more magic index in this array.");
	}

	public static void main(String args[]) {
		int[] a = { 0, 1, 1, 1, 4, 4, 4, 7 };
		findMagic(a);
	}
}
