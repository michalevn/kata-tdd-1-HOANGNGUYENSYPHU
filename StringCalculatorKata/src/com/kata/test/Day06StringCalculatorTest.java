package com.kata.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kata.service.CalculatorService;
import com.kata.service.Day06DStringCalculatorServiceImpl;

public class Day06StringCalculatorTest {

	CalculatorService calculatorService;

	@Before
	public void setUp() throws Exception {
		calculatorService = new Day06DStringCalculatorServiceImpl();
	}

	private void checkEqual(Object expect, Object result) {
		assertEquals(expect, result);
	}

	@Test
	public void shouldReturnZeroWhenPasssEmptyString() {
		checkEqual(0, calculatorService.Add(""));
	}

	@Test
	public void shouldReturnZeroWhenPassNullParam() {
		checkEqual(0, calculatorService.Add(null));
	}

	@Test
	public void shouldAllowWhenPassOneParam() {
		checkEqual(1, calculatorService.Add("1"));
	}

	@Test
	public void shouldReturnZeroWhenPassBlankCharacter() {
		checkEqual(0, calculatorService.Add(" "));
	}

	@Test
	public void shouldAllowTwoNumers() {
		checkEqual(3, calculatorService.Add("1,2"));
	}

	@Test
	public void shouldAllowNewLineDelimitor() {
		checkEqual(3, calculatorService.Add("1\n2"));
	}

	@Test
	public void shouldAllowCustomDelimitor() {
		checkEqual(3, calculatorService.Add("//x\n1x2"));
	}

	@Test
	public void shoudlAllowCustomDelimitorWithManyCharacter() {
		checkEqual(3, calculatorService.Add("//xxx\n1xxx2"));
	}

	@Test
	public void shouldAllowSpecialCharacterAsDelimitor() {
		checkEqual(3, calculatorService.Add("//*\n1*2"));
	}

	@Test
	public void shouldThrowExceptionWhenPassNegative() {
		try {
			checkEqual(-1, calculatorService.Add("-1"));
			fail();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
