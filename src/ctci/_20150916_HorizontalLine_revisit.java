package ctci;

/* Cracking 5.8:
 * A monochrome screen is stored as a single array of bytes, allowing eight
 * consecutive pixels to be stored in one byte. The screen has width w, where
 * w is divisible by 8 (that is, no byte will be split across rows). The height
 * of the screen , of course, can be derived from the length of the array and
 * the width.
 * Implement a function
 * drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y)
 * which draws a horizontal line from (x1, y) to (x2, y).*/

/* I wrote my own algorithm which is very straightforward, the Cracking solution
 * uses a more efficient way to deal with this problem. */

public class _20150916_HorizontalLine_revisit {
	// byte[] screen: this means an array of type byte called screen, don't
	// confuse myself with this!
	// so screen is just an array!

	/*
	 * Some explanation for byte, this primitive data type in Java: byte: The
	 * byte data type is an 8-bit signed two's complement integer. It has a
	 * minimum value of -128 and a maximum value of 127 (inclusive). The byte
	 * data type can be useful for saving memory in large arrays, where the
	 * memory savings actually matters. They can also be used in place of int
	 * where their limits help to clarify your code; the fact that a variable's
	 * range is limited can serve as a form of documentation.
	 */

	public static void drawHorizontalLine(byte[] screen, int width, int x1,
			int x2, int y) {
		int height = screen.length / width;
		if (y >= height)
			System.out.println("Please enter a valid y coordinate.");
		else if (x1 > x2) {
			System.out
					.println("Please enter two valid x coordinates that x1 is not greater"
							+ "than x2.");
		} else if (x2 >= width) {
			System.out
					.println("Please enter a valid x coordinate that is less than "
							+ width + ".");
		} else {
			for (int i = (y * width + x1); i <= (y * width + x2); i++) {
				screen[i] = 1;
			}
			for (int i = 0; i < screen.length; i++) {
				System.out.print(screen[i] + " ");
				if ((i + 1) % 16 == 0) {
					System.out.println();
				}
			}
		}
	}

	public static void main(String args[]) {
		byte[] screen = { 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, };
		drawHorizontalLine(screen, 16, 3, 12, 5);
	}
}
