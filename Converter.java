package decToHex;

import java.util.Arrays;
import java.util.Collections;

/**
 * Convert Decimal number to Hex.
 * @author fitzgeraldsidumo
 *
 */

import java.util.HashMap;
import java.util.Scanner;

public class Converter {
	
	/**
	 * Map to hold the hex digits form 
	 * 10 - 15, i.e. A-F
	 */
	private static HashMap<Integer, String> hexMap;
	private static Scanner input;
	private static String [] hexNum;

	
	/**
	 * Static initialisation of the 
	 * HashMap, Hex Alpha
	 */
	static { 
		hexMap = new HashMap<>();
		hexMap.put(10, "A");
		hexMap.put(11, "B");
		hexMap.put(12, "C");
		hexMap.put(13, "D");
		hexMap.put(14, "E");
		hexMap.put(15, "F");
		
		input = new Scanner(System.in);
		hexNum = new String [16];
		for (int i = 0; i < hexNum.length; i ++) {
			hexNum[i] = Integer.toString(0);
		}
	}
	
	public static void main(String [] args) {
		String decimalInput = "";
		
		while (true) {
			try {
				System.out.println("Enter a decimal between 0 and 10_000 inclusive"+
						"\nor type exit to terminate"); 
				decimalInput = input.next();
				
				if(!Double.isNaN(Double.parseDouble(decimalInput))) {
					int decimal = Integer.parseInt(decimalInput);
					convert(decimal);
				}

			} catch (NumberFormatException e) {
				if (decimalInput.toLowerCase().equals("exit")) {
					return;
				}
				System.out.println("Try Again, or Exit");
			}
		
		}
		
	}
	
	private static void convert(int decimal) {
		if (decimal < 0 || decimal > 10_000) {
			return;
		}
		int divident = decimal;
		int alphaIndex = 15;

		System.out.println("converting the decimal");
			
		while(divident > 0) {
			
			int remainder = divident % 16;
			System.out.println("Remainder = " + remainder);
			if (remainder > 9 ) {	
			
				hexNum[alphaIndex] = hexMap.get(remainder);
				alphaIndex--;
			} else {
			
				hexNum[alphaIndex] = Integer.toString(remainder);
				alphaIndex--;

			}
			divident =  divident / 16;

		}
		String hexadecimal = "";
		for (String string : hexNum) {
			
			hexadecimal += string;
		}
		System.out.println(hexadecimal);
	}	

}
