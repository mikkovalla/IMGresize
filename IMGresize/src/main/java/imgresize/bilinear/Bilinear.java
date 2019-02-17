package imgresize.bilinear;

import java.awt.image.BufferedImage;

/**
 * Class to resize image with bilinear algoritm
 *
 * Code and helper sources:
 * https://stackoverflow.com/questions/11380062/what-does-value-0xff-do-in-java
 * https://android.jlelse.eu/java-when-to-use-n-8-0xff-and-when-to-use-byte-n-8-2efd82ae7dd7
 * https://stackoverflow.com/questions/6126439/what-does-0xff-do/6126582
 * https://stackoverflow.com/questions/11421905/java-integer-to-byte-and-byte-to-integer
 * https://stackoverflow.com/questions/842817/how-does-java-convert-int-into-byte
 * https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
 * https://stackoverflow.com/questions/14713102/what-does-and-0xff-do
 * http://strauss.pas.nu/js-bilinear-interpolation.html
 * https://www.codementor.io/tips/7814203938/resize-an-image-with-bilinear-interpolation-without-imresize
 * https://en.wikipedia.org/wiki/Bilinear_interpolation
 * https://stackoverflow.com/questions/30182467/how-to-implement-linear-interpolation-method-in-java-array
 * https://stackoverflow.com/questions/4353525/floating-point-linear-interpolation?noredirect=1&lq=1
 * https://unity3d.com/es/learn/tutorials/topics/scripting/linear-interpolation
 * https://gisgeography.com/bilinear-interpolation-resampling/
 * https://gist.github.com/NickBeeuwsaert/5753386
 * https://www.scratchapixel.com/lessons/mathematics-physics-for-computer-graphics/interpolation/bilinear-filtering
 *
 * @author mikko
 */
public class Bilinear {

    public int getBits(int number, int n) {
        return (number >> (n * 8)) & 0xFF;
    }

    /**
     * Method performs linear interpolation of parameters. Method receives 3
     * float parameters:
     *
     * @param a: the value from which to interpolate
     * @param b: the value to interpolate to
     * @param f: value of how far we interpolate
     * @return float value of linear interpolation based on parameters.
     */
    public float linearInterpolation(float a, float b, float f) {
        return a + f * (b - a);
    }

    /**
     * Method performs bilinear interpolation of parameters. Method receives 6
     * float parameters:
     *
     * @param firstValueToInterpolateFrom
     * @param firstValueInterpolateTo
     * @param secondValueToInterpolateFrom
     * @param secondValueInterpolateTo
     * @param firstHowFarToInterpolate
     * @param secondHowFarToInterpolate
     * @return float value of linear interpolation based on parameters.
     */
    public float bilinearInterpolation(float firstValueToInterpolateFrom, float firstValueInterpolateTo, float secondValueToInterpolateFrom, float secondValueInterpolateTo, float firstHowFarToInterpolate, float secondHowFarToInterpolate) {
        return linearInterpolation(linearInterpolation(firstValueToInterpolateFrom, firstValueInterpolateTo, firstHowFarToInterpolate), linearInterpolation(secondValueToInterpolateFrom, secondValueInterpolateTo, firstHowFarToInterpolate), secondHowFarToInterpolate);
    }

    /**
     * Method performs bilinear image resizing.
     *
     * @param image Buffered image object
     * @param horisontal float value for width 
     * @param vertical flaot value for height
     * @return Bilinear interpolated image
     */
    public BufferedImage resizeBufferedImageWithBilinearInterpolation(BufferedImage image, float horisontal, float vertical) {
        //Parametrinä saadun kuvan leveys - Image width
        int width = (int) (image.getWidth() * horisontal);
        //Parametrinä saadun kuvan korkeus - Image height
        int height = (int) (image.getHeight() * vertical);

        //Uusi Buffered kuva olio jolle suoritetaan bilineaarinen interpolaatio - New Buffered image instance to which the algo underneath performs bilinear interpolation
        //Constructor requires an Buffered image instance,hence image.getType() method is used 
        BufferedImage BilenearInterpolatedImage = new BufferedImage(width, height, image.getType());

        //Algoritmi alkaa tästä - Algorithm starts here.
        //Ulompi for looppi iteroi kuvan leveyden mukaan - Loop iterates by image width
        for (int x = 0; x < width; ++x) {
            //Sisempi for looppi iteroi kuvan korkeuden mukaan - Loop iterates by image height
            for (int y = 0; y < height; ++y) {

                //Pixel position computation - pixelin sijainnin laskenta
                float widthX = ((float) x) / width * (image.getWidth() - 1);
                float heightY = ((float) y) / height * (image.getHeight() - 1);
                
                //Float type conversion to Int for RGB - Float tyypin konversio Int tyyppiseksi RGB arvoja varten. Konversio metodissa ei toiminut.
                int widthXIntegerValue = (int) widthX;
                int heightYIntegerValue = (int) heightY;

                int rgbColor = 0;

                //Kuvan värit - Image colours
                // color pixel value at pixel position 0 - 0
                int rgbValueAtPostionWidth0Height0 = image.getRGB(widthXIntegerValue, heightYIntegerValue);
                // color pixel value at position 1 - 0
                int rgbValueAtPostionWidthPlus1Height0 = image.getRGB(widthXIntegerValue + 1, heightYIntegerValue);
                // color pixel value at position 0 - 1
                int rgbValueAtPostionWidth0HeightPlus1 = image.getRGB(widthXIntegerValue, heightYIntegerValue + 1);
                // color pixel value at position 1 - 1
                int rgbValueAtPostionWidthPlus1HeightPlus1 = image.getRGB(widthXIntegerValue + 1, heightYIntegerValue + 1);

                //Linear inpterpolation of RGB values
                for (int i = 0; i <= 2; ++i) {
                    float liValueOfWidth0Height0 = getBits(rgbValueAtPostionWidth0Height0, i);
                    float liValueOfWidth1Height0 = getBits(rgbValueAtPostionWidthPlus1Height0, i);
                    float liValueOfWidth0Height1 = getBits(rgbValueAtPostionWidth0HeightPlus1, i);
                    float liValueOfWidth1Height1 = getBits(rgbValueAtPostionWidthPlus1HeightPlus1, i);
                    
                    //Compute bilinear interpolation value
                    int bilinearInterpolationValue = ((int) bilinearInterpolation(liValueOfWidth0Height0, liValueOfWidth1Height0, liValueOfWidth0Height1, liValueOfWidth1Height1, widthX - widthXIntegerValue, heightY - heightYIntegerValue)) << (8 * i);

                    //bitwise OR operation -> https://stackoverflow.com/questions/3312611/pipe-operator-in-java                   
                    rgbColor = rgbColor | bilinearInterpolationValue;
                }
                //Sets new RGB value of the Buffered image
                BilenearInterpolatedImage.setRGB(x, y, rgbColor);
            }
        }
        return BilenearInterpolatedImage;
    }
}
