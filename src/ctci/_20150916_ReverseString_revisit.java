package ctci;

/** Cracking 1.2: 
 * Implement a function void reverse (char*) in C or C++ 
 * which reverses a null-terminated string. 
 * 
 * Since my C program for this one didn't run, I'll implement it in Java. */

public class _20150916_ReverseString_revisit {

	public static void revStr(String s){
		int len = s.length() - 1;/* minus the null-string at the end of each string */
		char [] charArray = s.toCharArray();
		for(int i  = 0; i < len/2; i++){
			char temp;
			temp = charArray[i];
			charArray[i] = charArray[len - i];
			charArray[len - i] = temp;
		}
		System.out.println(charArray);
	}
	
	public static void main(String args[]){
		revStr("reverse");
	}
}

