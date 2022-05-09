package primitives;

public class Material {

	public Double3 kD= new Double3(0.0) ;
	public Double3 kS = new Double3(0.0) ;
	public int nShininess = 0;


	public Material setkD(double kD) {
		this.kD = new Double3(kD) ;
		return this;
	}

	public Material setkS(double kS) {
		this.kS = new Double3(kS) ;
		return this;
	}
	public Material setkD(Double3 kD) {
		this.kD = kD;
		return this;
	}

	public Material setkS(Double3 kS) {
		this.kS = kS;
		return this;
	}

	public Material setnShininess(int nShininess) {
		this.nShininess = nShininess;
		return this;
	}

}
