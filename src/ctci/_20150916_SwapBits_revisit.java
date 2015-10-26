package ctci;

/* Cracking 5.4:
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g. bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on. */

/* I figured this algorithm out all by myself! Cool! */

/* My algorithm:
 * First left shit one bit to get all the odd bits are correct, then we AND this number with 10101010
 * to clear all the even bits, (i.e. to set all the even bits to zero);
 * Second, right shit one bit to get all the even bits are correct, then we AND this number with 01010101
 * to clear all the odd bits, (i.e. to set all the odd bits to zero);
 * Finally, we OR these two numbers to get the final result! */

public class _20150916_SwapBits_revisit {
	public static void swapbits(int a){
		long oddBitRightWithWrongEvenbit = a << 1;
		long oddBitRightWithRightEvenbit = (oddBitRightWithWrongEvenbit & 0xaaaaaaaa);
		/* Must be careful with the number format here, what I used on my scratch paper is 10101010 to
		 * clear the wrong even bit, but to put them into Java code, I should use hex format number, which
		 * is 0xa! */
		long evenBitRightWithWrongOddbit = a >> 1;
		long evenBitRightWithRightOddbit = (evenBitRightWithWrongOddbit & 0x55555555);
		
		long result = (evenBitRightWithRightOddbit | oddBitRightWithRightEvenbit );
		
		System.out.println(result);
	}
	
	public static void main(String args[]){
		swapbits(173);		
	}
}
/* A couple test cases:
 * 0 -> 0
 * 1 -> 2
 * 2 -> 1
 * 3 -> 3
 * 4 -> 8
 * 5 -> 10
 * 6 -> 9
 * 173 -> 94
 */
