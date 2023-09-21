import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program that takes a txt file as input and returns an html file with a
 * "glossary" of hyperlinked terms with their definitions.
 *
 * @author Jeevan Nadella
 *
 */
public final class Glossary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
    }

    /**
     * Inputs all terms and matching definitions in a map as well as all the
     * terms in a sequence.
     *
     * @param inFile
     *            given input file
     * @param termDef
     *            map with terms and definitions
     * @param terms
     *            sequence with terms
     * @replaces termDef
     * @replaces terms
     *
     */
    private static void getTerms(SimpleReader inFile,
            Map<String, String> termDef, Sequence<String> terms) {

        // initializes vars
        int count = 0;
        String term = "";
        String defLine = " ";
        String fullDef = "";

        // goes until file is at end (line by line)
        while (!inFile.atEOS()) {
            term = inFile.nextLine();
            terms.add(count, term);
            count++;
            defLine = " ";
            fullDef = "";

            // concatenates line(s) of definition in case there are multiple lines
            while (!defLine.equals("")) {
                defLine = inFile.nextLine();
                fullDef = fullDef.concat(defLine);
            }
            termDef.add(term, fullDef);
        }
    }

    /**
     * Alphabetizes the terms sequence.
     *
     * @param terms
     *            terms sequence
     * @replaces terms
     */
    private static void alphabetizeTerms(Sequence<String> terms) {

        // makes new sequence to tranfer terms to pull out one by one
        Sequence<String> terms2 = new Sequence1L<String>();
        terms2.transferFrom(terms);
        String next = "";
        int addPos = 0;

        // adds terms in alphabetical order to original sequence
        while (terms2.length() != 0) {
            int pos = 0;
            int nextPos = 0;
            while (pos < terms2.length() - 1) {
                next = terms2.entry(nextPos);
                if (next.compareTo(terms2.entry(pos + 1)) > 0) {
                    nextPos = pos + 1;
                }
                pos++;
            }
            terms.add(addPos, terms2.entry(nextPos));
            terms2.remove(nextPos);
            addPos++;
        }
    }

    /**
     * Alphabetizes terms and definitions map.
     *
     * @param termDef
     *            terms and definitions map
     * @param terms
     *            terms sequence
     * @replaces termDef
     */
    private static void alphabetizeMap(Map<String, String> termDef,
            Sequence<String> terms) {
        Map<String, String> copy = new Map1L<String, String>();
        int pos = 0;
        while (pos < terms.length()) {
            copy.add(terms.entry(pos), termDef.value(terms.entry(pos)));
            pos++;
        }
        termDef.transferFrom(copy);
    }

    /**
     * Outputs opening tags for HTML file.
     *
     * @param terms
     *            terms sequence
     * @param out
     *            output stream
     */
    private static void outputIndex(Sequence<String> terms, SimpleWriter out) {

        // prints opening tags
        out.println("<?xml version='1.0' encoding='ISO-8859-1' ?>");
        out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN'"
                + " 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>");
        out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type'"
                + " content='text/html; charset=ISO-8859-1' />");

        // prints title
        out.println("<title>Glossary</title>");

        // prints more opening tags
        out.println("</head>");
        out.println("<h2>Glossary</h2>");
        out.println("<h3>Index</h3>");
        out.println("<ul>");

        int i = 0;
        while (i < terms.length()) {
            String term = terms.entry(i);
            out.println("<li><a href=\"" + term + ".html" + "\">" + term
                    + "</a></li>");
            i++;
        }

        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Outputs the opening tags in the generated HTML file.
     *
     * @param termDef
     *            terms and definitions map
     * @param terms
     *            the Sequence of terms
     */
    private static void outputDefs(Map<String, String> termDef,
            Sequence<String> terms) {
        int count = 0;
        String fileName = "";
        while (count < terms.length()) {
            // creates html file for each term
            fileName = terms.entry(count);
            SimpleWriter j = new SimpleWriter1L(fileName + ".html");

            // prints opening tags
            j.println("<?xml version='1.0' encoding='ISO-8859-1' ?>");
            j.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN'"
                    + " 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>");
            j.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
            j.println("<head>");
            j.println("<meta http-equiv='Content-Type'"
                    + " content='text/html; charset=ISO-8859-1' />");

            // prints title
            j.println("<title>" + terms.entry(count) + "</title>");

            // prints more opening tags
            j.println("</head>");
            j.println("<h2><b><i><font color=\"red\">" + terms.entry(count)
                    + "</font></i></b></h2>");
            j.println("<blockquote>" + termDef.value(terms.entry(count))
                    + "</blockquote>");
            j.println("<p>Return to <a href=\"index.html\">index</a></p>");
            j.println("</body>");
            j.println("</html>");
            j.close();
            count++;
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separatorSet) {
        assert text != null : "Violation of: text is not null";
        assert separatorSet != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        // initializes vars
        int count = 0;
        char returnedPiece;
        String returned = "";

        // checks if separator is contained
        if (separatorSet.contains(text.charAt(position))) {
            while (count < text.substring(position, text.length()).length()) {
                returnedPiece = text.charAt(position + count);
                // takes word after separator if separator is there
                if (separatorSet.contains(text.charAt(position + count))) {
                    returned = returned + returnedPiece;
                    count++;
                } else {
                    count = text.substring(position, text.length()).length();
                }
            }
            count = 0;
        } else {
            while (count < text.substring(position, text.length()).length()) {
                returnedPiece = text.charAt(position + count);
                // returns separator
                if (!separatorSet.contains(text.charAt(position + count))) {
                    returned = returned + returnedPiece;
                    count++;
                } else {
                    count = text.substring(position, text.length()).length();
                }
            }
            count = 0;
        }
        return returned;
    }

    /**
     * Creates set to be used to separate words.
     *
     * @param separator
     *            given separator
     * @param separatorSet
     *            set to be replaced
     * @replaces separatorSet
     */
    private static void getElements(String separator,
            Set<Character> separatorSet) {

        // initializes (and clears) vars
        int pos = 0;
        char setChar;
        separatorSet.clear();

        // creates set with characters used to separate words
        while (pos < separator.length()) {
            if (!separatorSet.contains(separator.charAt(pos))) {
                setChar = separator.charAt(pos);
                separatorSet.add(setChar);
            }
            pos++;
        }
    }

    /**
     * Updates map with hyperlinks for words appearing in definitions.
     *
     * @param termDef
     *            terms and definitions map
     * @param terms
     *            terms sequence
     * @param separatorSet
     *            set used to separate terms
     */
    private static void addLinks(Map<String, String> termDef,
            Sequence<String> terms, Set<Character> separatorSet) {

        // initializes vars
        Map<String, String> termDefCopy = new Map1L<String, String>();
        Set<String> terms2 = new Set1L<String>();
        String testCopy = "";
        int pos = 0;
        int count = 0;
        int size = terms.length();

        // adds terms from original map into a set
        while (terms2.size() < size) {
            testCopy = terms.remove(count);
            terms2.add(testCopy);
            terms.add(count, testCopy);
            count++;
        }

        count = 0;
        testCopy = "";

        // adds hyperlinks for words with definitions
        while (count < terms2.size()) {
            pos = 0;
            testCopy = "";
            String testStr = termDef.value(terms.entry(count));
            while (pos < testStr.length()) {
                String word = nextWordOrSeparator(testStr, pos, separatorSet);
                if (separatorSet.contains(word.charAt(0))) {
                    testCopy = testCopy + word;
                } else if (terms2.contains(word)) {
                    testCopy = testCopy + "<a href=\"" + word + ".html\">"
                            + word + "</a>";
                } else {
                    testCopy = testCopy.concat(word);
                }
                pos += word.length();
            }
            termDefCopy.add(terms.entry(count), testCopy);
            count++;
        }
        termDef.transferFrom(termDefCopy);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        // open input and output
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // ask for input file
        out.println("Insert name of input file: ");
        SimpleReader inFile = new SimpleReader1L(in.nextLine());

        // ask for output folder name
        out.println("Insert name of output file: ");
        String outFile = in.nextLine();

        // creates empty map and sequence
        Map<String, String> termDef = new Map1L<String, String>();
        Sequence<String> terms = new Sequence1L<String>();
        getTerms(inFile, termDef, terms);

        // sorts terms in alphabetical order
        alphabetizeTerms(terms);

        // rearranges map in alphabetical order
        alphabetizeMap(termDef, terms);

        // update terms in map to have hyperlinked terms in definitions
        final String separator = " \t, ";
        Set<Character> separatorSet = new Set1L<Character>();
        getElements(separator, separatorSet);
        addLinks(termDef, terms, separatorSet);

        // creates main page
        SimpleWriter index = new SimpleWriter1L(outFile + ".html");
        outputIndex(terms, index);
        index.close();

        // creates definition pages
        outputDefs(termDef, terms);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
        inFile.close();
    }
}
