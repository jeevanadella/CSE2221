import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Jeevan Nadella
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_5_5() {
        NaturalNumber n = new NaturalNumber2(5);
        NaturalNumber nExpected = new NaturalNumber2(5);
        NaturalNumber m = new NaturalNumber2(5);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_8_0() {
        NaturalNumber n = new NaturalNumber2(8);
        NaturalNumber nExpected = new NaturalNumber2(8);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_23() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(23);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_1000872347() {
        NaturalNumber n = new NaturalNumber2(1000872347);
        NaturalNumber nExpected = new NaturalNumber2(1000872347);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_1000872348() {
        NaturalNumber n = new NaturalNumber2(1000872348);
        NaturalNumber nExpected = new NaturalNumber2(1000872348);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_1_1_2() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(1);
        NaturalNumber pExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_10_2_3() {
        NaturalNumber n = new NaturalNumber2(10);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber pExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(3);
        NaturalNumber mExpected = new NaturalNumber2(3);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    @Test
    public void testIsWitnessToCompositeness_4_2() {
        NaturalNumber n = new NaturalNumber2(4);
        NaturalNumber w = new NaturalNumber2(2);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void testIsWitnessToCompositeness_7_2() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber w = new NaturalNumber2(2);
        assertTrue(!CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void testIsWitnessToCompositeness_243_31() {
        NaturalNumber n = new NaturalNumber2(243);
        NaturalNumber w = new NaturalNumber2(31);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    /*
     * Tests of isPrime2
     */

    @Test
    public void testIsPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

    @Test
    public void testIsPrime2_4() {
        NaturalNumber n = new NaturalNumber2(4);
        assertTrue(!CryptoUtilities.isPrime2(n));
    }

    @Test
    public void testIsPrime2_11() {
        NaturalNumber n = new NaturalNumber2(11);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

    /*
     * Tests of generateNextLikelyToPrime
     */

    @Test
    public void testGenerateNextLikelyToPrime_2() {
        NaturalNumber n = new NaturalNumber2(2);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("3", n.toString());
    }

    @Test
    public void testGenerateNextLikelyToPrime_4() {
        NaturalNumber n = new NaturalNumber2(4);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("5", n.toString());
    }

    @Test
    public void testGenerateNextLikelyToPrime_6() {
        NaturalNumber n = new NaturalNumber2(6);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("7", n.toString());
    }

    @Test
    public void testGenerateNextLikelyToPrime_98() {
        NaturalNumber n = new NaturalNumber2(98);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("101", n.toString());
    }

}
