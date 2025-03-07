package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary {
	private String number = "0";  // String containing the binary value '0' or '1'

	/**
	 * Constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or ones with any length and order;
	 *               otherwise, the value of "0" will be stored. Leading zeros will be excluded, and an empty string
	 *               will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty() || !number.matches("[01]+")) {
			this.number = "0";
		} else {
			this.number = number.replaceFirst("^0+(?!$)", "");
		}
	}

	/**
	 * Returns the binary value of the variable.
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adds two binary variables.
	 */
	public static Binary add(Binary num1, Binary num2) {
		int sum = Integer.parseInt(num1.getValue(), 2) + Integer.parseInt(num2.getValue(), 2);
		return new Binary(Integer.toBinaryString(sum));
	}

	/**
	 * Performs a bitwise OR operation.
	 */
	public static Binary or(Binary num1, Binary num2) {
		int orResult = Integer.parseInt(num1.getValue(), 2) | Integer.parseInt(num2.getValue(), 2);
		return new Binary(Integer.toBinaryString(orResult));
	}

	/**
	 * Performs a bitwise AND operation.
	 */
	public static Binary and(Binary num1, Binary num2) {
		int andResult = Integer.parseInt(num1.getValue(), 2) & Integer.parseInt(num2.getValue(), 2);
		return new Binary(Integer.toBinaryString(andResult));
	}

	/**
	 * Multiplies two binary variables.
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		int product = Integer.parseInt(num1.getValue(), 2) * Integer.parseInt(num2.getValue(), 2);
		return new Binary(Integer.toBinaryString(product));
	}
}
