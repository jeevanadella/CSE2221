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
public final class CoinChange1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange1() {
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
        final double errAdj = 0.001;
        final double halfDoll = 0.5;
        final double quart = 0.25;
        final double dim = 0.1;
        final double nick = 0.05;
        final double pen = 0.01;

        out.print("Enter a monetary value(#.##): ");
        double money = in.nextDouble() + errAdj;

        int dollar = (int) money;
        money = money - dollar;
        int halfDollar = (int) (money / halfDoll);
        money = money - (halfDollar * halfDoll);
        int quarter = (int) (money / quart);
        money = money - (quarter * quart);
        int dime = (int) (money / dim);
        money = money - (dime * dim);
        int nickel = (int) (money / nick);
        money = money - (nickel * nick);
        int penny = (int) (money / pen);
        money = money - (penny * pen);

        out.println("You will receieve " + dollar + " dollar coin(s), "
                + halfDollar + " half dollar coin(s), " + quarter
                + " quarter(s), " + dime + " dime(s), " + nickel
                + " nickel(s), and " + penny + " penny(s).");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
