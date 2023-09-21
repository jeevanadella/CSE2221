import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Jeevan Nadella
 *
 */
public final class Hailstone1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        /*
         * Put your code for myMethod here
         */
        out.print(n + " ");
        final NaturalNumber h = new NaturalNumber2(3);
        final NaturalNumber t = new NaturalNumber2(2);
        final NaturalNumber o = new NaturalNumber2(1);
        final NaturalNumber z = new NaturalNumber2(0);
        NaturalNumber r = n.divide(t);
        while (r != o) {
            if (n.divide(t) == z) {
                out.print(n + " ");
            } else {
                n.multiply(t);
                n.multiply(h);
                n.add(o);
                out.print(n + " ");
            }
            r = n.divide(t);
        }
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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        int startNum = -1;
        while (startNum < 0) {
            out.println("Enter a natural number greater than 0: ");
            startNum = in.nextInteger();
        }
        NaturalNumber n = new NaturalNumber2(startNum);
        generateSeries(n, out);
        out.println(n);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
