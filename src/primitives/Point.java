package primitives;
import java.util.Objects;

/**
 * basic geometric object for #d point
 * @author Rachel & Ester
 *
 */

public class Point
{
    public static final Point ZERO = new Point(0, 0, 0);
    protected Double3 xyz ;
	
/**
 * this ctor gets 3 params type double
 * @param x
 * @param y
 * @param z
 */
	 public Point(double x, double y, double z){
	        xyz = new Double3(x, y, z);
	    }
	 
	 /**
	  * this ctor gets 1 param type Double3
	  * @param d3
	  */
	 public Point(Double3 d3){
	        xyz = new Double3(d3.d1,d3.d2,d3.d3);
	    }

	 
	public Vector subtract(Point p2){
        return new Vector(xyz.subtract(p2.xyz));
    }

	
	

    public Point add(Vector v){
        Double3 temp =  xyz.add(v.xyz);
        return new Point(temp.d1, temp.d2, temp.d3);
    }

	

   
   public double distanceSquared(Point p2){
       return (xyz.d1 - p2.xyz.d1) * (xyz.d1 - p2.xyz.d1) +
               (xyz.d2 - p2.xyz.d2) * (xyz.d2 - p2.xyz.d2) +
               (xyz.d3 - p2.xyz.d3) * (xyz.d3 - p2.xyz.d3);
   }

   
	
	public double distance(Point point_)
	{
		return Math.sqrt(distanceSquared(point_));
	}



	@Override
	public String toString() {
		return "Point [xyz=" + xyz + "]";
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return Objects.equals(xyz, other.xyz);
	}


	public double getX() {
		return this.getX();
	}

	public double getY() {
		return this.getY();
	}

	public double getZ() {
		return this.getZ();
	}
}
