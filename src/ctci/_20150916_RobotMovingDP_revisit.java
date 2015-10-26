package ctci;


/* Cracking 9.2:
 * This problem is also from 加州鬼混 Day 9:
 * Imagine a robot sitting on the upper left corner 
 * of an X by Y grid. The robot can only move in 
 * two directions: right and down. 
 * How many possible paths are there for the robot 
 * go from (0, 0) to (X, Y)? 
 * */

public class _20150916_RobotMovingDP_revisit {
	/*
	 * This is actually a very easy problem: we name path(x, y) as a method to
	 * return how many possible paths there are from (0, 0) to arrive at (x, y),
	 * then it's just to find out its recursion formula. It turned out to be
	 * there are only two possible ways: it either comes from the top or from
	 * the left, so it either comes from (x-1, y) or from (x, y-1).
	 * 
	 * So, the possible ways to arrive at (x, y) is these two possibilities
	 * combined. Then we get path(x, y) = path(x-1, y) + path(x, y-1). This is
	 * just our recursion formula for this problem.
	 * 
	 * Now we need to figure out when is the terminating condition, noticing
	 * that if either side (x or y) reaches to the edge (the topmost line or the
	 * leftmost line), then there's no other possible ways to go but only one
	 * way (because it can only go in two directions). So, our terminating
	 * condition is that either x == 0 or y == 0, then this program is out!
	 */
	public static int path(int x, int y) {

		if (x == 0 || y == 0)
			return 1;
		else
			return path(x - 1, y) + path(x, y - 1);
	}

	public static void main(String[] args) {
		System.out.println(path(5, 3));
	}
}
