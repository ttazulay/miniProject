package geometries;
import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

public abstract class Geometry extends Intersectable  {

    private Color emission=Color.BLACK;
    private Material material = new Material();

    abstract public Vector getNormal(Point p);

    /**
     * get Material
     * @return
     */
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
