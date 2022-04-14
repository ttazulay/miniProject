/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;


import geometries.Cylinder;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Unit tests for geometries.Cylinder class
 * @author Rachel Davis & Ester Shmuel
 */
class CylinderTests {

	/**
	 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point)}.
	 */
//@Test
	public void testGetNormal() {
		Vector vec = new Vector(1, 1, 1);
		Point pt = new Point(2, 2, 2);
		Ray ray = new Ray(pt,vec);
		Cylinder cyl = new Cylinder(ray, 5,10);
		
		// ============ Equivalence Partitions Tests ==============
        // TC01: Wrong normal calculation (in case the point is not across the ray.p0)
	
		assertEquals(new Vector(Math.sqrt(1/2d),-1 * Math.sqrt(1/2d),0), cyl.getNormal(new Point(12,2,7)),"getNormal() - does not work correctly");	

		        // TC04: Check when the point is in center of top cup
		        assertEquals(new Vector(0, 0, 1), cyl.getNormal(new Point(0, 0, 10))
		                ,"getNormal() faild - point is in center of top cup!");

		        // TC05: Check when the point is in center of under cup
		        assertEquals(new Vector(0, 0, 1), cyl.getNormal(new Point(0, 0, 1))
		                ,"getNormal() faild - point is in center of under cup!");
		    }

}



