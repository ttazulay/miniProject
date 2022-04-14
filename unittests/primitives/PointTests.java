/**
 * 
 */
package unittests.primitives;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for primitives.Point class
 * @author Rachel Davis & Ester Shmuel
 *
 */
class PointTests {

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 */
	@Test
	void testSubtract() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: Test that point is properly subtract 
		Point p1 = new Point(1, 2, 3);
		Point p2=new Point(-1, -2, -3);
		Vector pr=p1.subtract(p2);
        assertEquals("ERROR: Point - Vector does not work correctly",pr,new Vector(2,4,6) );

	}

	/**
	 * Test method for {@link primitives.Point#add(primitives.Vector)}.
	 */
	@Test
	void testAdd() {
		// ============ Equivalence Partitions Tests ==============
	    // TC01: Test that point is properly added 
		Point p1 = new Point(1, 2, 3);
		Vector p2=new Vector(-1, -2, -3);
		Point pr=p1.add(p2);
        assertEquals("ERROR: Point + Vector does not work correctly",pr,new Point(0,0,0) );

	}

	/**
	 * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
	 */
	@Test
	void testDistanceSquared() {
		 // ============ Equivalence Partitions Tests ==============
		// TC01: Test that distance Square between the points is proper 
		Point p1 = new Point(4, 6, 3);
		Point p2 = new Point(2, 3, 4);
		double r=p1.distanceSquared(p2);
		assertEquals("ERROR: DistanceSquared() returns a wrong value",r,14,0.00001);
	}

	/**
	 * Test method for {@link primitives.Point#distance(primitives.Point)}.
	 */
	@Test
	void testDistance() {
		// ============ Equivalence Partitions Tests ==============
	    // TC01: Test that the distance between the points is proper 
		Point p1 = new Point(4, 6, 3);
		Point p2 = new Point(2, 3, 4);
		double r=p1.distance(p2);
		double d=Math.sqrt(14.0);
		assertEquals("ERROR: Distance returns a wrong value",r,d,0.00001);
		
	}

}
