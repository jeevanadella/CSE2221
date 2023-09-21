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
public final class MakeFeeds {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private MakeFeeds() {
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

        SimpleWriter outFile = new SimpleWriter1L("feeds.xml");

        outFile.println("<?xml version='1.0' encoding='utf-8'?>");
        outFile.println("<feeds title='Top Stories'>");
        outFile.println(
                "<feed url=\'https://www.nasa.gov/rss/dyn/breaking_news.rss\' name=\'NASA Breaking News & Other\' file=\'nasa.html\'/>");
        outFile.println(
                "<feed url=\'http://feeds.arstechnica.com/arstechnica/index.rss\' name=\'Ars Technica\' file=\'ars.html\'/>");
        outFile.println(
                "<feed url=\'https://rss.packetstormsecurity.com/news/\' name=\'News - Packet Storm\' file=\'packetstorm.html\'/>");
        outFile.println(
                "<feed url=\'https://www.osu.edu/rss.php?feed=Features&limit=10\' name=\'Ohio State University Features\' file=\'osu.html\'/>");
        outFile.println("</feeds>");

        in.close();
        out.close();
        outFile.close();
    }

}
