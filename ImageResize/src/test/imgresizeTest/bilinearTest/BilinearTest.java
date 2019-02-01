/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgresize.bilinear;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikko
 */
public class BilinearTest {

    public BilinearTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBits method, of class Bilinear.
     */
    @Test
    public void testGetBits() {
        System.out.println("getBits");
        int number = 0;
        int n = 0;
        Bilinear instance = new Bilinear();
        int expResult = 0;
        int result = instance.getBits(number, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of linearInterpolation method, of class Bilinear.
     */
    @Test
    public void testLinearInterpolation() {
        System.out.println("linearInterpolation");
        float a = 0.0F;
        float b = 0.0F;
        float f = 0.0F;
        Bilinear instance = new Bilinear();
        float expResult = 0.0F;
        float result = instance.linearInterpolation(a, b, f);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bilinearInterpolation method, of class Bilinear.
     */
    @Test
    public void testBilinearInterpolation() {
        System.out.println("bilinearInterpolation");
        float firstValueToInterpolateFrom = 0.0F;
        float firstValueInterpolateTo = 0.0F;
        float secondValueToInterpolateFrom = 0.0F;
        float secondValueInterpolateTo = 0.0F;
        float firstHowFarToInterpolate = 0.0F;
        float secondHowFarToInterpolate = 0.0F;
        Bilinear instance = new Bilinear();
        float expResult = 0.0F;
        float result = instance.bilinearInterpolation(firstValueToInterpolateFrom, firstValueInterpolateTo,
                secondValueToInterpolateFrom, secondValueInterpolateTo, firstHowFarToInterpolate,
                secondHowFarToInterpolate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resizeBufferedImageWithBilinearInterpolation method, of class
     * Bilinear.
     */
    @Test
    public void testResizeBufferedImageWithBilinearInterpolation() {
        System.out.println("resizeBufferedImageWithBilinearInterpolation");
        BufferedImage image = null;
        float horisontal = 0.0F;
        float vertical = 0.0F;
        Bilinear instance = new Bilinear();
        BufferedImage expResult = null;
        BufferedImage result = instance.resizeBufferedImageWithBilinearInterpolation(image, horisontal, vertical);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
