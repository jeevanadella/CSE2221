import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code NaturalNumber}.
 *
 * @author Jeevan Nadella
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

//        initializes numbers to be evaluated and return var
        NaturalNumber num1 = new NaturalNumber2();
        NaturalNumber num2 = new NaturalNumber2();
        NaturalNumber answer = new NaturalNumber2();

//        error statements
        String subtractionErr = "You can't subtract by a larger number in NaturalNumber.";
        String divisionErr = "You can't divide by zero.";

//        sets values to two numbers to be evaluated
        while (exp.numberOfChildren() != 0) {
            if (!exp.child(0).hasAttribute("value")) {
                num1 = evaluate(exp.child(0));
            } else {
                num1 = new NaturalNumber2(exp.child(0).attributeValue("value"));
            }

            if (exp.numberOfChildren() > 1) {
                if (!exp.child(1).hasAttribute("value")) {
                    num2 = evaluate(exp.child(1));
                } else {
                    num2 = new NaturalNumber2(
                            exp.child(1).attributeValue("value"));
                }

//        operations depending on parent (including error statements)
                if (exp.label().equals("plus")) {
                    num1.add(num2);
                } else if (exp.label().equals("minus")) {
                    if (num2.compareTo(num1) > 0) {
                        Reporter.fatalErrorToConsole(subtractionErr);
                    }
                    num1.subtract(num2);
                } else if (exp.label().equals("times")) {
                    num1.multiply(num2);
                } else if (exp.label().equals("divide")) {
                    if (num2.isZero()) {
                        Reporter.fatalErrorToConsole(divisionErr);
                    }
                    num1.divide(num2);
                }
            }
        }

        answer.copyFrom(num1);

//        returns answer
        return answer;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
