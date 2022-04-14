package primitives;

import java.util.Objects;

public class Ray {

	private Point p0;
	Vector dir;
	
	/**
	 * this ctor gets a Point & a Vector (the ctor makes sure the vector is normelized
	 * @param p0
	 * @param vec
	 */
	public Ray(Point p0, Vector vec) {
		super();
		this.p0 = p0;
		this.dir = vec.normalize();
	}

	/**
	 * @return the p0
	 */
	public Point getP0() {
		return p0;
	}


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
    return new Point(p0.add(dir.scale(t)));
  }
	
}
