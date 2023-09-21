import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * free workspace
 *
 * @author jeevan
 */
public final class HelloWorld {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HelloWorld() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        Map<String, Integer> m = new Map1L<>();

        String k = "PB";
        int v = 99;
        m.add(k, v);

        out.println(m);

        Map.Pair<String, Integer> p = m.removeAny();
        out.println(m);

        m.add(p.key(), p.value());
        out.println(m);

        out.close();
    }

}
