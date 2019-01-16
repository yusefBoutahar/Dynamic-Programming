package min_cost_polygon;

import java.awt.Point;

public class Recursivo {
	
	public static double mTC(Point [] points, int i, int j) { 
	
	   // There must be at least three points between i and j 
	   // (including i and j) 
	   if (j < i+2) 
	      return 0; 
	  
	   // Initialize result as infinite 
	   double res = Integer.MAX_VALUE; 
	  
	   // Find minimum triangulation by considering all 
	   for (int k=i+1; k<j; k++) 
	        res = Math.min(res, (mTC(points, i, k) + mTC(points, k, j) + 
	                        cost(points, i, k, j))); 
	   return  res; 
	}
	
	private static double cost(Point points[], int i, int j, int k) { 
		
	    Point p1 = points[i], p2 = points[j], p3 = points[k]; 
	    return dist(p1, p2) + dist(p2, p3) + dist(p3, p1); 
	} 
	
	private static double dist(Point p1, Point p2) 
	{ 
	    return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + 
	                (p1.y - p2.y)*(p1.y - p2.y)); 
	} 
	
	
	

}
