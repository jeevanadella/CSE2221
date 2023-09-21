import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple toStringWithCommas program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class toStringWithCommas {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private toStringWithCommas() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("Hello World!");
        out.close();
    }

}
