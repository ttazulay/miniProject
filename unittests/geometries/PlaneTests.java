/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for geometries.Plane class
 * @author Rachel Davis & Ester Shmuel
 */
class PlaneTests {

	/**
	 * Test method for {@link geometries.Plane#getNormal()}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============

				// TC01: There is a simple single test here
				Plane pl = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
				double sqrt3 = Math.sqrt(1d / 3); // Normalizing the vector components
				// Two opposite sides of the vector must be checked:
				assertTrue( new Vector(sqrt3, sqrt3, sqrt3).equals(pl.getNormal(new Point(0, 0, 1)))
						|| new Vector(-1 * sqrt3, -1 * sqrt3, -1 * sqrt3).equals(pl.getNormal(new Point(0, 0, 1))),"Not a correct normal to create a plane");
			
	}
}


