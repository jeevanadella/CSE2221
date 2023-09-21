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
public final class Hailstone2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone2() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod(int n, SimpleWriter out) {
        out.print(n + " ");
        int i = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                out.print(n + " ");
                i++;
            } else {
                n = (3 * n) + 1;
                out.print(n + " ");
                i++;
            }
        }
        out.println();
        out.print("There are " + i + " terms in the series.");
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

        out.print("Enter a number: ");
        int n = in.nextInteger();
        int i = 1;

        myMethod(n, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
