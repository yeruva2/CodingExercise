package com.exercise.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	/**
	 * It calculates the sum of number from string input
	 * 
	 * @param inData
	 * @return
	 */
	public Integer calculator(final String inData) {// , final String delimiter)
													// {

		Integer sum = Integer.valueOf(0);

		if (inData != null) {

			if (inData.isEmpty()) {

				return 0;

			} else {

				String p3 = "-?\\d+";

				Pattern p = Pattern.compile(p3);
				Matcher m = p.matcher(inData);

				while (m.find()) {
					System.out.println(m.group());
					sum = sum + convertStrToInt(m.group());
					// sBuffer.append(m.group());
				}

				// String inArr[] = inData.split(delimiter);

				// String inArr[] = inData.split(",|n");

				// if(inArr.length > 2) {
				//
				// throw new
				// RuntimeException("It allows maximum 3 numbers like 0,1,2");
				//
				// }

				// for (int i = 0; i < inArr.length; i++) {
				//
				// sum = sum + convertStrToInt(inArr[i]);
				//
				// }
			}

		}

		return sum;
	}

	// /**
	// * Main Calculator
	// * @param numbers
	// * @return
	// */
	// public Integer calculator(final String numbers) {
	//
	// String delimiter = ",|\n|n";
	//
	// String numbersWithoutDelimiter = numbers;
	//
	// if (numbers.startsWith("//")) {
	//
	// int delimiterIndex = numbers.indexOf("//") + 2;
	//
	// delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
	//
	// numbersWithoutDelimiter = numbers
	// .substring(numbers.indexOf("n") + 1);
	//
	// }
	//
	// return calculator(numbersWithoutDelimiter, delimiter);
	//
	// }

	public Integer convertStrToInt(String input) {
		Integer result = null;

		if (input == null || input.length() == 0) {

			return null;

		}

		try {

			result = Integer.parseInt(input);

			if (result < 0) {

				throw new RuntimeException("Negatives not allowed: " + result);

			} else {

				if (result > 1000) {

					result = Integer.valueOf(0);

				}

			}

		} catch (NumberFormatException e) {

			String neg = "";

			if (input.indexOf('-') != -1) {

				neg = "-";

				System.out.println("I am in negative");

				input = input.replaceAll(neg, "");

			}

			if (input.indexOf('.') != -1) {

				input = input.substring(0, input.indexOf('.'));

				if (input.length() == 0) {
					return (Integer) 0;
				}

			}

			String strNum = input.replaceAll("[^\\d]", "");

			if (0 == strNum.length()) {
				return null;
			}

			result = Integer.parseInt(neg + strNum);
		}

		return result;
	}

	private boolean isEmpty(String inData) {

		boolean isEmpty = false;

		if (inData.isEmpty()) {
			isEmpty = true;
		}

		return isEmpty;
	}

	public static void main(String args[]) {

		String str = "//[-][%]\n1-2%3"; // “//[-][%]\n1-2%3″;
		String str1 = "//;n3;6;15";
		String str2 = "1\n2,3";

		String p1 = "[^-?0-9]+n";
		String p2 = "[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+";
		String p3 = "-?\\d+";

		StringBuffer sBuffer = new StringBuffer();
		Pattern p = Pattern.compile(p3);
		Matcher m = p.matcher(str2);

		while (m.find()) {
			System.out.println(m.group());
			// sBuffer.append(m.group());
		}

		System.out.println(sBuffer.toString());

	}

}
