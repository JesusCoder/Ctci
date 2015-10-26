package ctci;

/* After trial and error, after single step debugging, I figured this out
 * all by myself, very excited!
 * Although this algorithm looks pretty simple, I need to organize the code
 * to make it really work, it takes time and single step debugging!*/

/* Cracking 1.5 
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the 
 * original string, your method should return the original string. */

public class _20150916_StringCompression_revisit {
	public static String strCompress (String s){
		/*Keep in mind to consider extreme situations!!!*/
		if(s.length() <= 0)
			return "Invaid string input, please enter a valid string.\n";

		String result = "" + s.charAt(0);
		int counter = 1;
		for(int i = 0; i < s.length()-1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				counter++;
			}
			else {
				result = result + counter;
				result = result + s.charAt(i+1);
				counter = 1;
			}
		}
		result = result + counter;
		if(result.length() >= s.length())
			result = s;
		return result;
	}

	public static void main(String args[]){
		String s0 = "aaab";
		/*This is a very important test case: "aaab"
		 *after compression, it will become a3b1, its length actually
		 *equals the same length of the original string, so my function
		 *will just print out the original string, this meets exactly the problem
		 *requirement.*/
		System.out.println(strCompress(s0));
	}
}
