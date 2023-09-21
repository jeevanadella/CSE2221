import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Uses the Jager formula to approximate a user-inputed positive real-valued
 * universal physical or mathematical constant within a fraction of 1% relative
 * error using four user-inputed numbers.
 *
 * @author Jeevan Nadella
 *
 */
public final class ABCDGuesser1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {

//      initializes vars
        String input;
        double inputNum = 0;
        boolean acceptable = false;

//      asks for input until appropriate input is given
        while (!acceptable) {
            out.println("Please input a positive real number: ");
            input = in.nextLine();

            if (FormatChecker.canParseDouble(input)) {
                inputNum = Double.parseDouble(input);
                acceptable = true;
            } else {
                out.println("Error: Input could not be read as a double.");
            }
        }

        return inputNum;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {

//        initializes vars
        String input;
        double inputNum = 0;
        boolean acceptable = false;

//        asks for input until appropriate input is given
        while (!acceptable) {
            out.println("Input a positive real number (not 1): ");
            input = in.nextLine();

            if (FormatChecker.canParseDouble(input)) {
                inputNum = Double.parseDouble(input);
                if (inputNum != 1) {
                    acceptable = true;
                } else {
                    out.println("Error: Cannot use 1.");
                }
            } else {
                out.println("Error: Input could not be read as a double.");
            }
        }

        return inputNum;
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

//        exponents from lab description
        final double[] dejagerExponents = { -5.0, -4.0, -3.0, -2.0, -1.0,
                -1.0 / 2, -1.0 / 3, -1.0 / 4, 0, 1.0 / 4, 1.0 / 3, 1.0 / 2, 1.0,
                2.0, 3.0, 4.0, 5.0 };

//        initializes vars and constants
        double userChoice = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        int a = 0, b = 0, c = 0, d = 0;
        double approx, closestApprox = 0;
        final double errSet = 1e10;
        double err = errSet;
        final int errToPercent = 100;
        final int three = 3;

        double[] errPts = { 0, 0, 0, 0 };

//        calculate w, x, y, z, and a, b, c, d
        while (a < dejagerExponents.length) {
            while (b < dejagerExponents.length) {
                while (c < dejagerExponents.length) {
                    while (d < dejagerExponents.length) {
                        approx = Math.pow(w, dejagerExponents[a])
                                * Math.pow(x, dejagerExponents[b])
                                * Math.pow(y, dejagerExponents[c])
                                * Math.pow(z, dejagerExponents[d]);
                        if (Math.abs(
                                (approx - userChoice) / userChoice) < err) {
                            err = Math.abs((approx - userChoice) / userChoice);
                            closestApprox = Math.pow(w, dejagerExponents[a])
                                    * Math.pow(x, dejagerExponents[b])
                                    * Math.pow(y, dejagerExponents[c])
                                    * Math.pow(z, dejagerExponents[d]);
                            errPts[0] = dejagerExponents[a];
                            errPts[1] = dejagerExponents[b];
                            errPts[2] = dejagerExponents[c];
                            errPts[three] = dejagerExponents[d];
                        }
                        d++;

                    }
                    c++;
                    d = 0;
                }
                b++;
                c = 0;
            }
            a++;
            b = 0;
        }

//        calculate percent error
        err *= errToPercent;

//        print results
        out.println();
        out.println();
        out.println("Number to approximate: " + userChoice);
        out.println("Approximation: " + closestApprox);
        out.println("Percent error: " + err);
        out.println();
        out.println("First input (w): " + w);
        out.println("Respective exponent (a): " + errPts[0]);
        out.println();
        out.println("Second input (x): " + x);
        out.println("Respective exponent (b): " + errPts[1]);
        out.println();
        out.println("Third input (y): " + y);
        out.println("Respective exponent (c): " + errPts[2]);
        out.println();
        out.println("Fourth input (z): " + z);
        out.println("Respective exponent (d): " + errPts[three]);
        out.println();

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
