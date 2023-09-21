import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class HW2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW2() {
    }

    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        output.print("Number of points: ");
        int n = input.nextInteger();

        int ptsInInterval = 0, ptsInSubinterval = 0;

        Random rnd = new Random1L();

        while (ptsInInterval < n) {
            double x = rnd.nextDouble();
            ptsInInterval++;
            if (x < 0.5) {
                ptsInSubinterval++;
            }
        }

        double estimate = (100.0 * ptsInSubinterval) / ptsInInterval;
        output.println("Estimate of percentage: " + estimate + "%");

        input.close();
        output.close();
    }
}
