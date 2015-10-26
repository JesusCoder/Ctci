package ctci;

import java.util.Hashtable;

/* Cracking 1.1: 
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures? */


/* Afer checking the solution, I found that I was not thinking in an all-round way, 
 * I need to ask in the first place, that if this problem is asking about ASCII chars or Unicode chars,
 * because ASCII code has only 256 unique characters while Unicode has 65536 unique characters. 
 * Then we need to check if the length of the string is shorter than 256 or 65536, because, after all, 
 * you cannot have 280 unique characters if there are total 256 unique characters from the dictionary. */

public class _20150916_IsUniqueChar_revisit {

	/* First, I used additional data structures to solve this: 
	 * I'm very excited that I coded, debugged and finished this small program all by myself in 10 mins.
	 * Cool! I love this feeling!*/

	/* Use HashTable to implement this: 
	 * put each character into the HashTable, before putting every 
	 * element into it, compare if there is already a same one in the HashTable,
	 * if there is, return false, directly. */
	public static boolean isUnique(String s){
		Hashtable<Integer, Character> charHashtable = new Hashtable();

		for(int i = 0; i < s.length(); i++){
			if(charHashtable.contains(s.charAt(i)))
				/* Hashtable.contains() methods checks if it contains the VALUES
				 * rather than the keys, keep this in mind! */
				return false;
			else
				charHashtable.put(i, s.charAt(i));
		}
		return true;
	}

	/* Same problem, but this time, no additional data structures are used. */
	/* Two for loops to solve this problem, I coded and finished this mini-program all
	 * by myself in less than 5 mins, very excited about this! */
	/* This algorithm is very inefficient, but in order to meet the requirement that no
	 * additional data structures used.
	 * I traversed thru this string twice, each time compare the rest of the characters with one character,
	 * to see if there's any duplicate. */

	/* Actually this turned out to be really not optimal solution. The one that provided by the Cracking book
	 * is that you use an boolean value array to store the info that if this char is unique or not in the array,
	 * if it's not, then directly return false. 
	 * 
	 * I'll implement this in another .java file. */

	/* Also, I need to ask in the first place, that if this problem is asking about ASCII chars or Unicode chars,
	 * because ASCII code has only 256 unique characters while Unicode has 65536 unique characters. 
	 * Then we need to check if the length of the string is shorter than 256 or 65536, because, after all, you cannot
	 * have 280 unique characters if there are total 256 unique characters from the dictionary. */

	public static boolean isUnique_2nd_algorithm(String s){
		for( int i = 0; i < s.length(); i++){
			char temp = s.charAt(i);
			for( int j = 0; j < s.length(); j++){
				if(s.charAt(j) == temp && i != j)
					return false;
			}
		}
		return true;
	}
	
	/* This is the solution from the Cracking book: 

	 * I need to ask in the first place, that if this problem is asking about ASCII chars or 
	 * Unicode chars, because ASCII code has only 256 unique characters while Unicode has 65536 
	 * unique characters. 
	 * Then we need to check if the length of the string is shorter than 256 or 65536, because, after all, 
	 * you cannot have 280 unique characters if there are total 256 unique characters from the dictionary. 
	 * 
	 * Then use an array of boolean values to hold the result if any of the chars in the string had 
	 * appeared already, if so, return directly. */

	/* It's not easy to implement this algorithm, however tiny it is. See comments in the code. */
	public static boolean isUnique_From_CTCI_Official_solution(String s){
		if(s.length() > 256)
			/* We assume this problem is asking about ASCII code rather than Unicode. */
			return false;
		else
		{
			boolean [] char_set = new boolean[256];
/* Here's the first trick: I must set the range of the boolean array to 256, b/c we'll use the ASCII value of each
 * character as index, its maximum value is 256. */
			char_set[0] = true;//initialize this array.

			for(int i = 1; i < s.length(); i++){
				int value = s.charAt(i);/*Here's the second trick, what we need is the numeric value of this character,
				namely its ASCII value. */
				if(char_set[value])
					return false;
				else
					char_set[value] = true;
			}
		}
		return true;
	}


	public static void main (String args[]){
		String s = "Steve Sun.";	
		System.out.println(isUnique(s));
	}
}