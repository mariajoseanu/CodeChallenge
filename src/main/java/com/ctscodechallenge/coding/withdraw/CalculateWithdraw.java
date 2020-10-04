package com.ctscodechallenge.coding.withdraw;

import com.ctscodechallenge.coding.exception.ArgumentException;

public class CalculateWithdraw {

	private double m_balance = 0.0;

	/**
	 * Added an additional method for retrieving the balance
	 * @return
	 */
	public double getBalance() {
		return m_balance;
	}

	/**
	 * Added an additional method for increasing the balance amount with the newAmount
	 * 
	 * @param newAmount
	 */
	public void addBalance(double newAmount) {
		m_balance += newAmount;
	}

	/**
	 * Created a custom exception ArgumentException
	 * @param amount
	 * @throws ArgumentException
	 */
	public void withdraw(double amount) throws ArgumentException {
		if (m_balance >= amount) {
			m_balance -= amount;
		} else {
			throw new ArgumentException(amount, "Withdrawal exceeds balance!");
		}
	}
}
