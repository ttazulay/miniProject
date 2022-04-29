package renderer;

import primitives.*;
import scene.Scene;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Objects;

import static primitives.Util.isZero;

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
        Point Pc = Location.add(vto.scale(distance));

        double Rx = width / nX;
        double Ry = Length / nY;

        Point Pij = Pc;

        double Xj = (j - (nX - 1) / 2d) * Rx;
        double Yi = -(i - (nY - 1) / 2d) * Ry;

        if (isZero(Xj) && isZero(Yi)) {
            return new Ray(Location, Pij.subtract(Location));
        }
        if (isZero(Xj)) {
            Pij = Pij.add(vup.scale(Yi));
            return new Ray(Location, Pij.subtract(Location));
        }
        if (isZero(Yi)) {
            Pij = Pij.add(vright.scale(Xj));
            return new Ray(Location, Pij.subtract(Location));
        }

        Pij = Pij.add(vright.scale(Xj).add(vup.scale(Yi)));
        return new Ray(Location, Pij.subtract(Location));
    }

    public Camera setImageWriter(ImageWriter image) {
        this.image = image;
        return this;
    }

    public Camera setRayTracer(RayTracerBasic rayTracerBasic) {
        this.base = rayTracerBasic;
        return this;
    }

    /**
     *Goes over the image pixels and writes the parts of the image to each one
     */
    public void renderImage() {
        if(Location==null||vto==null||vup==null||vright==null||Length==null||width==null||distance==null||image==null||base==null){
            throw new MissingResourceException("","","");
        }
        int Nx=this.image.getNx();
        int Ny=this.image.getNy();
        for (int i = 0; i < Nx ; i++) {
            for (int j = 0; j <Ny ; j++) {
                Ray  rayCasting=constructRay(Nx,Ny,i,j);
                Color color= base.traceRay(rayCasting);
                image.writePixel(i,j,color);
            }

        }
    }

    public void printGrid(int interval, Color color) {
        int Nx=this.image.getNx();
        int Ny=this.image.getNy();
        for (int i = 0; i < Nx ; i++) {
            for (int j = 0; j <Ny ; j++)
            {
                if(i%interval==0||j%interval==0){
                   image.writePixel(j,i,color);
}
            }
        }

    }

    public void writeToImage()
    {

        if(image==null)
            throw new MissingResourceException("","","");
        this.image.writeToImage();



    }
}

