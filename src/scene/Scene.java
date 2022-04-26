package scene;

import geometries.*;
import lighting.AmbientLight;
import primitives.*;
import primitives.Color;

import java.awt.*;

public class Scene {
    public String name;
    public Color background = new Color(0, 0, 0);
    public AmbientLight ambientLight= new AmbientLight();
    public Geometries geometries= new Geometries();

    /**
     * constructor
     * @param name
     */
    public Scene(String name) {
        this.name = name;
        geometries=new Geometries();
    }

    /**
     * set background
     * @param color
     * @return
     */
    public Scene setBackground(Color color) {
        this.background=background;
        return this;
    }

    /**
     * set ambientLight
     * @param ambientLight
     * @return
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
      this.ambientLight=ambientLight;
      return this;
    }

    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}
