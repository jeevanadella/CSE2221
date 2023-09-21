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
public final class CheckPassword {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param passwordCandidate
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String passwordCandidate,
            SimpleWriter out) {
        /*
         * Put your code for myMethod here
         */
        final int lenReq = 8;

        if (passwordCandidate.length() >= lenReq) {
            out.println("The password satisfies the length requirement.");
        } else {
            out.println(
                    "The password does not satisfy the length requirement.");
        }
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param passwordCandidate
     *            the String to check
     * @return true
     */
    private static boolean containsUpperCaseLetter(String passwordCandidate) {
        boolean upperResult = false;
        for (int i = 0; i <= passwordCandidate.length() - 1; i++) {
            boolean upperCase = Character
                    .isUpperCase(passwordCandidate.charAt(i));
            if (upperCase) {
                upperResult = true;
            }
        }
        return upperResult;
    }

    /**
     * Checks if the given String contains a lower case letter.
     *
     * @param passwordCandidate
     *            the String to check
     * @return true
     */
    private static boolean containsLowerCaseLetter(String passwordCandidate) {
        boolean lowerResult = false;
        for (int i = 0; i <= passwordCandidate.length() - 1; i++) {
            boolean lowerCase = Character
                    .isLowerCase(passwordCandidate.charAt(i));
            if (lowerCase) {
                lowerResult = true;
            }
        }
        return lowerResult;
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param passwordCandidate
     *            the String to check
     * @return true
     */
    private static boolean containsDigit(String passwordCandidate) {
        boolean digitResult = false;
        for (int i = 0; i <= passwordCandidate.length() - 1; i++) {
            boolean digitCase = Character.isDigit(passwordCandidate.charAt(i));
            if (digitCase) {
                digitResult = true;
            }
        }
        return digitResult;
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
        out.println("Enter a password candidate: ");
        String passwordCandidate = in.nextLine();

        checkPassword(passwordCandidate, out);

        boolean upperCase = containsUpperCaseLetter(passwordCandidate);
        if (upperCase) {
            out.println(
                    "The password satisfies the upper case letter requirement.");
        } else {
            out.println(
                    "The password does not satisfy the upper case letter requirement.");
        }

        boolean lowerCase = containsLowerCaseLetter(passwordCandidate);
        if (lowerCase) {
            out.println(
                    "The password satisfies the lower case letter requirement.");
        } else {
            out.println(
                    "The password does not satisfy the lower case letter requirement.");
        }

        boolean digitCase = containsDigit(passwordCandidate);
        if (digitCase) {
            out.println("The password satisfies the digit requirement.");
        } else {
            out.println("The password does not satisfy the digit requirement.");
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
