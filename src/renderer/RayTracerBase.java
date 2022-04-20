package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;


public abstract class RayTracerBase {
	protected Scene scene;

	public RayTracerBase(Scene scene) {
		this.scene = scene;
	}

	public abstract Color traceRay(Ray ray);

}
