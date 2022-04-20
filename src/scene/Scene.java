package scene;

import geometries.*;
import lighting.AmbientLight;
import primitives.*;

public class Scene {
    public String name;
    public Color _background = new Color(0, 0, 0);
    public AmbientLight ambientLight;
    public Geometries geometries;

}
