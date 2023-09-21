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
public final class Square {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Square() {
    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        /*
         * Put your code for square here
         */
        final int square = 2;
        n.power(square);
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
         * Put your main program code here
         */
        final int natNum = 10;
        NaturalNumber n = new NaturalNumber2(natNum);
        out.println("before: " + n);
        square(n);
        out.println("after: " + n);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
