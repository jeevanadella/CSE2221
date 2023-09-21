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
public final class CoinChange2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange2() {
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
        final int numCoin = 6;
        final int nickel = 5;

        out.print("Enter a monetary value(#.##): ");
        double money = in.nextDouble() + errAdj;

        int[] numCoins = new int[numCoin];
        double[] denom = { 1, halfDoll, quart, dim, nick, pen };
        final int maxRange = 5;
        for (int i = 0; i <= maxRange; i++) {
            numCoins[i] = (int) (money / denom[i]);
            money = money - (numCoins[i] * denom[i]);
        }

        out.println("You will receieve " + numCoins[0] + " dollar coin(s), "
                + numCoins[1] + " half dollar coin(s), " + numCoins[2]
                + " quarter(s), " + numCoins[(int) (3 * pen)] + " dime(s), "
                + numCoins[(int) (4 * pen)] + " nickel(s), and "
                + numCoins[nickel] + " penny(s).");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
