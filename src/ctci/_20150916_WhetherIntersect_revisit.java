package ctci;

/** Cracking 7.3:
 * Given two lines on a Cartesian plane, determine whether the two lines would intersect. */

/** As the Cracking solution suggests, there'are lots of ambiguities in this problem that we should ask
 * the interviewer:
 * 1. If two lines are the same (same slope and y-intercept), are they considered intersect?
 * 2. Then we need to decide which data structures to use. */


/** I did an awesome job in solving this problem! It's a very fruitful, happy and little struggling process. 
 * 
 * I decided to create my own class line, then in defining its constructors, I encountered difficulties in how 
 * to represent a dot (point) in the grid with two coordinates, a two-dimensional array is not a good choice, actually
 * it's not a right data structure at all to apply here, b/c 2-d array only means that it has two indices, but the value
 * contained in this array is just one value per element!
 * Then I quickly decided to create another class called point! 
 * 
 * I really enjoy this feeling! 
 * 
 * After debugging, I realized that I need to consider the situation when the line has a slope of zero which is
 * undefined in Java as the denominator cannot be zero in common sense, then I decided to assign it to zero manually
 * to deal with this exception! Cool! I made it in less than 15 mins! */

public class _20150916_WhetherIntersect_revisit {
	
	public static void isIntersect(line line1, line line2){
		if(line1.slope == line2.slope)//if slopes equal, then they are parallel, they won't intersect
		{
			System.out.println("These two lines won't intersect in Cartesian plane.");
		}
		else
			System.out.println("These two lines intersect in Carsesian plane.");
		System.out.println("The first line's slope is " + line1.slope + " " +
				"and the second line's slope is " + line2.slope + ".");
	}
	
	public static void main(String args[]){
		point point1 = new point(1, 2);
		point point2 = new point(2, 4);
		point point3 = new point(3, 5);
		point point4 = new point(3, 9);
		line line1 = new line(point1, point2);
		line line2 = new line(point3, point4);
		isIntersect(line1, line2);
	}
	
}

class line{
	int slope;
	public line(point a, point b){
		if(b.y - a.y == 0)//this is a horizontal line which slope is zero
			slope = 0;
		else if(b.x - a.x == 0)//this is a vertical line which slope is infinity
			slope = Integer.MAX_VALUE;
		else
		slope = (b.y - a.y)/(b.x - a.x);			
	}
}

class point{
	int x;
	int y;
	public point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
