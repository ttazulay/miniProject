package geometries;
import java.lang.Math;
import java.util.List;

import primitives.*;

import static primitives.Util.alignZero;

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

  /*  public List<Point> findIntsersections(Ray ray) {

      List<Point> Sphere_Intsersections = null;
      Vector u = ray.getP0().subtract(center);
      double tm = alignZero(ray.getDir().dotProduct(u));
      double d = alignZero(Math.sqrt(u.lengthSquared() - Math.pow(tm, 2)));
      if (d >= this.getRadius())
        return null;
      double th = alignZero(Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(tm, 2)));
      double t1 =alignZero(tm + th) ;
      double t2 = alignZero(tm - th);
      if (t1 > 0 && t2 > 0) {
      *//* Vector v1 = ray.getDir().scale(t1);
     Vector v2 = ray.getDir().scale(t2);

      Point p1 = ray.getP0().add(v1);
      Point p2 = ray.getP0().add(v2);
*//*
      Point p1 = ray.getPoint(t1);
      Point p2 = ray.getPoint(t2);
      Sphere_Intsersections.add(p1);
      Sphere_Intsersections.add(p2);
      return Sphere_Intsersections;
    }
    if (t1 > 0 ) {
//      Vector v1 = ray.getDir().scale(t1);
//      Point p1 = ray.getP0().add(v1);
      Point p1 = ray.getPoint(t1);
      Sphere_Intsersections.add(p1);
      return Sphere_Intsersections;
  }
    if ( t2 > 0) {
//      Vector v2 = ray.getDir().scale(t2);
//      Point p2 = ray.getP0().add(v2);
      Point p2 = ray.getPoint(t2);
      Sphere_Intsersections.add(p2);
      return Sphere_Intsersections;
    }
    return null;
    }*/
  @Override
  public List<Point> findIntsersections(Ray ray) {
    Point P0 = ray.getP0();
    Vector v = ray.getDir();
    if (P0.equals(center)) {
      return List.of(center.add(v.scale(radius)));
    }
    Vector U = center.subtract(P0);

    double tm = alignZero(U.dotProduct(v));
    double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm));

    // no intersections : the ray direction is above the sphere
    if (d >= radius) {
      return null;
    }

    double th = alignZero(Math.sqrt(radius * radius - d * d));
    double t1 = alignZero(tm - th);
    double t2 = alignZero(tm + th);

    if (t1 > 0 && t2 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
//            Point3D P2 = P0.add(v.scale(t2));
      Point P1 = ray.getPoint(t1);
      Point P2 = ray.getPoint(t2);
      return List.of(P1, P2);
    }
    if (t1 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
      Point P1 = ray.getPoint(t1);
      return List.of(P1);
    }
    if (t2 > 0) {
//            Point3D P2 = P0.add(v.scale(t2));
      Point P2 = ray.getPoint(t2);
      return List.of(P2);
    }
    return null;
  }
}

