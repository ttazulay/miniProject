package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;


public class PointLight extends Light implements LightSource {

	private Point position;
    private double kC = 1 ;// Constant attenuation
    private double kL = 0; // Linear attenuation
    private double kQ = 0; // Quadratic attenuation

    /**
     * Constructors with colorIntensity and position
     * @param colorIntensity
     * @param position
     */
    public PointLight(Color colorIntensity, Point position) {
    	super(colorIntensity) ;
        this.position = position;
       
    }

    /**
     * get Intensity of Point Light
     * @param p
     * @return
     */
    @Override
    public Color getIntensity(Point p) {
        double dsquared = p.distanceSquared(position);//distance between the point and the position of the spot light squared
        double d = p.distance(position);//distance between the point and the position of the spot light
        return (getIntensity().reduce(kC + kL * d + kQ * dsquared));
    }

    @Override
    public Vector getL(Point p) {
        if (p.equals(position))//if the point and the position of the light are the same there is no distance
        {
            return null;
        }
        else
            return p.subtract(position).normalize();//finds the distance between the point and the position of the light and normalizes it
    }

    @Override
    public double getDistance(Point point) {
        return position.distance(point);// the distance between point position and the point the function received
    }


    public PointLight setKc(double kC) {
		this.kC = kC;
		return this;
	}

	public PointLight setKl(double kL) {
		this.kL = kL;
		return this;
	}

	public PointLight setKq(double kQ) {
		this.kQ = kQ;
		return this;
	}






}


