package primitives;

import java.util.List;
import java.util.Objects;
import geometries.Intersectable.GeoPoint;

public class Ray {

	private Point p0;
	Vector dir;
	
	/**
	 * this ctor gets a Point & a Vector (the ctor makes sure the vector is normelized
	 * @param p0
	 * @param vec
	 */
	public Ray(Point p0, Vector vec) {
		this.p0 = p0;
		this.dir = vec.normalize();
	}

	/**
	 * @return the p0
	 */
	public Point getP0() {return p0;}
	/**
	 * @return the dir
	 */
	public Vector getDir() {
		return dir;
	}

	@Override
	public String toString() {
		return "Ray [p=" + p0 + ", vec=" + dir + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		return Objects.equals(p0, other.p0) && Objects.equals(dir, other.dir);
	}
  public Point getPoint(double t){
		return p0.add(dir.scale(t));
  }

	/**
	 * find the closest point
	 * @param points
	 * @return
	 */
	public Point findClosestPoint(List<Point> points) {
		return points == null || points.isEmpty() ? null
				: findClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
	}


	/**
	 * find the closest GeoPoint
	 * @param lp
	 * @return
	 */
	public GeoPoint findClosestGeoPoint (List<GeoPoint> lp)
	{
		double mini_dis= this.p0.distance(lp.get(0).point);
		GeoPoint closest_point=lp.get(0);
		for (GeoPoint p:lp) {
			double dis= this.p0.distance(p.point);
			if (mini_dis>dis&& dis>0) {
				mini_dis = dis;
				closest_point=p;
			}
		}
		return closest_point;
	}

}
