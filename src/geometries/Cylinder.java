package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

public class Cylinder extends Tube {

	double height;
	public Cylinder(Ray axisRay, double radius,double height_) {
		super(axisRay, radius);
		height=height_;
	}

/**
 * the function gets 2 points and it creats a new vector 
 * the new vector is multipled by the dir=the direction vector
 */
    @Override
    public Vector getNormal(Point p){
        Vector dir = axisRay.getDir();
        Point p0 = axisRay.getP0();
        try {
            var t = dir.dotProduct(p.subtract(p0));
            if (Util.isZero(t) || Util.isZero(t - height))
                return dir;
            var  o = p0.add(dir.scale(t));
            return p.subtract(o).normalize();
        } catch (Exception e) {
            return dir;   //return the direction vector
        }
    }
  public List<Point> findIntsersections(Ray ray){
    return null;
    }

}
