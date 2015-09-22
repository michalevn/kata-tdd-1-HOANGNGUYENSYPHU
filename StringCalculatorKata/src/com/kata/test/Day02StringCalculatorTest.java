package com.kata.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.kata.service.CalculatorService;
import com.kata.service.Day02StringCalculatorServiceImpl;

public class Day02StringCalculatorTest {

	CalculatorService calculatorService;

	@Before
	public void setUp() throws Exception {
		calculatorService = new Day02StringCalculatorServiceImpl();
	}

	@Test
	public void shouldRecieveOneNumber() {
		assertEquals(2, calculatorService.Add("2"));
	}

	@Test
	public void shouldReceiveZeroNumber() {
		assertEquals(0, calculatorService.Add(""));
	}

	@Test
	public void shouldReceiveNullNumber() {
		assertEquals(0, calculatorService.Add(null));
	}

	@Test
	public void shouldRecevieTwoNumber() {
		assertEquals(5, calculatorService.Add("1,4"));
	}

	@Test
	public void shouldAcceptManyNumbers() {
		assertEquals(10, calculatorService.Add("2,3,5"));
	}

	@Test
	public void shouldErrorWhenSumNotEqual() {
		assertNotEquals(10, calculatorService.Add("2,3,6"));
	}

	@Test
	public void shouldAcceptNewLine() {
		assertEquals(5, calculatorService.Add("1\n1,3"));
	}

	@Test
	public void shouldSupprtCustomeDelimiter() {
		assertEquals(3, calculatorService.Add("//[x]\n1x2"));
	}

	@Test
	public void shouldThrowExceptionWithNegative() {
		try {
			assertEquals(-2, calculatorService.Add("-2"));
			fail();
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("negatives not allowed:-2", e.getMessage());
		}

	}

	@Test
	public void shouldThrowExceptionWithManyNegative() {
		try {
			assertEquals(-8, calculatorService.Add("2,-3,-5"));
			fail();
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("negatives not allowed:-3,-5", e.getMessage());
		}
	}

	@Test
	public void shouldIgnoreNumberThan1000() {
		assertEquals(7, calculatorService.Add("2,10002,2003,5"));
	}
	@Test
	public void shouldAllowDelimiterAnyLenght(){
		assertEquals(6, calculatorService.Add("//[xxx]\n1xxx2xxx3"));
	}
	@Test
	public void shouldAllowManyDelimiter(){
		assertEquals(6, calculatorService.Add("//[*][%]\n1*2%3"));
	}

}
