/**
 * 
 */

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import geometries.Tube;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Unit tests for geometries.Tube class
 * @author Rachel Davis & Ester Shmuel
 */
class TubeTest {

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		Vector vec = new Vector(1, 1, 1);
		Point pt = new Point(2, 2, 2);
		Ray ray = new Ray( pt,vec);
		Tube tube = new Tube(ray, 5);
		// ============ Equivalence Partitions Tests ==============
        // TC01: Wrong normal calculation (in case the point is not across the ray.p0)
		assertEquals("getNormal() - does not work correctly",new Vector(Math.sqrt(1/2d),-1 * Math.sqrt(1/2d),0), tube.getNormal(new Point(12,2,7))); 
		
		// =============== Boundary Values Tests ==================
		// TC01: Wrong normal calculation (in case the point is across the ray.p0)
		assertEquals("getNormal() - does not work correctly (Boundary test)",new Vector(Math.sqrt(1/2d),-1 * Math.sqrt(1/2d),0), tube.getNormal(new Point(7, -3, 2)));

	}

}
