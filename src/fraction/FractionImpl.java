// homar03@student.bbk.ac.uk
// 13030243




package fraction;

import java.io.IOError;
import java.io.IOException;
import java.util.Objects;

public class FractionImpl implements Fraction {

    // Private member variables that store numerator and denominator
    private int numerator;
    private int denominator;



    /*
    Method: Constructor
    Parameters: two integer parameters which are a numerator and denominator
    Notes: Creates a fraction in the form numerator/denominator.
    -if denominator is negative the fraction is automatically set to the form -numerator/denominator.
    -if the denominator is 0 then an illegal argument exception is thrown.
    */

    public FractionImpl(int numerator, int denominator) {

        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator is zero.");
        }
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        if (denominator < 0) {
            this.numerator = -1 * this.numerator;
            this.denominator = Math.abs(this.denominator);
        }
        if (this.denominator < 0) {
            this.numerator = -1 * this.numerator;
        }

    }

    /*
    Method: Constructor
    Parameters: an integer value
    Notes: Creates a fraction in the form numerator/denominator where the denominator is always set to 1.
    */

    public FractionImpl(int wholeNumber) {

        this.numerator = wholeNumber;
        this.denominator = 1;
        if (wholeNumber == 0) {
            this.numerator = 0;
        }


    }
    /*
    Method: Constructor
    Parameters: a string in the form of "numerator/denominator"
    Notes: Creates a fraction in the form numerator/denominator.
    -throws a number format exception if there are spaces between the numerator and '/' symbol or the denominator and '/' symbol
    -if the denominator is 0 then an illegal argument exception is thrown.
    - if the string is an integer a fraction is created in the form numerator/denominator where the denominator is always set to 1.
    */

    public FractionImpl(String fraction) throws NumberFormatException {
        // TODO
        fraction = fraction.trim();
        if (!fraction.matches("-{0,1}[0-9]+\\/[0-9]+") && !fraction.matches("-{0,1}[0-9]")){
            throw new NumberFormatException("Please check spaces");}


        if (fraction.matches("-{0,1}[0-9]+\\/[0-9]+")) {
            String[] numbers = fraction.split("/");
            this.numerator = Integer.parseInt(numbers[0]);
            this.denominator = Integer.parseInt(numbers[1]);
            }
            if (fraction.matches("-{0,1}[0-9]")) {
                this.numerator = Integer.valueOf(fraction);
                this.denominator = 1;

            }
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator is zero.");}



    }

    /*
    Method: toString
    Parameters: None
    Notes: converts a fraction instance into a string in the form of numerator/denominator or an integer if the denominator is 1.
    */

    public String toString() {
        if(denominator == 1)
            return "" + numerator;
        else return numerator + "/" + denominator;
    }

    /*
    Method: add
    Parameters: an instance of fraction
    Notes: adds two fractions a and f together and returns a new fraction that is the sum of both fractions.
    - a is "this" object and f is the input parameter.
    - f is cast to the type fraction to maintain privacy of the class. This is the case in all numerical operations therefore setters and getters will not be used..
    - The reduce() method simplifies the fraction to its simplest form.

     */

    @Override
    public Fraction add(Fraction f) {
        int addn = (this.numerator * ((FractionImpl) f).denominator) + (((FractionImpl) f).numerator * this.denominator);
        int addd = (this.denominator * ((FractionImpl) f).denominator);
        reduce();
        return new FractionImpl(addn, addd);
    }

    /*
    Method: subtract
    Parameters: an instance of fraction
    Notes: subtracts two fractions a and f together and returns a new fraction that is the sum of the operation.
    -a is "this" object and f is the input parameter.
    -f is cast to the type fraction to maintain privacy of the class. This is the case in all numerical operations therefore setters and getters will not be used..
    -The reduce() method simplifies the fraction to its simplest form.
     */

    @Override
    public Fraction subtract(Fraction f) {
        int subn = (this.numerator * ((FractionImpl) f).denominator) - (((FractionImpl) f).numerator * this.denominator);
        int subd = (this.denominator * ((FractionImpl) f).denominator);
        reduce();
        return new FractionImpl(subn, subd);
    }

    /*
    Method: multiply
    Parameters: an instance of fraction
    Notes: multiplies two fractions a and f together and returns a new fraction that is the product of the operation.
    -a is "this" object and f is the input parameter.
    -f is cast to the type fraction to maintain privacy of the class. This is the case in all numerical operations therefore setters and getters will not be used..
    -The reduce() method simplifies the fraction to its simplest form.
     */

    @Override
    public Fraction multiply(Fraction f) {
        int multn = this.numerator *  ((FractionImpl) f).numerator;
        int multd = this.denominator * ((FractionImpl) f).denominator;
        reduce();
        return  new FractionImpl(multn, multd);
    }

    /*
    Method: divide
    Parameters: an instance of fraction
    Notes: divides two fractions a and f together and returns a new fraction that is the product of the operation.
    -a is "this" object and f is the input parameter.
    -f is cast to the type fraction to maintain privacy of the class. This is the case in all numerical operations therefore setters and getters will not be used..
    -The reduce() method simplifies the fraction to its simplest form.
     */

    @Override
    public Fraction divide(Fraction f) {
        int divn = this.numerator * ((FractionImpl) f).denominator;
        int divd = this.denominator * ((FractionImpl) f).numerator;
        reduce();
        return new FractionImpl(divn, divd);
    }

    /*
    Method: abs
    Parameters: None
    Notes: takes "this" fraction and returns the fraction in its absolute form.
    */

    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(this.numerator), Math.abs((this.denominator)));
    }

    /*
Method: negate
Parameters: None
Notes: takes "this" fraction and negates its sign and returns a new fraciton.
 */
    @Override
    public Fraction negate() {

        int num = this.numerator * -1;

        return new FractionImpl(num, this.denominator);
    }
    /*
    Method: inverse
    Parameters: None
    Notes: Takes this fraction and returns a new fraction where the numerator and denominator have been swapped.
     */
    @Override
    public Fraction inverse() {
             return new FractionImpl(this.denominator, this.numerator);
    }

        /*
    Method: equals
    Parameters: an object o of any type
    Notes: Checks if o is an instance of fraction and returns true if "this" fraction and o are equal, otherwise returns false
     */

    @Override
    public boolean equals(Object o) {
        if (o instanceof FractionImpl){
            return ((FractionImpl)o).numerator == this.numerator && ((FractionImpl)o).denominator == this.denominator;
        } else {
            return false;
        }
    }
    /*
    Method: compareTo
    Parameters: an instance of fraction
    Notes: Compares "this" fraction to fraction o and returns a -1 if "this" fraction is less than o,
    1 if "this" is greater, or 0 of they are equal.
     */
    @Override
    public int compareTo(Fraction o) {

        if(((double) this.numerator / (double) this.denominator) < (((FractionImpl) o).numerator / ((FractionImpl) o).denominator)){
    return -1;}
        if(((double) this.numerator / (double) this.denominator) > (((FractionImpl) o).numerator / ((FractionImpl) o).denominator)){
            return 1;}
        else return 0;

    }
    /*
    Method: reduce
    Parameters: none
    Notes: converts "this" fraction into its lowest numerical form by implementing the GCD method.
     */
    void reduce() {
        int gcd = GCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

    }

    /*
    Method: GCD
    Parameters: integers of the numerator and denominators
    Notes: this method uses euclids algorithm to reduce two fractions by using their greatest common denominator
     and returns it as an integer
     */
    private int GCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;}
        return GCD(denominator, numerator % denominator);
    }

}




