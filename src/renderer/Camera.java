package renderer;

import primitives.Double3;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.Objects;

public class Camera {
    protected Point Location ;
    protected Vector vto ;
    protected Vector vup ;
    protected Vector vright ;
    protected Double Length ;
    protected Double width ;
    protected Double distance ;

    public Camera(Point location, Vector vto, Vector vup) {

        try
        {
            if (vto.dotProduct(vup)!=0){
                throw new IllegalArgumentException();
            }
            Location = location;
            this.vto = vto.normalize();
            this.vup = vup.normalize();
            this.vright=vto.crossProduct(vup);
        }
        catch(IllegalArgumentException ex)
        {}
    }
    public Camera setVPSize(double width, double height){
        this.width=width;
        this.Length=height;
        return this;
    }
    public Camera setVPDistance(double distance){
        this.distance=distance;
        return this;
    }
    public Ray constructRay(int nX, int nY, int j, int i){
        return null;
    }
}

