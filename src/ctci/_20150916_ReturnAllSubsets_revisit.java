package ctci;

import java.util.ArrayList;

/** Cracking 9.3: 
 * Write a method to return all subsets of a set. */

/** I had some thoughts about this problem, but didn't work it out.
 * So I copied the solution from Cracking word by word. 
 * 
 * I'm amazed at its using an ArrayList inside and ArrayList, this is really cool,
 * I thought of this, but didn't dare to write it. */

/** The algorithm here is:
 * case 1: there is no element in the set:
 * 		   the only subset is the empty set;
 * case 2: there is only one element in the set: {1}
 * 		   there are two subsets for the set: {}, {1};
 * case 3: there are two elements in the set: {1, 2}
 * 		   there are subsets as the following: {}, {1}, {2}, {1, 2}.
 * the above three cases are the base cases for the rest of the situations,
 * we will derive the rest of the situations from these three base cases. 
 * 
 * Consider 
 * case 4: there are three elements: {1, 2, 3},
 * 		   it has these subsets:{}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1, 2, 3},
 * take a closer look at this case, we'll find that we basically clone all the subsets of case 3 first,
 * then put the new element i.e. '3', into each of them, then combine them together, we can
 * get all the subsets of case 4.
 * 
 * details are as follows:
 * '3' insert into empty set;
 * '3' insert into {1} to get {1, 3}
 * '3' insert into {2} to get {2, 3}
 * '3' insert into {1, 2} to get {1, 2, 3}
 * 
 * then we combine the above four with the subsets of case 3, we can get all the subsets of case 4.
 * 
 *  In the same way, we can generalize this case to apply to the general situation. */

public class _20150916_ReturnAllSubsets_revisit {
	public static ArrayList<ArrayList<Integer>> getSubsets(
			ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {// base case, add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());// empty set
		} else {
			allsubsets = getSubsets(set, index + 1);/* recursion */
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	public static void main(String args[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.print(getSubsets(a, 0));
	}
}
