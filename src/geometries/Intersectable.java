package geometries;

import primitives.*;

import java.util.List;
import java.util.Objects;

public abstract class Intersectable  {
    public abstract List<Point> findIntsersections(Ray ray);
    /**
     * GeoPoint- passive data structre
     */
    public static class GeoPoint {
        public Geometry geometry;
        public Point point;

        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return geometry.equals(geoPoint.geometry) && point.equals(geoPoint.point);
        }
        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }
    public List<GeoPoint> findGeoIntersections (Ray ray){
        return findGeoIntersectionsHelper  (ray);
    }
    protected List<GeoPoint> findGeoIntersectionsHelper  (Ray ray){
        return null;
    }

}