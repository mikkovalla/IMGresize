package imgresize;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Class provides methods to read original image and save modified version using
 *
 * @see imgresize.Main
 *
 * @author mikko
 */
public class ResizedImageCreator {

    OriginalImageLocationReader reader = new OriginalImageLocationReader();
    private File file;
    private BufferedImage image;
    private String fileName = "";


    /**
     * Method reads image from disk
     *
     * @return Buffered image object.
     */
    public BufferedImage openImage() {
        try {
            this.fileName = reader.readOriginalImageNameFromDisk();
            this.file = new File(System.getProperty("user.dir") + "//" + this.fileName + ".jpg");
            System.out.println("Image file found at: " + this.file.toString());
            this.image = ImageIO.read(this.file);
            System.out.println("Image read succesfully!");
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return this.image;
    }

    /**
     * Method saves new resized image to disk
     *
     * @param methodName name of the method used to resize the given image to
     * distinguish between different files.
     * @param img Buffered image object to be saved returned by the used resizing algorithm
     */
    public void saveImage(String methodName, BufferedImage img) {
        try {
            //Redundant line. Have to refractor to use this.file object literal.
            File newImageFile = new File(System.getProperty("user.dir") + "//" + this.fileName + "-" + methodName + ".jpg");
            System.out.println(newImageFile.toString());
            ImageIO.write(img, "jpg", newImageFile);
            System.out.println("New image succesfully created at " + newImageFile.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Something went wrong! " + ex);
        }
    }
}
