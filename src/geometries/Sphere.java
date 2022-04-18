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

public Sphere(Point center, double radius) {
	super();
	this.center = center;
	this.radius = radius;
}
  public List<Point> findIntsersections(Ray ray){

    List<Point> Sphere_Intsersections=null;
    Vector u=center.subtract(ray.getP0()) ;
    double tm=ray.getDir().dotProduct(u);
    double d=Math.sqrt(u.lengthSquared()-Math.pow(tm, 2));
    double th=Math.sqrt(Math.pow(radius,2)-Math.pow(tm, 2));
    Vector v1=ray.getDir().scale(tm+th);
    Vector v2=ray.getDir().scale(tm-th);
    Point p1=ray.getP0().add(v1);
    Point p2=ray.getP0().add(v2);
    Sphere_Intsersections.add(p1);
    Sphere_Intsersections.add(p2);
    return Sphere_Intsersections;
    }

}
