package primitives;

public class Material {


	public Double3 Kd= new Double3(0.0) ;
	public Double3 Ks = new Double3(0.0) ;
	public Double3 Kt= new Double3(0.0) ;//Transparency שקיפות
	public Double3 Kr = new Double3(0.0) ;//reflection השתקפות

	public int nShininess = 0;


	/**
	 * set the kd-diffuse parameter
	 * @param kD
	 * @return
	 */
	public Material setKd(double kD) {
		this.Kd = new Double3(kD) ;
		return this;
	}

	/**
	 *set ks-specular parameter//
	 * @param kS
	 * @return
	 */
	public Material setKs(double kS) {
		this.Ks = new Double3(kS) ;
		return this;
	}

	/**
	 * set Kt-tranperancy parameter with double //שקיפות
	 * @param kT
	 * @return
	 */
	public Material setKt(double kT) {
		this.Kt = new Double3(kT) ;
		return this;
	}

	public Material setKr(Double kR) {
		this.Kr = new Double3(kR) ;
		return this;
	}
	/**
	 *set kd-diffuse parameter//מריחה של אור
	 * @param kD
	 * @return
	 */
	public Material setKd(Double3 kD) {
		this.Kd = kD;
		return this;
	}

	/**
	 *set ks-specular parameter//
	 * @param kS
	 * @return
	 */
	public Material setKs(Double3 kS) {
		this.Ks = kS;
		return this;
	}

	/**
	 *set Kt-tranperancy parameter//שקיפות
	 * @param kt
	 * @return
	 */
	public Material setKt(Double3 kt) {
		Kt = kt;
		return this;
	}

	/**
	 *set kr-reflection parameter//השתקפות
	 * @param kr
	 * @return
	 */
	public Material setKr(Double3 kr) {
		Kr = kr;
		return this;
	}

	/**
	 *
	 * @param nShininess
	 * @return
	 */
	public Material setShininess(int nShininess) {
		this.nShininess = nShininess;
		return this;
	}



}
