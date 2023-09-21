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
public final class Copy {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Copy() {
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        /*
         * Put your code for swapNN here
         */
        NaturalNumber temp = new NaturalNumber2(n1);
        n1.copyFrom(n2);
        n2.copyFrom(temp);

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
        final int firstNum = 10;
        final int secondNum = 20;
        NaturalNumber n1 = new NaturalNumber2(firstNum);
        NaturalNumber n2 = new NaturalNumber2(secondNum);
        out.println("before: " + n1 + ", " + n2);
        swapNN(n1, n2);
        out.println("after: " + n1 + ", " + n2);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
