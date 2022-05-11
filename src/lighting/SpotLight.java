package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class SpotLight extends PointLight{
    private Vector direction;

    private double NarrowBeam=0d;
    public SpotLight(Color colorIntensity, Point position, Vector direction) {
        super(colorIntensity, position);
        this.direction = direction;
    }

    public double getNarrowBeam() {
        return NarrowBeam;
    }

    public SpotLight setNarrowBeam(double narrowBeam) {
        this.NarrowBeam = narrowBeam;
        return this;
    }
}
