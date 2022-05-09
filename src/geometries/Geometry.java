package geometries;
import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

public abstract class Geometry extends Intersectable  {

    protected Color emission=Color.BLACK;
    abstract public Vector getNormal(Point p);
    private Material material = new Material();
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material
     * @return the material
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;

    }
    /**
     *get emission
     * @return
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * set emission,the color of the object
     * @param emission
     * @return
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

}
