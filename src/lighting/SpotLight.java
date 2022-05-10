package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class SpotLight extends PointLight{
    private Vector direction;
    public SpotLight(Color colorIntensity, Point position, Vector direction) {
        super(colorIntensity, position);
        this.direction = direction;
    }

}
