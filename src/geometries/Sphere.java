package geometries;
import java.lang.Math;
import java.util.List;

import primitives.*;

import static primitives.Util.alignZero;

public class Sphere extends Geometry {
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

      Point P1 = ray.getPoint(t1);
      Point P2 = ray.getPoint(t2);
      return List.of(P1, P2);
    }
    if (t1 > 0) {
      Point P1 = ray.getPoint(t1);
      return List.of(P1);
    }
    if (t2 > 0) {
      Point P2 = ray.getPoint(t2);
      return List.of(P2);
    }
    return null;
  }
  public List<GeoPoint> findGeoIntersections (Ray ray){
    return findGeoIntersectionsHelper  (ray);
  }
  protected List<GeoPoint> findGeoIntersectionsHelper  (Ray ray){
    return null;
  }
}

