/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgresize;

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
        BufferedImage bi = cr.openImage();
        cr.saveImage("bilinear", bi);
    }
    
}
