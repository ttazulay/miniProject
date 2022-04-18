package geometries;
import primitives.*;

import java.util.*;

public class Geometries implements Intersectable {

    List<Intersectable> list;
    Geometries(){
        list= new LinkedList();
    }
    public Geometries(Intersectable... geometries){
        this.add(geometries);
    }
    public void add(Intersectable... geometries){
        for (Intersectable i :geometries) {

            list.add(i);
        }

    }
    public List<Point> findIntsersections(Ray ray) {
        List<Point> result = null;

        List<Point> one_geometrie = new LinkedList<Point>();

        for (Intersectable i : list) {
            one_geometrie = i.findIntsersections(ray);
            for (Point p : one_geometrie) {
                result.add(p);
            }
        }
        return result;
    }

}