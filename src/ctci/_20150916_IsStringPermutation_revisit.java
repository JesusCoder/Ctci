package ctci;

import java.util.*;

/* Cracking 1.3: 
 * Given two strings, write a method to decide if one is a permutation of the other. */


/* The very first algorithm that came into my mind is to utilize Hashtable, this is awesome!
 * Also, I realized the parameters for this Hashtable should be Hashtable<Character, Integer>,
 * this is also correct! Good job! 
 * 
 * But I didn't make the code run due to the ConcurrentModificationException that happened to my code. 
 * 
 * I was very frustrated that then looked for help online, and then got some help and eventually made the
 * program work! */

public class _20150916_IsStringPermutation_revisit {

	public static boolean isStrPermutation(String s1, String s2){
		/* First check if the two strings have the same length, if not, return false immediately. */
		if(s1.length() != s2.length())
			return false;
		else
			/* Create two Hashtables, one for each string. Use its character type as key 
			 * while use its frequency as value. */
		{
			Hashtable<Character, Integer> str1Hashtable = new Hashtable();
			Hashtable<Character, Integer> str2Hashtable = new Hashtable();

			/* Traversing each string, to each character, if it's new, then put it into Hashtable,
			 * if not, just increase its frequency. 
			 * 
			 * After creating these two Hashtables, try to see if the frequency of the same characters equal,
			 * if equal, then these two strings are permutations of each other, otherwise not. */

			char [] charArray1 = s1.toCharArray();
			/* I didn't know there's such a method for String class, it's called .toCharArray(),
			 * this method converts a string into an array of chars, it's awesome! */
			char [] charArray2 = s2.toCharArray();

			for( char c : charArray1){
				int counter = 1;
				if(str1Hashtable.containsKey(c))
					/* The tricky part here is (it's actually due to the fact that I'm not 
					 * proficient enough with the API), 
					 * there're three Hashtable.contains() methods:
					 * 
					 * one is Hashtable.contains();
					 * second is Hashtable.containsKey();
					 * third is Hashtable.containsValue();
					 * 
					 * I'd better specify I want to test if there is key or value!!!*/
				{
					counter = str1Hashtable.get(c);
					counter++;
				}
				str1Hashtable.put(c, counter);
			}
//			System.out.println(str1Hashtable.values());

			/* Do the same thing for str2! */
			for(char c : charArray2){
				int counter = 1;
				if(str2Hashtable.containsKey(c)){
					counter = str2Hashtable.get(c);
					counter++;
				}
				str2Hashtable.put(c, counter);
			}
	//		System.out.println(str2Hashtable.values());
			
			
			if(str1Hashtable.size() != str2Hashtable.size())
				return false;

			
			for( char key1 : str1Hashtable.keySet()){
				/* Here is where I originally failed to make it run, it popped out ConcurrentModificationException,
				 * then, I copied this line of code from online. 
				 * 
				 * This is actually a very useful line, instead of my using two for loops,
				 * it uses just one for loop, then inside this for loop, 
				 * it first checks if the str2Hashtable contains this KEY or not,
				 * if not, return false directly;
				 * then if it contains this KEY, then we continue to check if the frequency in str2Hashtable
				 * is equal to that in str1Hashtable. */
				if(!str2Hashtable.containsKey(key1) || str2Hashtable.get(key1) != str1Hashtable.get(key1))
					return false;
			}
		}
		return true;
	}

	
	public static void main(String args[]){
		String s1 = "..//{}[] jason ! {";
		String s2 = "{..[]}// ! { ajnos";
		System.out.println(isStrPermutation(s1, s2));
	}
}

