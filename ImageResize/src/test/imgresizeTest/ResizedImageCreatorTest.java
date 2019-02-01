/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgresize;

import java.awt.image.BufferedImage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for ResizeImageCreator class
 * @author mikko
 */
public class ResizedImageCreatorTest {
    
    public ResizedImageCreatorTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of openImage method, of class ResizedImageCreator.
     */
    @Test
    public void testOpenImage() {
        System.out.println("openImage");
        ResizedImageCreator instance = new ResizedImageCreator();
        BufferedImage expResult = null;
        BufferedImage result = instance.openImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveImage method, of class ResizedImageCreator.
     */
    @Test
    public void testSaveImage() {
        System.out.println("saveImage");
        String methodName = "";
        BufferedImage img = null;
        ResizedImageCreator instance = new ResizedImageCreator();
        instance.saveImage(methodName, img);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
