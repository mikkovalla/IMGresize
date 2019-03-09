package Testimgresize;

import imgresize.ResizedImageCreator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for ResizeImageCreator class
 *
 * @author mikko
 */
public class ResizedImageCreatorTest {

    private File file;
    private BufferedImage image;
    private final String fileName = "eka";

    /**
     * Test of openImage method, of class ResizedImageCreator. Scanner class
     * reading of user input has been simulated by harcoded file name
     *
     * @throws java.io.IOException
     */
    @Test
    public void testOpenImage() throws IOException {
        System.out.println("openImage");
        this.file = new File(System.getProperty("user.dir") + "//src//main//resources//" + this.fileName + ".jpg");
        this.image = ImageIO.read(this.file);

        BufferedImage expResult = this.image;
        BufferedImage result = ImageIO.read(new File(System.getProperty("user.dir") + "//src//main//resources//" + this.fileName + ".jpg"));
        assertEquals(expResult.getHeight(), result.getHeight());
    }

    /**
     * Test of saveImage method, of class ResizedImageCreator.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testSaveImage() throws IOException {
        System.out.println("saveImage");
        String methodName = "kakkakikkare";

        ResizedImageCreator instance = new ResizedImageCreator();
        this.file = new File(System.getProperty("user.dir") + "//src//main//resources//" + this.fileName + ".jpg");
        this.image = ImageIO.read(this.file);
        BufferedImage img = this.image;
        instance.saveImage(methodName, img);

        File newImageFile = new File(System.getProperty("user.dir") + "//" + this.fileName + "-" + methodName + ".jpg");

        if (!newImageFile.toString().contains(this.fileName + "-" + methodName)) {
            fail("Image name is wrong!");
        }
    }
}
