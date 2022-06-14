import org.junit.jupiter.api.Test;

import renderer.ImageWriter;
import lighting.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;


public class project {

    private Intersectable sphere1 = new Sphere(new Point(20, 50, 90), 17d) //
            .setEmission(new Color(213,13,207)) //
            .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(30));
    private Intersectable sphere2 = new Sphere(new Point(-30, -40, 70), 15d) //
            .setEmission(new Color(213,13,60)) //
            .setMaterial(new Material().setKd(0.2).setKs(0.5).setShininess(30));
    private Intersectable sphere3 = new Sphere(new Point(50, -20, 70), 10d) //
            .setEmission(new Color(107, 13, 15)) //
            .setMaterial(new Material().setKd(0.352).setKs(0.5).setShininess(30));




    private Material trMaterial = new Material().setKd(0.5).setKs(0.5).setShininess(30);

    private Scene scene = new Scene("Test scene");
    private Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
            .setVPSize(200, 200).setVPDistance(1000) //
            .setRayTracer(new RayTracerBasic(scene));



    public void cube(Point A, Point B, Point C, Point D,Point E,Point F,Point G ,Point H) {
        scene.geometries.add( //
        // cube
        // base of the cube : triangle ABC & triangle ACD
        new Triangle(A, B, C)
                .setEmission(new Color(33, 22, 16))
                .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),

                new Triangle(A, C, D)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),
                new Triangle(A, B, F)
                        .setEmission(new Color(50, 100, 150)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.1).setShininess(20).setKt(1.0)),
                new Triangle(A, F, E)
                        .setEmission(new Color(50, 100, 150)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.1).setShininess(20).setKt(1.0)),
                // right side : triangle FBC & triangle FCG
                new Triangle(F, B, C)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),
                new Triangle(F, C, G)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),
                // left side : triangle EAD & triangle EDH
                new Triangle(E, A, D)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),
                new Triangle(E, D, H)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),
                // back side : triangle HGD & triangle GDC
                new Triangle(H, G, D)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),
                new Triangle(G, D, C)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)));

    }

    public void connections(Point A, Point B, Point C,Point D){
        scene.geometries.add(
                new Triangle(A, B, C)
                        .setEmission(new Color(33, 22, 16))
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)),

                new Triangle(A, B, D)
                        .setEmission(new Color(33, 22, 16)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKt(0.01)));
    }
    @Test
    public void project() {
        //Creates a type of lighting
        scene.setAmbientLight(new AmbientLight(new Color(9, 78, 249),new Double3(0.12)));
        //Creates the balloon
        scene.geometries.add(
                sphere1,
                sphere2,
                sphere3
        );
        //Creates the basket
        cube(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5), new Point(13.1, 37.5, 43), new Point(4.6, 46.5, 52.4), new Point(-1.5, 37.8, 55.1), new Point(13.4, 40.5, 53.6), new Point(7.6, 31.8, 56.3));
        cube(new Point(-27.6, -13.2, 10.8), new Point(-17.6, -3.2, 20.8), new Point(-5, -15, 20), new Point(-15, -25, 10), new Point(-34, -21, 25), new Point(-24, -11, 35), new Point(-11.3, -22.8, 34.1), new Point(-21.3, -32.8, 24.1));
        cube(new Point(48.2, -41.2, 27.9), new Point(41.1, -31.2, 27.9), new Point(51, -24.2, 25.7), new Point(58.2, -34.2, 25.7), new Point(50, -40, 40), new Point(42.9, -29.9, 40), new Point(52.8, -22.9, 37.8), new Point(59.9, -33, 37.8));

        //creates the connections for the airballoon
        connections(new Point(-67, 60, 121.2), new Point(-50.5, -37.8, 55), new Point(-57.8, 64.4, 122.2),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));

        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));

        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));
        connections(new Point(4.1, 43.6, 41.9), new Point(-2.1, 34.9, 44.6), new Point(7, 28.9, 48.5),new Point(7, 28.9, 48.5));


        scene.lights.add( //
                new SpotLight(new Color(700, 400, 400), new Point(40, 40, 115), new Vector(-1, -1, -4)) //
                        .setKl(4E-4).setKq(2E-5));

        camera.setImageWriter(new ImageWriter("project", 600, 600)) //
                .renderImage(); //
        camera.writeToImage();
    }
}

