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

  public List<GeoPoint> findGeoIntersections (Ray ray,double maxDistance){
    return findGeoIntersectionsHelper  (ray,maxDistance);
  }
  protected List<GeoPoint> findGeoIntersectionsHelper  (Ray ray,double maxDistance){
    Point P0 = ray.getP0();
    Vector v = ray.getDir();
    if (P0.equals(center)) {
      return List.of(new GeoPoint(this,center.add(v.scale(radius))));
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

    //Preventing the addition of a list that includes points that are farther from the ray head than the maximum distance
    boolean val1=alignZero(t1-maxDistance)<=0;
    boolean val2=alignZero(t2-maxDistance)<=0;

    if (t1 > 0 && t2 > 0 && val1 && val2) {

      Point P1 = ray.getPoint(t1);
      Point P2 = ray.getPoint(t2);

      return List.of(new GeoPoint(this,P1),new GeoPoint(this,P2));
    }
    if (t1 > 0&& val1) {
      Point P1 = ray.getPoint(t1);
      return List.of(new GeoPoint(this,P1));
    }
    if (t2 > 0&& val2) {
      Point P2 = ray.getPoint(t2);
      return List.of(new GeoPoint(this,P2));
    }
    return null;
  }
}

