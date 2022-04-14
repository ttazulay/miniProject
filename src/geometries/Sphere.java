package geometries;
import java.lang.Math;
import primitives.Point;
import primitives.Vector;

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
    double d=math.sqrt(u.lengthSquared()-Math.pow(tm, 2));
    double th=math.sqrt(Math.pow(radius,2)-Math.pow(tm, 2));
    point p1=new point(ray.getP0().add(ray.getDir().scale(tm+th)));
    point p2=new point(ray.getP0().add(ray.getDir().scale(tm-th)));
    Sphere_Intsersections.add(p1);
    Sphere_Intsersections.add(p2);
    return Sphere_Intsersections;
    } 
}
