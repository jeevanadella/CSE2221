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
public final class Newton2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton2() {
    }

    /**
     * Takes in the value the method is called with (value to take square root
     * of) and uses it and an "estimate" (set to be 1 greater than the value the
     * method is called with) to perform the Newton iteration.
     *
     * @param x
     *
     * @return r
     */
    private static double sqrt(double x) {
        /*
         * Put your code for myMethod here
         */
        final double err = 0.0001;
        double r = x + 1;
        while ((Math.abs((Math.pow(r, 2)) - x) / x) >= Math.pow(err, 2)) {
            r = ((r + (x / r)) / 2);
        }
        return r;
    }

    /**
     * Main method.
     *
     * takes in user input, calls method with input value, prints calculated
     * value to screen (unless input is 0, then prints 0 to screen), asks if
     * user wants to repeat
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
        String another = "y";

        while ((another.equals("y"))) {
            out.print("Enter a number to calculate the square root of: ");
            double n = in.nextDouble();
            if (n == 0) {
                out.println("The square root of your number is 0.");
            } else {
                n = sqrt(n);
                out.println("The square root of your number is " + n + ".");
            }
            out.print(
                    "Would you like to calculate another square root (y or n)? ");
            another = in.nextLine();

        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
