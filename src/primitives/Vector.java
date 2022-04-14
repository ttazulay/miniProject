package primitives;

//import java.util.Objects;

public class Vector extends Point {


	
	public Vector(double x, double y, double z) {
		super(x, y, z);
		Double3 temp=new Double3(x,y,z);
		if (temp.equals(Double3.ZERO))
			throw new IllegalArgumentException("head can't be (0,0,0)");
	}

	public Vector(Double3 D3) {
		super(D3.d1,D3.d2,D3.d3);
		if (xyz.equals(Double3.ZERO))
			throw new IllegalArgumentException("head can't be (0,0,0)");

      }


	   @Override
		public String toString() {
			return "Vector [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ "]";
		}

	
	/**
	 * this function adds 1 head of a vector to another head of a vecor 
	 */
	public Vector add(Vector v2){
        Double3 temp = xyz.add(v2.xyz);
        return new Vector(temp.d1, temp.d2, temp.d3);
    }

	
/**
 * this function substracts 2 vectors
 * @param v2
 * @return
 */
	public Vector subtract(Vector v2){
        Double3 temp = xyz.subtract(v2.xyz);
        return new Vector(temp.d1, temp.d2, temp.d3);
    }

	

/**
 * this function gets a scalar to multiply the head of vector
 * @param scalar
 * @return
 */
    public Vector scale(double scalar){
    	  if (scalar==0) 
  			throw new IllegalArgumentException("can't multiply by 0");
  	
    	Double3 temp =xyz.scale(scalar);
        return new Vector(temp.d1, temp.d2, temp.d3);
    }


    /**
     *this function does a "scalar multiply" to the vector
     * @param v2
     * @return
     */
    public double dotProduct(Vector v2){
        Double3 temp = xyz.product(v2.xyz);
        return temp.d1+ temp.d2+ temp.d3 ;
    }

    /**
     * this function does a "vector multiply" action 
     * @param v2
     * @return
     */
    public Vector crossProduct(Vector v2){
        Double3 temp = new Double3((xyz.d2 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d2),
                - ((xyz.d1 * v2.xyz.d3) - (xyz.d3 * v2.xyz.d1)),
                (xyz.d1 * v2.xyz.d2) - (xyz.d2 * v2.xyz.d1));
        return new Vector(temp.d1, temp.d2, temp.d3);
    }

    /**
     * this function gets a vector and returns the length^2
     * @param vec
     * @return
     */
    public double lengthSquared ()
    {
    	return Math.pow(xyz.d1, 2) + Math.pow(xyz.d2, 2)+ Math.pow(xyz.d3, 2);
    }

    /**
     * the length of the vector
     * @param vec
     * @return
     */
    public double length ()
    {
    	return Math.sqrt(this.lengthSquared());
    }

    /**
     * this function gets a vector and does a Normelize action on it
     * @param vec
     * @return
     */
    public Vector normalize()
    {
    	return new Vector((xyz.d1/length()),(xyz.d2/length()),(xyz.d3/length()));
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
    
    

}
