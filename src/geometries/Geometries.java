package geometries;
import primitives.Point;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;
public class Geometries implements Intersectable {
    List<Intersectable> list;
    Geometries(){
        list= new LinkedList();
    }
    public Geometries(Intersectable... geometries){
        list= new LinkedList(geometries);
    }
    public void add(Intersectable... geometries){
        for each(Intersectable i in geometries){
            list.add(i)
        }

    }
    public List<Point> findIntsersections(Ray ray){
        List<Point> result=new List();
        for each(Intersectable i in list){
            result.add(i.findIntsersections(ray));
        }

    }