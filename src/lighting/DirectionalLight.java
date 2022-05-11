package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource  {

    private Vector direction;

    public DirectionalLight(Color intensity, Vector _direction) {
    	super(intensity) ;
        direction = _direction.normalize();
    }

    @Override
    public Color getIntensity(Point p) {
        return super.getIntensity();
    }

    /**
     * Returns the value of the lighting direction
     * @param p
     * @return
     */
    @Override
    public Vector getL(Point p) {
        return direction;
    }

    @Override
    public double getDistance(Point point)
    {
        return Double.POSITIVE_INFINITY;// like the distance between the sun and the earth the distance is to far to calculate
    }

}
