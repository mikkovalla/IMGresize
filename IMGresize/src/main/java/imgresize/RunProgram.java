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
import performance.Performance;

/**
 * Class combines the methods under single method to run the program
 *
 * @author mikko
 */
public class RunProgram {

    ResizedImageCreator cr;
    Bilinear bilinear;
    ImgScalr imgScalr;
    Performance performance1 = new Performance();
    Performance performance2 = new Performance();
    

    /**
     * Constructor to create needed instances
     *
     */
    public RunProgram() {
        this.cr = new ResizedImageCreator();
        this.bilinear = new Bilinear();
        this.imgScalr = new ImgScalr();
    }

    /**
     * Method to run the program
     */
    public void run() {
        BufferedImage originalImage = this.cr.openImage();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please give the first value --> ");
        float value1 = scanner.nextInt();
        System.out.println("-------------------------------");
        System.out.print("Please give the second value --> ");
        float value2 = scanner.nextInt();
        System.out.println("--------------------------------");

        //Run algorithms and take the time.
        System.out.println("    *********** Running resizing algorithms *************       ");
        performance1.start();
        BufferedImage bilinearmodifiedImage = this.bilinear.resizeBufferedImageWithBilinearInterpolation(originalImage, value1, value2);
        performance1.end();
        performance2.start();
        BufferedImage scalrModifiedImage = this.imgScalr.createWithScalr(originalImage, value1, value2);
        performance2.end();
        
        //Create new image
        this.cr.saveImage("bilinear", bilinearmodifiedImage);
        System.out.println("Running time: " + performance1.timeDifference() + " ms");
          
        this.cr.saveImage("scalr", scalrModifiedImage);
        System.out.println("Running time: " + performance2.timeDifference() + " ms");
    }
}
