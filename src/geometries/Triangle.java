package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;


public class Triangle extends Polygon{

	/**
	 * this ctor calls the ctor of the father "Polygon" (with 3 points)
	 * @param p1
     * @param p2
     * @param p3
	 */
	public Triangle(Point p1,Point p2,Point p3) {
		super(p1,p2,p3);
		
	}

    public List<GeoPoint> findGeoIntersections (Ray ray,double maxDistance){
        return findGeoIntersectionsHelper  (ray,maxDistance);
    }
    protected List<GeoPoint> findGeoIntersectionsHelper  (Ray ray,double maxDistance){
        /**Creates a new plane and tests the findIntsersections**/

        Plane Triangle_plain=new Plane(vertices.get(0), vertices.get(1), vertices.get(2));
        List<GeoPoint> T_plane_Intsersections=plane.findGeoIntersections(ray);
        if (T_plane_Intsersections == null)
            return null;
        // check if the intersection point is inside triangle
        Point p0 = ray.getP0();
        Vector dir = ray.getDir();

        Vector v1= vertices.get(0).subtract(p0);
        Vector v2= vertices.get(1).subtract(p0);
        Vector v3= vertices.get(2).subtract(p0);

        Vector n1=(v1.crossProduct(v2)).normalize();
        Vector n2=(v2.crossProduct(v3)).normalize();
        Vector n3=(v3.crossProduct(v1)).normalize();

        List<GeoPoint> Triangle_Intsersections=new ArrayList<>();
        for (GeoPoint gp:T_plane_Intsersections) {
            Triangle_Intsersections.add(new GeoPoint(this,gp.point));
        }

        return(((dir.dotProduct(n1) > 0 && dir.dotProduct(n2) > 0 && dir.dotProduct(n3) > 0) || (dir.dotProduct(n1) < 0 && dir.dotProduct(n2) < 0 && dir.dotProduct(n3) < 0))?Triangle_Intsersections:null);

    }

}
