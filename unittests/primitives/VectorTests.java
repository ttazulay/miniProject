/**
 * 
 */


import static org.junit.jupiter.api.Assertions.*;

import primitives.*;



import org.junit.jupiter.api.Test;

import static java.lang.System.out;

import static primitives.Util.*;
/**
 * Unit tests for primitives.Vector class
 * @author Rachel Davis & Ester Shmuel

 */
class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	void testAddVector() {
		  Vector v1 = new Vector(1, 2, 3);

	        // ============ Equivalence Partitions Tests ==============
	        Vector v2 = new Vector(0, 3, -2);
	        Vector vr = v1.add(v2);

	        // TC01: Test that the function add adds the vector in the right way
	        // for simplicity)
	        assertEquals( vr,new Vector(1,5,1),"add()-ERROR: Point + Vector does not work correctly");


	}

	/**
	 * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
	 */
	@Test
	void testSubtractVector() {
		  Vector v1 = new Vector(1, 2, 3);

	        // ============ Equivalence Partitions Tests ==============
	        Vector v2 = new Vector(0, 3, -2);
	        Vector vr = v1.subtract(v2);

	        // TC01: Test that the function add adds the vector in the right way
	        // for simplicity)
	        assertEquals( vr,new Vector(1,-1,5),"subtract()-ERROR: Point - Vector does not work correctly");

	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	void testScale() {
		 Vector v1 = new Vector(1, 2, 3);

	        // ============ Equivalence Partitions Tests ==============
	
	        Vector vr = v1.scale(2);
	        // TC01: Test that the function scale works the vector in the right way
	        // for simplicity)
	        assertEquals( vr,new Vector(2,4,6),"scale() wrong result of a vector");
	       
	        // =============== Boundary Values Tests ==================
	        // TC11: test zero scale for the scale function
	        assertThrows("scale()   does not throw an exception",
	                IllegalArgumentException.class, () -> v1.scale(0));

	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	void testDotProduct() {
		 Vector v1 = new Vector(1, 2, 3);
		 Vector v2 = new Vector(0, 3, -2);
		 Vector v3=new Vector(-2, -4, -6);
	     double vr1 = v1.dotProduct(v2);
	     double vr2 = v1.dotProduct(v3);
		assertTrue(isZero(vr1),"ERROR: dotProduct() for orthogonal vectors is not zero");
	    assertTrue(isZero(vr2+28),"ERROR: dotProduct() wrong value");}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	void testCrossProduct() {
	
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals( v1.length() * v2.length(), vr.length(), 0.00001,"crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue( isZero(vr.dotProduct(v1)),"crossProduct() result is not orthogonal to 1st operand");
        assertTrue( isZero(vr.dotProduct(v2)),"crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v3),"crossProduct() for parallel vectors does not throw an exception");

	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	void testLengthSquared() {
		 // ============ Equivalence Partitions Tests ==============
		// TC01: Test that length Square of the vector is proper 
		Vector v1 = new Vector(1, 2, 3);
		assertTrue( isZero(v1.lengthSquared() - 14),"ERROR: lengthSquared() wrong value");
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	void testLength() {
		// ============ Equivalence Partitions Tests ==============
				// TC01: Test that length of the vector is proper 
		assertTrue( isZero((new Vector(0, 3, 4).length() - 5)),"ERROR: length() wrong value");

	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	void testNormalize() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: Test that vector is normelized properly 

		Vector v = new Vector(1, 2, 3);
		Vector u = v.normalize();
		assertTrue( isZero(u.length() - 1),"ERROR: the normalized vector is not a unit vector");
	}

}
