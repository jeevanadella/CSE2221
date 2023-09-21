import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeExploration {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private XMLTreeExploration() {
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
        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");
        /* out.print(xml); */
        xml.display();
        boolean tagOrNot = xml.isTag();
        if (tagOrNot) {
            out.println("The root node of the XMLTree xml is a tag.");
        } else {
            out.println("The root node of the XMLTree xml is not a tag.");
        }
        out.println("The label of the root of the XMLTree xml is " + xml.label()
                + ".");
        XMLTree results = xml.child(0);
        XMLTree channel = results.child(0);
        int channelChildren = channel.numberOfChildren();
        out.println(
                "The XMLTree channel has " + channelChildren + " children.");
        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);
        out.println("The text child of the root node of the title XMLTree is "
                + titleText + ".");
        out.println("The text child of the root node of the title XMLTree is "
                + xml.child(0).child(0).child(1).child(0) + ".");
        final int posAstronomy = 10;
        XMLTree astronomy = channel.child(posAstronomy);
        boolean hasSunset = astronomy.hasAttribute("sunset");
        if (hasSunset) {
            out.println("The astronomy XMLTree has an attribute named sunset.");
        } else {
            out.println(
                    "The astronomy XMLTree does not have an attribute named sunset.");
        }
        boolean hasMidday = astronomy.hasAttribute("midday");
        if (hasMidday) {
            out.println("The astronomy XMLTree has an attribute named midday.");
        } else {
            out.println(
                    "The astronomy XMLTree does not have an attribute named midday.");
        }
        out.println("The value of the sunrise attribute is "
                + astronomy.attributeValue("sunrise") + ".");
        out.println("The value of the sunset attribute is "
                + astronomy.attributeValue("sunset") + ".");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
