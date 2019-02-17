package imgresize;

import datastructure.MyArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import performance.Performance;

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
    FileFinder fileFinder = new FileFinder();
    private final String start = System.getProperty("user.dir");
    MyArrayList<File> myFiles = new MyArrayList<>();
    Performance performance = new Performance();

    /**
     * Method reads image from disk
     *
     * @return Buffered image object.
     */
    public BufferedImage openImage() {
        try {
            System.out.println("Image files found: ");
            fileFinder.findImageFiles(start, this.myFiles);
            fileFinder.tulosta();
            System.out.println("-----------------------------------------------------------------");
            System.out.print("Which one would you like to resize?");
            System.out.println(" -> please write the exact file name including extension - Otherwise the program will select the first image file available");

            this.fileName = reader.readOriginalImageNameFromDisk();
            this.file = new File(fileFinder.getImageFilePath(this.fileName));
            System.out.println("Image file found at: " + this.file.toString());
            System.out.println("Original image size: " + performance.fileSizeInKiloBytes(this.file));

            this.image = ImageIO.read(this.file);
            System.out.println("Image source read succesfully!");

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
     * @param img Buffered image object to be saved returned by the used
     * resizing algorithm
     */
    public void saveImage(String methodName, BufferedImage img) {
        try {
            //Redundant line. Have to refractor to use this.file object literal.
            File newImageFile = new File(System.getProperty("user.dir") + "//" + methodName + "-" + this.fileName + ".jpg");

            ImageIO.write(img, "jpg", newImageFile);
            System.out.println("            **********************             ");
            System.out.println("New image succesfully created at " + newImageFile.getPath());
            System.out.println("New image size with method " + methodName + ": " + performance.fileSizeInKiloBytes(newImageFile));
        } catch (IOException ex) {
            System.out.println("Something went wrong! " + ex);
        }
    }
}
