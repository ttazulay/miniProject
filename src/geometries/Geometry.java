package geometries;
import primitives.Color;
import primitives.Point;
import primitives.Vector;

public abstract class Geometry implements Intersectable  {

    protected Color emission=Color.BLACK;
    abstract public Vector getNormal(Point p);

    /**
     *get emission
     * @return
     */
    public Color getEmission() {
        return emission;

    }

    /**
     * set emission
     * @param emission
     * @return
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

}
