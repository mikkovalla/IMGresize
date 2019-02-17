/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgresize;

import imgresize.bilinear.Bilinear;
import imgscalr.ImgScalr;
import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 * Class combines the methods under single method to run the program
 *
 * @author mikko
 */
public class RunProgram {

    ResizedImageCreator cr;
    Bilinear bilinear;
    ImgScalr imgScalr;

    /**
     * Constructor to create needed instances
     *
     */
    public RunProgram() {
        cr = new ResizedImageCreator();
        bilinear = new Bilinear();
        imgScalr = new ImgScalr();
    }

    /**
     * Method to run the program
     */
    public void run() {
        BufferedImage originalImage = cr.openImage();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please give the first value --> ");
        float value1 = scanner.nextInt();
        System.out.println("-------------------------------");
        System.out.print("Please give the second value --> ");
        float value2 = scanner.nextInt();
        System.out.println("--------------------------------");
        //Parameters hardcoded at this stage for testing
        System.out.println("    *********** Running resizing algorithms *************       ");
        BufferedImage bilinearmodifiedImage = bilinear.resizeBufferedImageWithBilinearInterpolation(originalImage, value1, value2);
        BufferedImage scalrModifiedImage = imgScalr.createWithScalr(originalImage, value1, value2);

        //Create new image
        cr.saveImage("bilinear", bilinearmodifiedImage);
        cr.saveImage("scalr", scalrModifiedImage);
    }
}
