package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {
    Color IA;
    Double3 KA;
    Color intensity;
    public AmbientLight() {
        intensity= Color.BLACK;
    }

    public AmbientLight(Color IA, Double3 KA) {
        this.IA = IA;
        this.KA = KA;
    }
    public Color getIntensity() {
        return intensity;
    }
}
