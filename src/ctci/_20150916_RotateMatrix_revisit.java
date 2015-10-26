package ctci;

/* Cracking 1.6: 
 * Given an image represented by an N*N matrix, where each
 * pixel in the image is 4 bytes, write a method to rotate
 * the image by 90 degrees. Can you do it in place? */

/* This is awesome! I figured this out almost by myself! And it's almost exactly the same
 * as the Cracking solution! Praise the Lord! */

/* The algorithm here is to move the top line to the right side, move the right
 * side to the bottom, move the bottom to the left side and move the left side
 * to the top. 
 * 
 * To implement this, we actually ony need to traverse quarter of the pixels, (i.e. the top left
 * part of this square, then it will drive to make the remaining three parts get moved.), that's 
 * the idea! 
 * 
 * And one more thing to notice: we need to consider when the side is odd, when it's even, it's
 * perfectly fine, but when it's odd, we must rotate the middle row and middle column again ! */

public class _20150916_RotateMatrix_revisit {

	public static void rotateMatrix(int [][] matrix){
		int row = matrix.length;
		int col = row;

		/* So this is a square, row equals column. */
		int len = row;

		if(len%2 == 0){

			System.out.println("The initial input matrix is: ");
			for(int i = 0; i < len; i++){
				for(int j = 0; j < len; j++){
					System.out.print(matrix[i][j] + "\t");
					if(j == len - 1)
						System.out.println();
				}
			}

			/* Now len is an even number. */
			for(int i = 0; i < len/2; i++){
				for(int j = 0; j < len/2; j++){
					int temp1, temp2, temp3;
					/* Actually one temp is enough, as the Cracking solution did, but I used three. */
					temp1 = matrix[i][j];
					temp2 = matrix[j][len - i - 1];
					temp3 = matrix[len - i - 1][len - j - 1];

					matrix[i][j] = matrix[len - j - 1][i];
					matrix[j][len - i - 1] = temp1;
					matrix[len - i - 1][len - j - 1] = temp2;
					matrix[len - j - 1][i] = temp3;
				}
			}

			System.out.println("The output matrix is: ");
			for(int i = 0; i < len; i++){
				for(int j = 0; j < len; j++){
					System.out.print(matrix[i][j] + "\t");
					if(j == len - 1)
						System.out.println();
				}
			}
		}
		else /* len is an odd number, we need to deal with the middle crossing. */
		{

			System.out.println("The initial input matrix is: ");
			for(int i = 0; i < len; i++){
				for(int j = 0; j < len; j++){
					System.out.print(matrix[i][j] + "\t");
					if(j == len - 1)
						System.out.println();
				}
			}

			/* Now len is an even number. */
			for(int i = 0; i < len/2; i++){
				for(int j = 0; j < len/2; j++){
					int temp1, temp2, temp3;
					temp1 = matrix[i][j];
					temp2 = matrix[j][len - i - 1];
					temp3 = matrix[len - i - 1][len - j - 1];

					matrix[i][j] = matrix[len - j - 1][i];
					matrix[j][len - i - 1] = temp1;
					matrix[len - i - 1][len - j - 1] = temp2;
					matrix[len - j - 1][i] = temp3;
				}
			}
			
			
			for( int i = 0; i < len/2; i++){
			int temp1, temp2, temp3;
			temp1 = matrix[i][len/2];
			temp2 = matrix[len/2][len - i -1];
			temp3 = matrix[len - i - 1][len/2];
			
			matrix[i][len/2] = matrix[len/2][i];
			matrix[len/2][len - i - 1] = temp1;
			matrix[len - i - 1][len/2] = temp2;
			matrix[len/2][i] = temp3;
			} 
			
			
			System.out.println("The output matrix is: ");
			for(int i = 0; i < len; i++){
				for(int j = 0; j < len; j++){
					System.out.print(matrix[i][j] + "\t");
					if(j == len - 1)
						System.out.println();
				}
			}
		}
	}

	public static void main(String args[]){
		int [][] matrix1 = {
				{1,  2,  3,  4,  5,  6 },
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18},
				{19, 20, 21, 22, 23, 24},
				{25, 26, 27, 28, 29, 30},
				{31, 32, 33, 34, 35, 36}
		};

		int [][] matrix2 = {
				{ 1,  2,  3,  4,  5},
				{ 6,  7,  8,  9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}
		};
		rotateMatrix(matrix1);
		rotateMatrix(matrix2);
	}
}
