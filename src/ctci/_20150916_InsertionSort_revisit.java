package ctci;

/*Using two for loops to implement this. 
 *I figured this out all by myself, very excited!
 *There's frustration moment, but I made it, I didn't look for solutions online!
 *Excited!*/

/*I don't even need to consider special cases like when the input array has 
 *0 or 1 elements, it works perfectly fine with these situations too: it simply dosn't
 *enter the for loop!*/

public class _20150916_InsertionSort_revisit {
	public static int[] is(int a[]){
		for(int j = 1; j < a.length; j++)
			for(int i = j - 1; i >= 0; i--){
				/*The juicy part is right here, you need
				 *to figure out to use two counters, one is dependent on
				 *the other, and then inside this innermost loop, use only
				 *one counter to represent both array elements that are to
				 *be compared.*/
				if(a[i+1] < a[i]){
					int temp;
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		return a;
	}
	public static void main(String args[]){

		int a [] = {24, 13};
		System.out.println("The original input array:");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
		is(a);
		System.out.println("After calling insertion sort:");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
