package lighting;

import primitives.Color;

abstract class Light {

	private Color intensity;

	protected Light(Color intensity) {
		this.intensity = intensity;
	}

	/**
	 * get the Intensity of the Light
	 * @return
	 */
	public Color getIntensity() {
		return intensity;
	}

}