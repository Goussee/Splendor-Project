import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * Utility class to load images from files
 */
public final class ImageLoader {
    private final static Map<String, Image> images = new TreeMap<>();

    private ImageLoader() {
    }

    /**
     * Gets an image by filename. Images are cached, so no image is loaded twice
     */
    public static Image get(String filename) {
        if (images.containsKey(filename)) return images.get(filename);
        else return load(filename);
    }

    /**
     * Loads a file into the class and returns it
     * @param filename The location of the image file
     */
    private static Image load(String filename) {
        //System.out.println("Loading image \"" + filename + "\"...");
        try (InputStream inputStream = ImageLoader.class.getResourceAsStream(filename)) {
            if (inputStream != null) {
                Image image = ImageIO.read(inputStream);
                images.put(filename, image);
                //System.out.println("Successfully loaded image \"" + filename + "\"");
                return image;
            } else {
                throw new IOException("Null input stream");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not load image \"" + filename + "\"");
        }
        return null;
    }
}