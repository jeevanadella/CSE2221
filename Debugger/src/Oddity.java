import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Oddity {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Oddity() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        final int[] values = { 8, -4, 3, 0, -5 };
        int i = 0;
        while (i < values.length) {
            int remainder = values[i] % 2;
            if (remainder == 1) {
                out.println("odd");
            } else {
                out.println("even");
            }
            i = i + 1;
        }
        in.close();
        out.close();
    }
}
