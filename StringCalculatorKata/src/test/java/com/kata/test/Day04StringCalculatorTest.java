package com.kata.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import com.kata.service.CalculatorService;
import com.kata.service.Day04CalculatorServiceImpl;

public class Day04StringCalculatorTest {
	CalculatorService calculatorService;

	private void checkResult(Object expected, Object actual) {
		assertEquals(expected, actual);
	}

	@Before
	public void setUp() throws Exception {
		calculatorService = Day04CalculatorServiceImpl.getInstance();
	}

	@Test
	public void shouldAcceptNullString() {
		checkResult(0, calculatorService.Add(null));
	}

	@Test
	public void shouldAcceptEmptyString() {
		checkResult(0, calculatorService.Add(""));
	}

	@Test
	public void shouldAcceptOneNumber() {
		checkResult(1, calculatorService.Add("1"));
	}

	@Test
	public void shouldAcceptTwoNumber() {
		checkResult(3, calculatorService.Add("1,2"));
	}

	@Test
	public void shouldAcceptManyNumbers() {
		checkResult(7, calculatorService.Add("1,2,3,1"));
	}

	@Test
	public void shouldAcceptNewLineDelimiter() {
		checkResult(4, calculatorService.Add("1\n3"));
	}

	@Test
	public void shouldAcceptCustomDelimiter() {
		checkResult(4, calculatorService.Add("//x\n1x3"));
	}

	@Test
	public void shouldAcceptStartCustomDelimiter() {
		checkResult(4, calculatorService.Add("//*\n1*3"));
	}

	@Test
	public void shouldAcceptQuestionCustomDelimiter() {
		checkResult(4, calculatorService.Add("//?\n1?3"));
	}

	@Test
	public void shouldAcceptMultilDelimiter() {
		checkResult(4, calculatorService.Add("//???\n1???3"));
	}

	@Test
	public void shouldThrowExceptionWhenPassNegativeNumber() {
		try {
			checkResult(-1, calculatorService.Add("2 ,-1,3,-55"));
			fail("Should throw exception but it's not");
		} catch (Exception e) {
			// TODO: handle exception
			checkResult("negative number is not allowed:-1,-55", e.getMessage());

		}
	}

	@Test
	public void shouldIgnoreNumberMorethanOnethousand() {
		checkResult(4, calculatorService.Add("4,2000"));
	}

}
