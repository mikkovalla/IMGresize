/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgresize;

import imgresize.bilinear.Bilinear;
import java.awt.image.BufferedImage;

/**
 *
 * @author mikko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ResizedImageCreator cr = new ResizedImageCreator();
        Bilinear bilinear = new Bilinear();
        BufferedImage originalImage = cr.openImage();
        
        //Parameters hardcoded at this stage for testing
        BufferedImage bilinearmodifiedImage = bilinear.resizeBufferedImageWithBilinearInterpolation(originalImage, 3f, 3f);
        
        //Create new image
        cr.saveImage("bilinear-2", bilinearmodifiedImage);
    }
    
}
