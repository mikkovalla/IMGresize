package imgresize;

import java.util.Scanner;

/**
 * /*
 * Class contains method(s) to read original image location source given by the
 * user. At the moment it only contains method to read from disk. Reading a URL
 * is to be added.
 *
 * @see imgresize.ResizedImageCreator
 * 
 * @author mikko
 */
public class OriginalImageLocationReader {

    /**
     * Method creates a Scanner object to read user input
     *
     * @return String image name.
     */
    public String readOriginalImageNameFromDisk() {
        try {
            Scanner scanner = new Scanner(System.in);
            String source = scanner.nextLine();
            return source;
        } catch (Exception ex) {
            return "Something went wrong, please try again. Error: " + ex;
        }
    }
}
