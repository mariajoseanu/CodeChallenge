/**
 * 
 */
package com.ctscodechallenge.coding.withdraw;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ctscodechallenge.coding.exception.ArgumentException;

/**
 * Test class to test the CalculateWithdraw()
 * 
 * @author anumj
 *
 */
public class CalculateWithdrawTest {

	CalculateWithdraw calculate;

	@Before
	public void setUp() {
		calculate = new CalculateWithdraw();
	}

	/**
	 * Test method to check when the balance > withdraw amount
	 * @throws Exception
	 */
	@Test
	public void test_positivebalance() throws Exception {
		assertEquals(0.0, calculate.getBalance(), 0);
		calculate.addBalance(1000.0);
		assertEquals(1000.00, calculate.getBalance(), 0);
		calculate.withdraw(500);
		assertEquals(500.0, calculate.getBalance(), 0);
	}

	/**
	 * Test method to check when the balance = withdraw amount
	 * @throws Exception
	 */
	@Test
	public void test_zerobalance() throws Exception {
		assertEquals(0.0, calculate.getBalance(), 0);
		calculate.addBalance(500.0);
		calculate.withdraw(500.0);
		assertEquals(0.0, calculate.getBalance(), 0);
	}
	
	/**
	 * Test method to check when the balance < withdraw amount
	 * this will throw argumentException
	 * 
	 * 
	 * @throws Exception
	 */

	@Test(expected = ArgumentException.class)
	public void test_argumentException() throws Exception {
		assertEquals(0.0, calculate.getBalance(), 0);
		calculate.addBalance(500.0);
		calculate.withdraw(1500.0);
	}

}
