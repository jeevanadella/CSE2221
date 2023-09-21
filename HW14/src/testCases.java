// test case for a single digit input
public void test1() {
    NaturalNumber n = new NaturalNumber2(1);
    NaturalNumber nExpected = new NaturalNumber2("1");

    assertEquals(nExpected, n);
}

// test case for a 3 digit input (max length without requiring any commas)
public void test123() {
    NaturalNumber n = new NaturalNumber2(123);
    NaturalNumber nExpected = new NaturalNumber2("123");

    assertEquals(nExpected, n);
}

//test case for a 4 digit input (smallest length requiring a single comma)
public void test1234() {
    NaturalNumber n = new NaturalNumber2(1234);
    NaturalNumber nExpected = new NaturalNumber2("1,234");

    assertEquals(nExpected, n);
}

// test case for a 7 digit input (smallest length requiring 2 commas)
public void test1234567() {
    NaturalNumber n = new NaturalNumber2(1234567);
    NaturalNumber nExpected = new NaturalNumber2("1,234,567");

    assertEquals(nExpected, n);
}

// test case for a 8 digit input (input requiring 2 commas but not 3)
public void test12345678() {
    NaturalNumber n = new NaturalNumber2(12345678);
    NaturalNumber nExpected = new NaturalNumber2("12,345,678");

    assertEquals(nExpected, n);
}

// test case for a 30 digit number (a very large number)
public void test123456789012345678901234567890() {
    NaturalNumber n = new NaturalNumber2(123456789012345678901234567890);
    NaturalNumber nExpected = new NaturalNumber2("123,456,789,012,345,678,901,234,567,890");

    assertEquals(nExpected, n);
}