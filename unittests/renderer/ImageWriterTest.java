package renderer;

import org.junit.jupiter.api.Test;

import renderer.ImageWriter;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTest {

    @Test
    void writeToImage() {
        String imagename = "img";
        int width = 1600;
        int height = 1000;
        int nx =800;
        int ny =500;
        ImageWriter imageWriter = new ImageWriter(imagename, nx, ny);
        for (int col = 0; col < ny; col++) {
            for (int row = 0; row < nx; row++) {
                if (col % 10 == 0 || row % 10 == 0)
                    imageWriter.writePixel(row, col, Color.blue);
                }
            }
        }
        imageWriter.writeToImage();
    }

}