package com.kata.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kata.service.CalculatorService;
import com.kata.service.Day03StringCalculatorServiceImpl;

public class Day03StringCalculatorTest {

	CalculatorService calculatorService;

	@Before
	public void setUp() throws Exception {
		calculatorService = new Day03StringCalculatorServiceImpl();
	}

	@Test
	public void shouldAllowOneNumber() {
		assertEquals(4, calculatorService.Add("4"));

	}

	@Test
	public void shouldAllowEmptyNumber() {
		assertEquals(0, calculatorService.Add(""));
	}

	@Test
	public void shouldAllowNullParam() {
		assertEquals(0, calculatorService.Add(null));
	}

	@Test
	public void shouldAllowTwoNumbers() {
		assertEquals(3, calculatorService.Add("1,2"));
	}

	@Test
	public void shouldAllowManyNumbers() {
		assertEquals(6, calculatorService.Add("1,2,3"));
	}

	@Test
	public void shouldAllowDelimiterAsNewLine() {
		assertEquals(6, calculatorService.Add("1\n2\n3\n"));
	}

	@Test
	public void shoudldAllowCustomDelimitor() {
		assertEquals(5, calculatorService.Add("//x\n1x4"));
	}
	@Test
	public void shouldThrowExceptionWithNegativeNumber(){
		try {
			assertEquals(-1, calculatorService.Add("-1"));
			fail();
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("negatives not allowed:-1",e.getMessage());
		}
	}
	@Test
	public void shouldThrowExceptionWithNumberWhenPassNegativeNumbers(){
		try {
			assertEquals(-1, calculatorService.Add("-2,-3"));
			fail();
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("negatives not allowed:-2,-3",e.getMessage());
		}
	}
	@Test 
	public void shouldIgnorreNumberBiggerThanOneThousand(){
		assertEquals(3, calculatorService.Add("3,1001"));
	}
	@Test
	public void shouldAllowAnyLengOfDelimitor(){
		assertEquals(6, calculatorService.Add("//[***]\n1***2***3"));
	}

}
