package ctci;

//TODO: not working yet, needs to finish it.
public class _20150916_CountingSort_revisit {

	public static void countingSort(int a[]) {

		int b[];
		/* First, we find the max and min in this input array. */

		/*
		 * I got tricked here:After reading the solution online, I realized that
		 * counting sort applies to non-negative input only!
		 */
		int max = a[0], min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
			else if (min > a[i])
				min = a[i];
		}
		System.out.println("max = " + max + "; min = " + min + ".");

		/*
		 * Now we create a working array whose index starts from min and ends at
		 * max,and initialize all its elements to zero.
		 */
		int temp[] = new int[max - min + 1];
		for (int i : a)/*
						 * This way of initializing an array is amazingly
						 * concise and wonderful! I found it on Google. It's so
						 * powerful to
						 */

		/*
		 * But this one didn't work out, I got very frustrated and ran out of
		 * patience!Will need to go back and finish this some day later.
		 */
		{
			temp[i - min]++;
			// System.out.print("temp[" + i + "] = " + temp[i] + "; ");
		}
		System.out.println("\n");
		for (int i = 0; i < a.length; i++) {
			temp[a[i]] += 1;
			System.out.print("temp[a[" + i + "]] = " + temp[a[i]] + " ;");
		}

		System.out.println("\n");
		for (int i = 1; i < max; i++) {
			temp[i] = temp[i] + temp[i - 1];
			System.out.print("temp[" + i + "] = " + temp[i] + "; ");
		}
		System.out.println();

		int result[] = new int[a.length];
		for (int j = a.length - 1; j >= 0; j--) {
			result[temp[a[j]]] = a[j];
			temp[a[j]] = temp[a[j]] - 1;
		}

		System.out.println("\nAfter calling counting sort, the array becomes:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	public static void main(String args[]) {
		try {
			int a[] = { 12, 11, 8, 9, 10, 12, 9, 8, 11, 10 };
			countingSort(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
