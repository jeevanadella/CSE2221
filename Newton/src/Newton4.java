import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Calculates the square root of a user-input double using the Newton iteration.
 *
 * @author Jeevan Nadella
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Takes in the values the method is called with (value to take square root
     * of and allowed error) and uses it and an "estimate" (set to be 1 greater
     * than the value the method is called with) to perform the Newton
     * iteration.
     *
     * @param x
     * @param e
     *
     * @return r
     */
    private static double sqrt(double x, double e) {
        /*
         * Put your code for myMethod here
         */
        double r = x + 1;
        while ((Math.abs((Math.pow(r, 2)) - x) / x) >= Math.pow(e, 2)) {
            r = ((r + (x / r)) / 2);
        }
        return r;
    }

    /**
     * Main method.
     *
     * takes in user input for number to take square root of and accepted error,
     * calls method with input value, prints calculated value to screen (unless
     * input is 0, then prints 0 to screen), asks user for another input:
     * positive value read as permission to run again, negative value read as
     * indication to quit
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
        double n = 1;

        while (n >= 0) {
            out.print("Enter a number to calculate the square root of: ");
            n = in.nextDouble();
            if (n >= 0) {
                out.print("Enter an acceptable error (from 0 to 1): ");
                double e = in.nextDouble();
                if (n == 0) {
                    out.println("The square root of your number is 0.");
                } else {
                    n = sqrt(n, e);
                    out.println("The square root of your number is " + n + ".");
                }
            }
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
