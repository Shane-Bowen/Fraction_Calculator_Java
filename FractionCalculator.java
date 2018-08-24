import java.util.Scanner;

public class FractionCalculator {

	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args){
		intro();
		execution();
	}

	public static void intro(){
		System.out.println("This program is a fraction calculator.\n" +
				"It will perform operations until you type Q to quit.\n" +
				"Please enter your fraction in the form a/b, where a and b are integers.\n");
	}

	public static void execution(){
		
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
		String operation = getOperation(kb);

		if(!operation.equalsIgnoreCase("Q"))
		{
			System.out.print("Please enter a fraction (a/b) or integer (a): ");
			Fraction fractionOne = getFraction(kb);
			int numOne = fractionOne.getNumerator();
			int denOne = fractionOne.getDenominator();

			System.out.print("Please enter a fraction (a/b) or integer (a): ");
			Fraction fractionTwo = getFraction(kb);
			int numTwo = fractionTwo.getNumerator();
			int denTwo = fractionTwo.getDenominator();

			if(operation.equals("+"))
			{
				Fraction result = fractionOne.add(fractionTwo);
				result.toLowestTerms();
				System.out.println(numOne + "/" + denOne + " + " + numTwo + "/" + denTwo + " = " + result.toString());
				execution();
			}

			else if(operation.equals("-"))
			{
				Fraction result = fractionOne.subtract(fractionTwo);
				result.toLowestTerms();
				System.out.println(numOne + "/" + denOne + " - " + numTwo + "/" + denTwo + " = " + result.toString());
				execution();
			}

			else if(operation.equals("/"))
			{
				Fraction result = fractionOne.Divide(fractionTwo);
				result.toLowestTerms();
				System.out.println(numOne + "/" + denOne + " / " + numTwo + "/" + denTwo + " = " + result.toString());
				execution();
			}

			else if(operation.equals("*"))
			{
				Fraction result = fractionOne.multiply(fractionTwo);
				result.toLowestTerms();
				System.out.println(numOne + "/" + denOne + " * " + numTwo + "/" + denTwo + " = " + result.toString());
				execution();
			}

			else if(operation.equals("="))
			{
				boolean result = fractionOne.equals(fractionTwo);
				System.out.println(numOne + "/" + denOne + " = " + numTwo + "/" + denTwo + " is " + result);
				execution();
			}

		}

		else
		{
			System.out.println("Goodbye");
		}

	}
	
	public static String getOperation(Scanner kb){
		String operation = kb.next();
		
		while(!operation.matches("[+\\-,/*=qQ]")) {
	        System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
	        operation = kb.next();
		}
		
		return operation;
	}
	
	public static Fraction getFraction(Scanner kb){
		String fraction = kb.next();
		while(!fraction.matches("-?\\d+/*(\\+?[1-9]\\d*)*")) {
	        System.out.print("Invalid fraction. Please enter (a/b) or (a): ");
	        fraction = kb.next();
		}
		
		if(fraction.contains("/")) {
			String[] splitFraction = fraction.split("/");
			return new Fraction(Integer.parseInt(splitFraction[0]), Integer.parseInt(splitFraction[1]));
		}
		
		else{
			return new Fraction(Integer.parseInt(fraction));
		}

	}
}