/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Triangle;
import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for geometries.Triangle class
 * @author Rachel Davis & Ester Shmuel
 */
class TriangleTests {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
				// TC01: There is a simple single test here
				Triangle triangle = new Triangle(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));
				double sqrt3 = Math.sqrt(1d / 3); // Normalizing the vector components
				assertTrue(	new Vector(sqrt3, sqrt3, sqrt3).equals(triangle.getNormal(new Point(0, 0, 1)))  
						  || new Vector(-1 * sqrt3, -1 * sqrt3, -1 * sqrt3).equals(triangle.getNormal(new Point(0, 0, 1))),"Not a correct normal for the Triangle");
			}
	}


