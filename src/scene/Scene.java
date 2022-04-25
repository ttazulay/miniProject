package scene;

import geometries.*;
import lighting.AmbientLight;
import primitives.*;
import primitives.Color;

import java.awt.*;

public class Scene {
    public String name;
    public Color background = new Color(0, 0, 0);
    public AmbientLight ambientLight;
    public Geometries geometries;

    public Scene(String name) {
        this.name = name;
        geometries=new Geometries();
    }


    public Scene setAmbientLight(AmbientLight ambientLight) {
      this.ambientLight=ambientLight;
      return this;
    }

    public Scene setBackground(Color color) {
        this.background=background;
        return this;
    }
}
