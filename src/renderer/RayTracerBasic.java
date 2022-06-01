

package renderer;

import java.util.List;

import lighting.*;
import primitives.*;
import scene.Scene;
import static primitives.Util.alignZero;
import geometries.Intersectable.GeoPoint;




public class RayTracerBasic extends RayTracerBase {

	//Fixed for first moving magnitude rays for shading rays
	private static final double DELTA = 0.1;
	//המרחקים המקסימלים והמינימלים שעד אליהם נבצע את בדיקות השקיפות והשתקפות
	private static final int MAX_CALC_COLOR_LEVEL = 10;
	private static final double MIN_CALC_COLOR_K = 0.001;
	private static final double INITIAL_K = 1.0;




	/**
	 * Constructor
	 *
	 * @param scene
	 */
	public RayTracerBasic(Scene scene) {
		super(scene);
	}

	@Override
	public Color traceRay(Ray ray) {
		//List<GeoPoint> closestPoint = scene.geometries.findGeoIntersections(ray);
		//return closestPoint == null ? scene.background : calcColor(ray.findClosestGeoPoint(closestPoint), ray);
		GeoPoint closestPoint = findClosestIntersection(ray);
		if(closestPoint==null)
			return scene.background;
		return calcColor(closestPoint, ray);

	}


	/*private Color calcColor(GeoPoint intersection, Ray ray) {
		return scene.ambientLight.getIntensity()
				.add(calcLocalEffects(intersection, ray));
	}
*/
	/**
	 * add the color of the object to the point color
	 * @param gp
	 * @param ray
	 * @return
	 */
	private Color calcColor(GeoPoint gp, Ray ray) {
		Color color = calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K);
		color = color.add(scene.ambientLight.getIntensity());
		return color;
	}

	private Color calcColor(GeoPoint  intersection, Ray ray, int level, double k) {

		Color color = intersection.geometry.getEmission();
		color = color.add(calcLocalEffects(intersection, ray, k));// add calculated light contribution from all light
		// sources)
		return 1 == level ? color : color.add(calcGlobalEffects(intersection, ray, level, k));
	}


	/**
	 * Calculates the color at a given point according to local effects
	  * @param gp
	 * @param ray
	 * @param k
	 * @return
	 */
	private Color calcLocalEffects(GeoPoint gp, Ray ray, double k) {
		Color color = gp.geometry.getEmission();//נקבל את צבע הגוף
		Vector v = ray.getDir();
		Vector n = gp.geometry.getNormal(gp.point);
		double nv = alignZero(n.dotProduct(v));
		if (nv == 0) {
			return Color.BLACK;
		}

		Material material = gp.geometry.getMaterial();

		for (LightSource lightSource : scene.lights) {
			Vector l = lightSource.getL(gp.point);
			double nl = alignZero(n.dotProduct(l));
			if (nl * nv > 0) { // sign(nl) == sing(nv)
				double ktr = transparency(gp,lightSource, l, n);
				if (ktr * k > MIN_CALC_COLOR_K) {
					Color lightIntensity = lightSource.getIntensity(gp.point).scale(ktr);
					Color iL = lightSource.getIntensity(gp.point).scale(ktr);// Intensity of the light
					color = color.add(iL.scale(calcDiffusive(material, nl)), iL.scale(calcSpecular(material, n, l, nl, v)));
				}
			}
		}
		return color;

	}




	/**
	 * Calculate Specular component of light reflection.
	 * @return specular light color
	 */

	private Color calcSpecular(double ks, Vector l, Vector n, double nl, Vector v, int nShininess, Color ip) {

		Vector r = l.subtract(n.scale(nl * 2)).normalize();
		double factor = Math.max(0, (v.scale(-1)).dotProduct(r));
		return ip.scale(ks * Math.pow(factor, nShininess));

	}

	/**
	 * Calculate Diffusive component of light reflection.
	 * @return diffusive component of light reflection
	 */
	private Color calcDiffusive(double kd, double nl, Color ip) {
		if (nl < 0) // if nl is negative we make it positive
			nl = Math.abs(nl);
		Color scaled = ip.scale(nl * kd);// scales nl with the diffuse component
		return scaled;
	}


	private Color calcGlobalEffects(GeoPoint intersection, Ray ray, int level, Double k) {
		Color color = Color.BLACK;
		Vector n = intersection.geometry.getNormal(intersection.point);
		Material material = intersection.geometry.getMaterial();
		double kkr = k* material.Kr.getD1() ;
		if (kkr > MIN_CALC_COLOR_K)
			color = calcGlobalEffect(constructReflectedRay(intersection.point, ray, n), level, material.Kr.getD1(), kkr);
		double kkt = k * material.Kt.getD1();
		if (kkt > MIN_CALC_COLOR_K)
			color = color.add(calcGlobalEffect(constructRefractedRay(intersection.point, ray, n), level, material.Kt.getD1(), kkt));
		return color;
	}





	private Color calcGlobalEffect(Ray ray, int level, double kx, double kkx)
	{
		GeoPoint gp = findClosestIntersection (ray);
		return (gp == null ? scene.background : calcColor(gp, ray, level-1 , kkx)).scale(kx);
	}



	private Ray constructReflectedRay(Point point, Ray v, Vector n)
	{
		Vector r= v.getDir().subtract((n.scale(v.getDir().dotProduct(n)).scale(2))).normalize();
		return new Ray(point,r,n);

	}

	private Ray constructRefractedRay(Point point, Ray v, Vector n)
	{
		return new Ray(point, v.getDir(), n);
	}


	/**
	 * @param mat to get the kd diffusive component
	 * @param nl  dot-product geometry Normal *light Source
	 * @return diffusive component of light reflection
	 */
	private Double3 calcDiffusive(Material mat, double nl) {
		Double3 kd = mat.Kd;
		if (nl < 0) {
			nl = Math.abs(nl);
		}
		return kd.scale(nl);
	}


	/**
	 * Calculate Specular component of light reflection.
	 *
	 * @param mat for ks specular component and nShininess shininess level
	 * @param n   normal to surface
	 * @param l   direction from light
	 * @param nl  dot-product geometry Normal *light Source
	 * @param v   direction from point of view
	 * @return specular light color
	 */
	private Double3 calcSpecular(Material mat, Vector n, Vector l, double nl, Vector v) {
		Vector r = l.subtract(n.scale(nl * 2)).normalize();
		double factor = Math.max(0, (v.scale(-1)).dotProduct(r));
		return mat.Ks.scale(Math.pow(factor, mat.nShininess));
	}


	/**
	 * @param gp
	 * @param lightSource
	 * @param l
	 * @param n
	 * @return
	 */
	private boolean unshaded(GeoPoint gp, LightSource lightSource, Vector l, Vector n) {
		Vector lightDirection = l.scale(-1); // from point to light source
		Vector epsVector = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
		Point point = gp.point.add(epsVector);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay, lightSource.getDistance(gp.point));
// Flat geometry can't self-intersect
		if (intersections == null)
			return true;
		for (GeoPoint intersection : intersections) {
			//if there are points in the intersections list that are closer to the point we check
			if (lightSource.getDistance(gp.point) >= intersection.point.distance(gp.point))
				return false;
		}
		return true;

	}

	private double transparency(GeoPoint gp, LightSource lightSource, Vector l, Vector n) {

		Vector lightDirection = l.scale(-1); // from point to light source
		Vector epsVector = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
		Point point = gp.point.add(epsVector);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay, lightSource.getDistance(gp.point));
		double ktr = 1;

		if (intersections == null)
			return ktr;
		for (GeoPoint intersection : intersections) {
			//if there are points in the intersections list that are closer to the point we check
			if (lightSource.getDistance(gp.point) >= intersection.point.distance(gp.point)) {
					ktr*=intersection.geometry.getMaterial().Kt.getD1();/// multiplies with the geometry's transparency
				if (ktr < MIN_CALC_COLOR_K)// if the transparency is smaller than the min calc color
					return 0.0;
			}
		}
		return ktr;

	}


	private GeoPoint findClosestIntersection(Ray ray) {
		GeoPoint closest = null;// so far the closest point is unknown
		double distance = Double.MAX_VALUE;
		double check;

		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
		if (intersections == null)// if there are no intersection points
			return null;
		for (GeoPoint gp : intersections)// for each intersection point we check if it is closer to p0 than the previous
		// pints
		{
			check = ray.getP0().distance(gp.point);// distance between p0 and the geopoint
			if (check < distance)// if the distance between the new point and p0 is smaller the previous smallest
			// distance
			{
				distance = check;// updates the distance
				closest = gp;// updates the geopoint
			}
		}
		return closest;
	}




}




