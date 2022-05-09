package scene;

import geometries.*;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.*;
import primitives.Color;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Scene {
    public String name;
    public Color background = new Color(0, 0, 0);
    public AmbientLight ambientLight= new AmbientLight();
    public Geometries geometries= new Geometries();
    public List<LightSource> lights = new LinkedList<LightSource>();

    public Scene setLightSources(List<LightSource> lights) {
        this.lights = lights;
        return this;
    }

    public Scene(String name) {
        this.name = name;
        geometries=new Geometries();
    }

    public Scene setBackground(Color background) {
        this.background=background;
        return this;
    }

    public Scene setAmbientLight(AmbientLight ambientLight) {
      this.ambientLight=ambientLight;
      return this;
    }

    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }

}
