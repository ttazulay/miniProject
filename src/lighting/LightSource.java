package lighting;

import primitives.*;

public interface LightSource {

	/**
	 * get Intensity of Light Source
	 * @param p
	 * @return
	 */
	public Color getIntensity(Point p);
	public Vector getL(Point p);
    public double getDistance(Point point);
}
