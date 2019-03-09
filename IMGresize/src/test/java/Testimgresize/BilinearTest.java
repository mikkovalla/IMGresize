package Testimgresize;

import imgresize.bilinear.Bilinear;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikko
 * 
 * Test for Bilinear class
 */
public class BilinearTest {

    Bilinear bilinear;
    private final String fileName = "eka";

    @Before
    public void setUp() {
        bilinear = new Bilinear();
    }

    /**
     * Test of getBits method, of class Bilinear.
     */
    @Test
    public void testGetBits() {
        System.out.println("getBits");
        int tulos1 = 0;
        int tulos2 = 0;
        int tulos3 = 0;
        int tulos4 = 0;

        for (int i = 0; i <= 100; i++) {
            tulos1 += bilinear.getBits(i, i + 1);
            tulos2 += bilinear.getBits(i + 2, i);
            tulos3 += bilinear.getBits(i, i);
            tulos4 += bilinear.getBits(i * 11, i - 2);
        }
        assertEquals(tulos1, 1275);
        assertEquals(tulos2, 1352);
        assertEquals(tulos3, 1300);
        assertEquals(tulos4, 3041);
    }

    /**
     * Test of linearInterpolation method, of class Bilinear.
     */
    @Test
    public void testLinearInterpolation() {
        System.out.println("linearInterpolation");
        
        int tulos1 = 0;
        int tulos2 = 0;
        int tulos3 = 0;
        int tulos4 = 0;

        for (int i = 0; i <= 100; i++) {
            tulos1 += bilinear.linearInterpolation(i, i + 1, i + 2);
            tulos2 += bilinear.linearInterpolation(i + 2, i, i - 1);
            tulos3 += bilinear.linearInterpolation(i, i, i);
            tulos4 += bilinear.linearInterpolation(i * 11, i - 2, i * 10);
        }
        assertEquals(tulos1, 10302);
        assertEquals(tulos2, -4646);
        assertEquals(tulos3, 5050);
        assertEquals(tulos4, -33880440);
        
    }

    /**
     * Test of bilinearInterpolation method, of class Bilinear.
     */
    @Test
    public void testBilinearInterpolation() {
        System.out.println("bilinearInterpolation");
        int tulos1 = 0;
        int tulos2 = 0;
        int tulos3 = 0;
        int tulos4 = 0;

        for (int i = 0; i <= 100; i++) {
            tulos1 += bilinear.bilinearInterpolation(i, i + 1, i + 2, i + 3, i + 4, i + 5);
            tulos2 += bilinear.bilinearInterpolation(i + 2, i, i - 1, i + 2, i, i - 1);
            tulos3 += bilinear.bilinearInterpolation(i, i, i, i, i, i);
            tulos4 += bilinear.bilinearInterpolation(i * 11, i - 2, i * 10, i - 3, i + 8, i * 122);
        }
        
        assertEquals(tulos1, 21614);
        assertEquals(tulos2, 1646805);
        assertEquals(tulos3, 5050);
        assertEquals(tulos4, 2147483647);
    }

    /**
     * Test of resizeBufferedImageWithBilinearInterpolation method, of class
     * Bilinear.
     * @throws java.io.IOException
     */
    @Test
    public void testResizeBufferedImageWithBilinearInterpolation() throws IOException {
        System.out.println("resizeBufferedImageWithBilinearInterpolation");
        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "//src//main//resources//" + this.fileName + ".jpg"));

        float horisontal1 = 1.0F;
        float vertical1 = 1.0F;
        float horisontal2 = 2.0F;
        float vertical2 = 2.0F;
        float horisontal3 = 8.0F;
        float vertical3 = 6.0F;

        BufferedImage result1 = bilinear.resizeBufferedImageWithBilinearInterpolation(image, horisontal1, vertical1);
        BufferedImage result2 = bilinear.resizeBufferedImageWithBilinearInterpolation(image, horisontal2, vertical2);
        BufferedImage result3 = bilinear.resizeBufferedImageWithBilinearInterpolation(image, horisontal3, vertical3);
        
        if(!((result1.getWidth() + result1.getHeight()) < (result2.getWidth() + result2.getHeight()))){
            fail("Image resizing didn't work!");
        }
        
        if(!((result1.getWidth() + result1.getHeight()) < (result3.getWidth() + result3.getHeight()))){
            fail("Image resizing didn't work!");
        }
        
        if(!((result2.getWidth() + result2.getHeight()) < (result3.getWidth() + result3.getHeight()))){
            fail("Image resizing didn't work!");
        }
    }

}
