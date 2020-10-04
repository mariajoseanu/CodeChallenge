package com.ctscodechallenge.coding.exception;

/**
 * Custom exception to throw from CalculateWithdraw class
 *
 * @author anumj
 *
 */
public class ArgumentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ArgumentException(double amount, String message) {
		// Assuming the amount needs to be sent in the exception message
		super("$" + amount + "/- " + message);
	}
}
