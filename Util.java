

import java.util.Scanner;
import java.util.Random;

public class Util {
	public static String inputLine(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.println(prompt);
		return input.nextLine();
	}
	
	public static boolean isInteger(String inputtedString) {
		try {
			Integer.parseInt(inputtedString);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static int inputInteger(String prompt) {
		String result="";
		Scanner input= new Scanner(System.in);
		
		while (true) {
			System.out.println(prompt);
			result=input.nextLine();
			
			if (isInteger(result))
				break;
			else
				System.out.println("Not an integer. Try again.");	
		}
		
		return Integer.parseInt(result);
	}
	
	public static int inputIntegerBetween(String prompt, int lowBound, int highBound) {
		int result = 0;
		
		while (true) {
			result=inputInteger(prompt);
			
			if (result<lowBound)
				System.out.println("please enter an int greater than or equal to "+lowBound);
			else if (result>highBound)
				System.out.println("please enter an int less than or equal to "+highBound);
			else
				break;
		}
		
		return result;
	}
	
	public static int inputIntegerLow(String prompt, int lowBound) {
		int result=0;
		
		while(true) {
			result=inputInteger(prompt);
			
			if (result<lowBound)
				System.out.println("please enter an integer greater than "+lowBound);
			else
				break;
		}
		
		return result;
			
		
	}
	
	public static int inputIntegerHigh(String prompt, int highBound) {
		int result=0;
		
		while(true) {
			result=inputInteger(prompt);
			
			if (result>highBound)
				System.out.println("please enter an integer less than "+highBound);
			else
				break;
		}
		
		return result;
		
	}
	
	public static boolean isDouble(String inputtedString) {
		try {
			Double.parseDouble(inputtedString);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static double inputDouble(String prompt) {
		String result="";
		Scanner input= new Scanner(System.in);
		
		while(true) {
			System.out.println(prompt);
			result=input.nextLine();
			
			if (isDouble(result)) {
				break;
			}
			else
				System.out.println("please enter a double.");
		}
		return Double.parseDouble(result);
	}
	
	public static double inputDoubleBetween(String prompt, double lowBound, double highBound) {
		double result=0;
		
		while(true) {
			result=inputDouble(prompt);
			
			if (result<lowBound)
				System.out.println("please enter an int greater than "+lowBound);
			else if (result>highBound)
				System.out.println("please enter an int less than "+highBound);
			else
				break;
		}
		
		return result;
	}
	
	public static double inputDoubleLow(String prompt, double lowBound) {
		double result=0;
		
		while(true) {
			result=inputDouble(prompt);
			
			if (result<lowBound)
				System.out.println("please enter a double greater than "+lowBound);
			else
				break;
		}
		
		return result;
	}
	
	public static double inputDoubleHigh(String prompt, double highBound) {
		double result=0;
		
		while(true) {
			result=inputDouble(prompt);
			
			if (result>highBound)
				System.out.println("please enter a double less than "+highBound);
			else
				break;
		}
		
		return result;
	}
	
	public static char obtainYesNo(String message) {
		Scanner userInput= new Scanner(System.in);
		String result = "";
		
		do {
			System.out.print(message);
			result=userInput.nextLine();
			result=result.toLowerCase();
			
			if(result.equals("y") || result.equals("n"))
				break;
			else
				System.out.println("please enter either (y/n)");
		}while (true);
		
		return result.charAt(0);
	}
	
	public static double roundOff(double value, int decimalPlaces) {
		double multiplier = Math.pow(10,decimalPlaces);
		double roundedValue = Math.round(value * multiplier);
		return roundedValue/multiplier;
	}
	
	public static int randomIntBetween(int lowBound, int highBound) {
		Random rand = new Random();
		return rand.nextInt(highBound-lowBound+1)+lowBound;
	}
	
	public static boolean isAlphabetic(String input) {
		boolean result=true;
		input=input.toLowerCase();
		for (int i=0;i<input.length();i++) {
			if (input.charAt(i)<'a' || input.charAt(i)>'z') {
				result=false;
				break;
			}
		}
		return result;
		
	}
	
	
}
