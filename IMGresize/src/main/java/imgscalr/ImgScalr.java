
package imgscalr;

import java.awt.image.BufferedImage;
import org.imgscalr.Scalr;

/**
 * Class that uses ImgScalr library for image manipulation
 *
 * @author mikko
 */
public class ImgScalr {

    /**
     * Method to create a resized image using ImgScalr librarys Balanced method
     *
     * 
     * @param image Buffered image to be resized
     * @param horisontal float value for width
     * @param vertical float value for height
     * @return resized buffered image object
     */
    public BufferedImage createWithScalr(BufferedImage image, float horisontal, float vertical) {
        
        //Parametrinä saadun kuvan leveys - Image width
        int width = (int) (image.getWidth() * horisontal);
        //Parametrinä saadun kuvan korkeus - Image height
        int height = (int) (image.getHeight() * vertical);
        
        BufferedImage newImage = Scalr.resize(image, Scalr.Method.BALANCED, width, height);
        return newImage;
    }
}
