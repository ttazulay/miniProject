package geometries;
import primitives.*;

import java.util.*;

public class Geometries extends Intersectable {

    List<Intersectable> geometrieslist;


    /**
     * constructor
     */
    Geometries(){
        geometrieslist = new LinkedList<Intersectable>();
    }

    /**
     * constructor
     * @param geometries
     */
    public Geometries(Intersectable... geometries){
        this.add(geometries);
    }

    public void add(Intersectable... geometries){
        if (geometrieslist==null) {
            geometrieslist = new LinkedList<Intersectable>();
        }
        for (Intersectable i :geometries) {

            geometrieslist.add(i);
        }
    }


    public List<GeoPoint> findGeoIntersections (Ray ray,double maxDistance){
        return findGeoIntersectionsHelper(ray,maxDistance);
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper  (Ray ray,double maxDistance){
        List<GeoPoint> result = null;
        List<GeoPoint> one_geometrie = new LinkedList<GeoPoint>();
        for (Intersectable i : geometrieslist) {
            one_geometrie = i.findGeoIntersections(ray,maxDistance);
            if (one_geometrie!= null){
                if (result==null)
                    result=new LinkedList<GeoPoint>();
                for (GeoPoint p : one_geometrie) {
                    result.add(p);
                }
            }
        }
        return result;
    }

}