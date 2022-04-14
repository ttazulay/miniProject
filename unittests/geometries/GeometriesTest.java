package unittests;

import geometries.Geometries;
import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import org.junit.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.*;

public class GeometriesTest {

    @Test
    public void add() {
        Geometries geometries = new Geometries();
        //TC1: adding no geometry to empty list
        geometries.add();
        assertEquals("Wrong number of geometries", 0, geometries.getInterList().size());

        //TC2: adding geometries
        geometries.add(
                new Sphere(new Point(1, 0, 0), 1d),
                new Plane(new Point(0, 0, 2), new Point(2, 1, 2), new Point(2, 2, 2)),
                new Plane(new Point(0, 0, -2), new Point(2, 1, -2), new Point(2, 2, -2)));
        assertEquals("Wrong number of geometries", 3, geometries.getInterList().size());
    }

    @Test
    public void findIntsersections() {

        Geometries geometries = new Geometries();
        List<Intersectable.GeoPoint> result;
        //TC1: the list is empty
        result = geometries.findIntsersections(new Ray(new Vector(1, 0, 0), new Point(6, 6, 6)));

        assertEquals("Wrong number of points", 0, result.size());


        geometries.add(
                new Sphere(new Point(1, 0, 0), 1d),
                new Plane(new Point(0, 0, 2), new Point(2, 1, 2), new Point(2, 2, 2)),
                new Plane(new Point(0, 0, -2), new Point(2, 1, -2), new Point(2, 2, -2)));

        //TC2: there is nointersections at all
        result = geometries.findIntsersections(new Ray(new Vector(1, 0, 0), new Point(6, 6, 6)));
        assertEquals("Wrong number of points", 0, result.size());

        //TC3:only one geometry get intersected
        result = geometries.findIntsersections(new Ray(new Vector(0,0, -1), new Point(0, 6, 1)));
        assertEquals("Wrong number of points", 1, result.size());

        //TC4: several geometriesget intersected (but not all of them)
        result = geometries.findIntsersections(new Ray(new Vector(0,0, -1), new Point(0, 6, 4)));
        assertEquals("Wrong number of points", 2, result.size());

        //TC5: all geometries get intersected
        result = geometries.findIntsersections(new Ray(new Vector(0,0, -1), new Point(0.5, 0.5, 4)));
        assertEquals("Wrong number of points", 4, result.size());
    }
}