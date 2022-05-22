package primitives;

public class Material {


	public Double3 Kd= new Double3(0.0) ;
	public Double3 Ks = new Double3(0.0) ;
	public int nShininess = 0;


	public Material setKd(double kD) {
		this.Kd = new Double3(kD) ;
		return this;
	}

	public Material setKs(double kS) {
		this.Ks = new Double3(kS) ;
		return this;
	}
	public Material setKd(Double3 kD) {
		this.Kd = kD;
		return this;
	}

	public Material setKs(Double3 kS) {
		this.Ks = kS;
		return this;
	}

	public Material setShininess(int nShininess) {
		this.nShininess = nShininess;
		return this;
	}

}
