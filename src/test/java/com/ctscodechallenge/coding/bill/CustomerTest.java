package com.ctscodechallenge.coding.bill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author anumj Test class to test the calculate method of Customer class
 *
 */
public class CustomerTest {
	/* Injecting Mock to Customer */

	@InjectMocks
	private Customer customer;

	/* Mocked Item for the item candy */
	@Mock
	Item itemCandy;

	/* Mocked Item for the item cake */
	@Mock
	Item itemCake;

	/**
	 * mock the values for 2 items, candy and cake mock the price for cake as 20 and
	 * candy as 10
	 */
	@Before
	public void setUp() {
		initMocks(this);
		doReturn("cake").when(itemCake).getName();
		doReturn(20).when(itemCake).getPrice("cake");

		doReturn("candy").when(itemCandy).getName();
		doReturn(10).when(itemCandy).getPrice("candy");
	}

	/**
	 * Test method for multiple items in list for calculateBill()
	 * ReflectionTestUtils is used to set the listOfItems of customer
	 */
	@Test
	public void test_calculateBill_multipleItems() {
		List<Item> items = Arrays.asList(itemCandy, itemCake);

		ReflectionTestUtils.setField(customer, "listOfItems", items);

		int total = customer.calculateBill();
		assertEquals(30, total);
	}

	/**
	 * Test method for one item in list for calculateBill() ReflectionTestUtils is
	 * used to set the listOfItems of customer
	 */
	@Test
	public void test_calculateBill_oneItem() {
		List<Item> items = Arrays.asList(itemCandy);

		ReflectionTestUtils.setField(customer, "listOfItems", items);

		int total = customer.calculateBill();
		assertEquals(10, total);
	}

	/**
	 * Test method for zero items in list for calculateBill() ReflectionTestUtils is
	 * used to set the listOfItems of customer
	 */

	@Test
	public void test_calculateBill_noItemList() {
		List<Item> items = Arrays.asList();

		ReflectionTestUtils.setField(customer, "listOfItems", items);

		int total = customer.calculateBill();
		assertEquals(0, total);
	}

	/**
	 * Test method for null list iteration in calculateBill() ReflectionTestUtils is
	 * used to set the listOfItems of customer.
	 * 
	 * Received NullPointerException * In the calculateBill() , null scenario is not
	 * handled . This test can be updated once null is handled in method
	 */

	@Test(expected = NullPointerException.class)
	public void test_calculateBill_nullList() {
		List<Item> items = null;

		ReflectionTestUtils.setField(customer, "listOfItems", items);

		int total = customer.calculateBill();
		assertEquals(0, total);
	}
}
