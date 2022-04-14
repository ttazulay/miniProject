package geometries;

import primitives.Point;


public class Triangle extends Polygon{

	/**
	 * this ctor calls the ctor of the father "Polygon" (with 3 points)
	 * @param vertices
	 */
	public Triangle(Point p1,Point p2,Point p3) {
		super(p1,p2,p3);
		
	}
  
  public List<Point> findIntsersections(Ray ray){

    Plane Triangle_plain=new Plane(vertices[0],vertices[1],vertices[2])
    list<Point>Triangle_Intsersections=Triangle_plain.findIntsersections(ray);
        if (Triangle_Intsersections == null)
            return null;
    	// check if the intersection point is inside triangle
      Point p0 = ray.getP0();   
      Vector dir = ray.getDir();

   Vector v1=vertices[0].subtract(p0);
   Vector v2=vertices[1].subtract(p0);
   Vector v3=vertices[2].subtract(p0);
    
   Vector n1=(v1.crossProduct(v2)).normalize();
   Vector n2=(v2.crossProduct(v3)).normalize();
   Vector n3=(v3.crossProduct(v1)).normalize();

    return(((dir.dotProduct(n1) > 0 && dir.dotProduct(n2) > 0 && dir.dotProduct(n3) > 0) || (dir.dotProduct(n1) < 0 && dir.dotProduct(n2) < 0 && dir.dotProduct(n3) < 0))?Triangle_Intsersections:null)
             
  
    }

}
