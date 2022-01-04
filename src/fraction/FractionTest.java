// homar03@student.bbk.ac.uk
// 13030243


package fraction;
import org.junit.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


/*
This tests if a number format exception is thrown is the constructor Fractionimpl(String wholenumber) receives a string with incorrect formatting.
 */
public class FractionTest {

    @Test(expected = NumberFormatException.class)
    public void spacestringformatadd() {
        FractionImpl testadd1 = new FractionImpl("-3 / 2");
        FractionImpl testadd2 = new FractionImpl(3, 5);
        String expected = testadd1.add(testadd2).toString();
        String actual = "-9/10";
        assertEquals(expected, actual);

    }

    /*
    This tests if a number format exception is thrown is the constructor Fractionimpl(String wholenumber) receives a string with the correct formatting.
    */
    @Test
    public void CorrectStringFormatTest() {
        FractionImpl testadd1 = new FractionImpl("   -3/2");
        FractionImpl testadd2 = new FractionImpl(3, 5);
        String expected = testadd1.add(testadd2).toString();
        String actual = "-9/10";
        assertEquals(expected, actual);
    }

    /*
    This tests if an illegal argument exception is thrown if the denominator is 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void zeroexceptiontest() {
        FractionImpl testadd1 = new FractionImpl(1, 0);
        FractionImpl testadd2 = new FractionImpl(3, 5);
        String expected = testadd1.add(testadd2).toString();
        String actual = "-9/10";
        assertEquals(expected, actual);

    }

    /*
    This method tests if the add method returns a correct sum
    */
    @Test
    public void testadd() {
        FractionImpl testadd1 = new FractionImpl(-3);
        FractionImpl testadd2 = new FractionImpl(3, 5);
        String expected = testadd1.add(testadd2).toString();
        String actual = "-9/10";
        assertEquals(expected, actual);

    }

    /*
     This method tests if the subtract method returns a correct sum
     */
    @Test
    public void testsubtract() {
        FractionImpl testsub1 = new FractionImpl(2, 9);
        FractionImpl testsub2 = new FractionImpl("-8/10");
        String expected = testsub1.subtract(testsub2).toString();
        String actual = "-26/45";
        assertEquals(expected, actual);

    }

    /*
     This method tests if the multiple method returns a correct product
     */
    @Test
    public void testmultiply() {
        FractionImpl testmult1 = new FractionImpl("1/9");
        FractionImpl testmult2 = new FractionImpl(-1, 2);
        String expected = testmult1.multiply(testmult2).toString();
        String actual = "-1/18";
        assertEquals(expected, actual);
    }

    /*
     This method tests if the divide method returns a correct product
     */
    @Test
    public void testdivide() {
        FractionImpl testdiv1 = new FractionImpl(-2, 9);
        FractionImpl testdiv2 = new FractionImpl("2/5");
        String expected = testdiv1.divide(testdiv2).toString();
        String actual = "-10/18";
        assertEquals(expected, actual);
    }

    /*
     This method tests if negative method switches the sign of the fraction
     */
    @Test
    public void testnegate() {
        FractionImpl negate1 = new FractionImpl(10, 5);
        Fraction expected = negate1.negate();
        Fraction actual = new FractionImpl(-10, 5);
        assertEquals(actual, expected);
    }

    /*
     This method tests if the compareTo method returns the correct integer depending on its conditions.
     */
    @Test
    public void testCompareto() {
        FractionImpl fraction1 = new FractionImpl(1, 5);
        FractionImpl fraction2 = new FractionImpl(1, 6);
        int actual = fraction1.compareTo(fraction2);
        int expected = 1;
        assertEquals(actual, expected);
    }

    /*
     This method tests if the inverse method switches the numerator with the denominator
     */
    @Test
    public void testInverse() {
        FractionImpl fraction = new FractionImpl(53, 3);
        FractionImpl actual = new FractionImpl(3, 53);
        FractionImpl expected = (FractionImpl) fraction.inverse();
        assertEquals(expected, actual);
    }

    /*
    This method tests if the equals method returns true if two fractions are equal
    */
    @Test
    public void testEquals() {
        FractionImpl fraction = new FractionImpl(5, 3);
        FractionImpl fraction1 = new FractionImpl(5, 3);
        boolean actual = fraction.equals(fraction1);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    /*
     This method tests if the equal method returns false if a string is passed in as the object.
     */
    @Test
    public void testEqualsnonfraction() {
        String Testing = "Hello there =D";
        FractionImpl fraction1 = new FractionImpl(3, 53);
        boolean actual = Testing.equals(fraction1);
        boolean expected = false;
        assertEquals(actual, expected);
    }
    /*
    This method tests if the equal method returns false if a list is passed in as the object.
     */
    @Test
    public void testEqualsnonfractionlist() {
        List<String> Testing = Arrays.asList("Hello", "World!", "How", "Are", "You");
        FractionImpl fraction1 = new FractionImpl(3, 53);
        boolean actual = Testing.equals(fraction1);
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
