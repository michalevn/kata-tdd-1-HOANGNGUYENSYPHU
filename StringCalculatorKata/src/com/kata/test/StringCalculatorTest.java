package com.kata.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kata.service.CalculatorService;
import com.kata.service.StringCalculatorServiceImpl;

public class StringCalculatorTest {

	CalculatorService calculatorService;

	@Before
	public void setUp() throws Exception {
		calculatorService = new StringCalculatorServiceImpl();
	}

	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, calculatorService.Add(""));
	}

	@Test
	public void shouldReturnSumWhenAddOneNumber() {
		assertEquals(2, calculatorService.Add("2"));
	}

	@Test
	public void shouldReturnZeroOnNull() {
		assertEquals(0, calculatorService.Add(null));
	}

	@Test
	public void shouldReturnSumWithTwoNumber() {
		assertEquals(5, calculatorService.Add("2,3"));
	}

	@Test
	public void shouldAllowUnknownAmountNumbers() {
		assertEquals(14, calculatorService.Add("2,3,4,5"));
	}

	@Test
	public void shouldAllowNewLinesBetweenNumber() {
		assertEquals(6, calculatorService.Add("1\n2,3"));
	}

	@Test
	public void shouldAllowSpaceBetweenNumbers() {
		assertEquals(7, calculatorService.Add("1, 2,3, 1 "));
	}

	@Test
	public void shouldAllowManyNewLinesBetweenNumber() {
		assertEquals(1, calculatorService.Add("1\n\n\n"));
	}

	@Test
	public void shouldSupportCustomeDelimiters() {

	//	assertEquals(3, calculatorService.Add("//;\n1;2"));

	}
}
