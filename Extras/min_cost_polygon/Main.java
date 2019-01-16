package min_cost_polygon;

import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		
	    Point[] points = {new Point(900,10000),
	    		new Point(10000,10000),
	    		new Point(20000,10000), 
	    		new Point(20000,10000), 
	    		new Point(40000,10000), 
	    		new Point(0,1000),
	    		new Point(0,1000),
	    		new Point(0,1000),
	    		new Point(0,1000),
	    		new Point(0,1000),
	    		new Point(0,1000),
	    		new Point(0,1000),
	    		new Point(0,1000),}; 

	    int n = points.length;
	    
	    System.out.println(Recursivo.mTC(points, 0, n-1));
	    System.out.println(Memoization.mTC(points, 0, n-1));

	}

}
