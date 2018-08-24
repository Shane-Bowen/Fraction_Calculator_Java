public class Fraction {

	private int num;
	private int den;

	public Fraction(int num, int den)
	{
		if(den == 0)
		{
			throw new IllegalArgumentException("Denominator can't be zero");
		}
		
		else if(den < 0 && num == 0)
		{
			this.num = num;
			this.den = -den;
		}
		
		else if(den < 0)
		{
			this.num = -num;
			this.den = -den;
		}
		
		else{
			this.num = num;
			this.den = den;
		}
	
	}
	
	public Fraction(int num)
	{
		this(num, 1);
	}
	
	public Fraction(){
		this(0,1);
	}
	
	public int getNumerator(){
		return num;
	}
	
	public int getDenominator(){
		return den;
	}
	
	public String toString(){
		if(den==1)
		{
			return Integer.toString(num);
		}
		
		else{
			return num + "/" + den;
		}
	}
	
	public double toDouble(){
		return (double) num/ (double) den;
	}
	
	public Fraction add(Fraction other){
		return new Fraction (((num * other.den) + (other.num * den)), (den * other.den));
	}
	
	public Fraction subtract(Fraction other){
		return new Fraction (((num * other.den) - (other.num * den)), (den * other.den));
	}
	
	public Fraction multiply(Fraction other){
		return new Fraction ((num * other.num), (den * other.den));
	}
	
	public Fraction Divide(Fraction other){
		if(other.num == 0)
		{
			throw new IllegalArgumentException("Can't divide by a 0");
		}
		
		else{
			return new Fraction ((num * other.den), (den * other.num));
		}
	}
	
	public boolean equals(Object other){
		if(other instanceof Fraction){
			Fraction compare = (Fraction) other;
			this.toLowestTerms();
			compare.toLowestTerms();
			return this.num == compare.num && this.den == compare.den;
		}
		
		return false;
	}
	
	public void toLowestTerms(){
		int GCD = GCD(num, den);
		num = num/GCD;
		den = den/GCD;
	}
	
	public static int GCD(int num, int den){
		return num % den == 0 ? den : GCD(den, num % den);
	}

}