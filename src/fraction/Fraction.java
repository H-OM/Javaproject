package fraction;

interface Fraction extends Comparable<Fraction> {



    public Fraction add(Fraction f);

    public Fraction subtract(Fraction f);

    public Fraction multiply(Fraction f);

    public Fraction divide(Fraction f);

    public Fraction abs();

    public Fraction negate();

    public Fraction inverse();

    public boolean equals(Object o);

    public int compareTo(Fraction o);

    public String toString();







}
