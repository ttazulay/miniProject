/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for geometries.Sphere class
 * @author Rachel Davis & Ester Shmuel
 */
class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: Wrong normal calculation
		Sphere sph = new Sphere(new Point(1, 1, 1), 5); // The equation for the sphere is: (x-1)^2 + (y-1)^2 + (z-1)^2
															// = 25
		// The vector is: (4,5,1) - (1,1,1) = (3,4,0) => After normalization: (3/5, 4/5,
		// 0)
		assertEquals( new Vector(3d / 5, 4d / 5, 0), sph.getNormal(new Point(4, 5, 1)),"Not a corrct normal for the Sphere");
		}

}
