/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgresize;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * OriginalImageLocationReader luokan testit
 * @author mikko
 */
public class OriginalImageLocationReaderTest {
    
    public OriginalImageLocationReaderTest() {
    }

    /**
     * Test of readOriginalImageNameFromDisk method, of class OriginalImageLocationReader.
     */
    @Test
    public void testReadOriginalImageNameFromDisk() {
        System.out.println("readOriginalImageNameFromDisk");
        OriginalImageLocationReader rd = new OriginalImageLocationReader();
        String expResult = "chatteri";
        String result = rd.readOriginalImageNameFromDisk();
        assertEquals(expResult, result);
    }    
}
