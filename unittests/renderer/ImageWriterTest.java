

import org.junit.jupiter.api.Test;

import renderer.ImageWriter;
import primitives.*;

import java.awt.*;
import primitives.Color;

import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTest {

    @Test
    void writeToImage() {
        String imagename = "img";
        int nx =800;
        int ny =500;
        Color blue=new Color(0,0,255);
        Color purple=new Color(255,0,255);
        ImageWriter imageWriter = new ImageWriter(imagename, nx, ny);
        for (int col = 0; col < ny; col++) {
            for (int row = 0; row < nx; row++) {
                if (col % 50 == 0 || row % 50 == 0)
                    imageWriter.writePixel(row, col, blue);
                else
                    imageWriter.writePixel(row, col, purple);
            }
        }
        imageWriter.writeToImage();
    }
}