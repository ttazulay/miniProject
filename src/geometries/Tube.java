package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Tube extends Geometry {

	Ray axisRay;
	double radius;
	
	public Tube(Ray axisRay, double radius) {
		this.axisRay = axisRay;
		this.radius = radius;}
	
	@Override
	public Vector getNormal(Point p) {
		double t = (axisRay.getDir()).dotProduct(p.subtract(axisRay.getP0())); 
		if (t != 0) //in case the point is not across the ray point
		{
			Point center = axisRay.getP0().add(axisRay.getDir().scale(t));
			return p.subtract(center).normalize();
		} 
		else // in case the point is across the ray point
			return p.subtract(axisRay.getP0()).normalize();
	}

	public List<GeoPoint> findGeoIntersections (Ray ray){
		return findGeoIntersectionsHelper  (ray);
	}
	protected List<GeoPoint> findGeoIntersectionsHelper  (Ray ray){
		return null;
	}
}
