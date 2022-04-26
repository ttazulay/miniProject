package renderer;

import primitives.*;
import scene.Scene;

import java.util.List;
import java.util.Objects;

public class Camera {
    protected Point Location ;
    protected Vector vto ;
    protected Vector vup ;
    protected Vector vright ;
    protected Double Length ;
    protected Double width ;
    protected Double distance ;
    private ImageWriter image ;
    private RayTracerBase base ;

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

    public Camera setImageWriter(ImageWriter image) {
        this.image = image;
        return this;
    }

    public Camera setRayTracer(RayTracerBasic rayTracerBasic) {
        this.base = rayTracerBasic;
        return this;
    }

    public void renderImage() {
/*        int Nx=this.image.getNx();
        int Ny=this.image.getNy();
        for (int i = 0; i < Nx ; i++) {
            for (int j = 0; j <Ny ; j++) {
                Ray  rayCasting=constructRay(Nx,Ny,j,i);
                List<Point>rayL=
            }

        }*/
    }

    public void printGrid(int i, Color color) {
    }

    public void writeToImage()
    {
        /*try {
            if(image!=)
                throw MissingResourcesException();
            this.image.writeToImage();
        }
        catch (Exception MissingResourcesException)
        {}*/


    }
}

