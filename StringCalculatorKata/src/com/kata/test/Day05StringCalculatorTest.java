package com.kata.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kata.service.CalculatorService;
import com.kata.service.Day05StringCalculatorService;

public class Day05StringCalculatorTest {

	CalculatorService calCulatorService;

	@Before
	public void setUp() throws Exception {
		calCulatorService = Day05StringCalculatorService.getInstance();
	}

	private void checkEqual(Object expect, Object result) {
		assertEquals(expect, result);

	}

	@Test
	public void shouldAllowNullParametor (){
		checkEqual(0, calCulatorService.Add(null));
	}
	@Test
	public void shouldAllowEmptyNumber(){
		checkEqual(0, calCulatorService.Add(""));
	}
	@Test
	public void shouldAllowOneNumber(){
		checkEqual(1, calCulatorService.Add("1"));
	}
	@Test
	public void shouldAllowEmptyStringWithManyBlank(){
		checkEqual(0, calCulatorService.Add("    "));
	}
	@Test
	public void shouldAllowTwoNumbers(){
		checkEqual(3, calCulatorService.Add("1,2"));
	}
	@Test
	public void shouldAllowManyNumber(){
		checkEqual(4, calCulatorService.Add("1,2,1"));
	}
	@Test
	public void shouldAllowNewLineDelimitor(){
		checkEqual(3, calCulatorService.Add("1\n2"));
	}
	@Test
	public void shouldSuportCustomDelimitor(){
		checkEqual(3, calCulatorService.Add("//;\n1;2"));
	}
	@Test
	public void shoudlSupportSpecialCustomDelimitor(){
		checkEqual(3, calCulatorService.Add("//*\\n1*2"));
	}

}
