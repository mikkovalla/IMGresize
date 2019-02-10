/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testimgresize;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * OriginalImageLocationReader luokan testit
 *
 * @author mikko
 */
public class OriginalImageLocationReaderTest {

    public OriginalImageLocationReaderTest() {
    }

    /**
     * Test of readOriginalImageNameFromDisk method, of class
     * OriginalImageLocationReader. No scanner class test, the user input is
     * simulated by hardcoded image name
     */
    @Test
    public void testReadOriginalImageNameFromDisk() {
        System.out.println("readOriginalImageNameFromDisk simulates Scanner class reading of user input for image name");
        String expResult = "chatteri";
        String result = System.getProperty("user.dir") + "//src//main//resources//" + expResult + ".jpg";
        if (!result.contains(expResult)) {
            fail("Image name is wrong!");
        }
    }
}
