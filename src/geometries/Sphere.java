package geometries;
import java.lang.Math;
import java.util.List;

import primitives.*;

public class Sphere implements Geometry {
 Point center;
 double radius;

 @Override
public Vector getNormal(Point p) {
	
		return (p.subtract(center)).normalize();
}

  public double getRadius() {
    return radius;
  }

  public Sphere(Point center, double radius) {
	super();
	this.center = center;
	this.radius = radius;
}
  public List<Point> findIntsersections(Ray ray) {

    List<Point> Sphere_Intsersections = null;
    Vector u = center.subtract(ray.getP0());
    double tm = ray.getDir().dotProduct(u);
    double d = Math.sqrt(u.lengthSquared() - Math.pow(tm, 2));
    if (d >= this.getRadius())
      return null;
    double th = Math.sqrt(Math.pow(radius, 2) - Math.pow(tm, 2));
    double t1 = tm + th;
    double t2 = tm - th;
    if (t1 > 0 && t2 > 0) {
      Vector v1 = ray.getDir().scale(t1);
      Vector v2 = ray.getDir().scale(t2);

      Point p1 = ray.getP0().add(v1);
      Point p2 = ray.getP0().add(v2);

      Sphere_Intsersections.add(p1);
      Sphere_Intsersections.add(p2);
      return Sphere_Intsersections;
    }
    if (t1 > 0 ) {
      Vector v1 = ray.getDir().scale(t1);
      Point p1 = ray.getP0().add(v1);
      Sphere_Intsersections.add(p1);
      return Sphere_Intsersections;
  }
    if ( t2 > 0) {
      Vector v2 = ray.getDir().scale(t2);
      Point p2 = ray.getP0().add(v2);
      Sphere_Intsersections.add(p2);
      return Sphere_Intsersections;
    }
    return null;
    }
}

