package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {
    Color intensity;

    public AmbientLight() {
        intensity= Color.BLACK;
    }

    public AmbientLight(Color IA, Double3 KA) {
        intensity=IA.scale(KA);
    }
    public Color getIntensity() {
        return intensity;
    }
}
