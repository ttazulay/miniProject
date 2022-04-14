package geometries;
import primitives.Point;
import primitives.Vector;

public interface Geometry extends Intersectable  {
	
abstract public Vector getNormal(Point p);

}
