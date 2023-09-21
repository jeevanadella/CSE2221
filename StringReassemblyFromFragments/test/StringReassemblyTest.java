import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

//    tests for combination

    @Test
    public void testCombination_planner() {
        String str1 = "plann";
        String str2 = "nner";
        int overlap = 2;
        String expected = "planner";
        String combine = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, combine);
    }

    @Test
    public void testCombination_cabinet() {
        String str1 = "cabi";
        String str2 = "inet";
        int overlap = 1;
        String expected = "cabinet";
        String combine = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, combine);
    }

//    tests for addToSetAvoidingSubstrings

    @Test
    public void testAddToSetAvoidingSubstrings1() {
        Set<String> strSet = new Set1L<>();
        strSet.add("hey");
        strSet.add("hello");
        strSet.add("come");
        String str = "welcome";
        Set<String> expect = new Set1L<>();
        expect.add("hey");
        expect.add("hello");
        expect.add("welcome");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(expect, strSet);
    }

    @Test
    public void testAddToSetAvoidingSubstrings2() {
        Set<String> strSet = new Set1L<>();
        strSet.add("perpendicular");
        strSet.add("pencil");
        strSet.add("indispensable");
        String str = "pen";
        Set<String> expect = new Set1L<>();
        expect.add("perpendicular");
        expect.add("pencil");
        expect.add("indispensable");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(expect, strSet);
    }

    @Test
    public void testAddToSetAvoidingSubstrings3() {
        Set<String> strSet = new Set1L<>();
        strSet.add("hilighter");
        strSet.add("marker");
        strSet.add("pen");
        String str = "pencil";
        Set<String> expect = new Set1L<>();
        expect.add("hilighter");
        expect.add("marker");
        expect.add("pencil");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(expect, strSet);
    }

//    tests for linesFromInput

    @Test
    public void testLinesFromInput() {
        Set<String> linesFromInput = new Set1L<String>();
        Set<String> expected = new Set1L<String>();
        SimpleReader input = new SimpleReader1L("cheer-8-2.txt");
        String str1 = "Bucks -- Beat";
        String str2 = "Go Bucks";
        String str3 = "o Bucks -- B";
        String str4 = "Beat Mich";
        String str5 = "ichigan~";
        String str6 = "Bucks";
        String str7 = "Michigan~";
        expected.add(str1);
        expected.add(str2);
        expected.add(str3);
        expected.add(str4);
        expected.add(str7);
        linesFromInput = StringReassembly.linesFromInput(input);
        assertEquals(expected, linesFromInput);
    }

//    tests for printWithLineSeparators

    @Test
    public void testPrintWithLineSeparators1() {
        SimpleWriter storeFile = new SimpleWriter1L("testout1.txt");
        SimpleWriter out = new SimpleWriter1L();
        String test = "Hey~how~are~you~doing~today";

        StringReassembly.printWithLineSeparators(test, storeFile);

        storeFile.close();

        SimpleReader outFile = new SimpleReader1L("testout1.txt");
        while (!outFile.atEOS()) {
            String str = outFile.nextLine();
            out.println(str);
        }
        outFile.close();
        out.close();
    }

    @Test
    public void testPrintWithLineSeparators2() {
        SimpleWriter storeFile = new SimpleWriter1L("testout2.txt");
        SimpleWriter out = new SimpleWriter1L();
        String test = "Hey how~are you~doing today";

        StringReassembly.printWithLineSeparators(test, storeFile);

        storeFile.close();

        SimpleReader outFile = new SimpleReader1L("testout2.txt");
        while (!outFile.atEOS()) {
            String str = outFile.nextLine();
            out.println(str);
        }
        outFile.close();
        out.close();
    }

    @Test
    public void testPrintWithLineSeparators3() {
        SimpleWriter storeFile = new SimpleWriter1L("testout3.txt");
        SimpleWriter out = new SimpleWriter1L();
        String test = "Hey~~how~~are~~you~~doing~~today";

        StringReassembly.printWithLineSeparators(test, storeFile);

        storeFile.close();

        SimpleReader outFile = new SimpleReader1L("testout3.txt");
        while (!outFile.atEOS()) {
            String str = outFile.nextLine();
            out.println(str);
        }
        outFile.close();
        out.close();
    }

}