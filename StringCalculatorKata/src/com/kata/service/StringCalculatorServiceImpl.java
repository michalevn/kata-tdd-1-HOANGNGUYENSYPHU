package com.kata.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.PartialResultException;

public class StringCalculatorServiceImpl implements CalculatorService {

	@Override
	public int Add(String numbers) {
		// TODO Auto-generated method stub
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		String[] numberArray = tokenizer(numbers);
		Integer sum = sumArray(numberArray);
		return sum;
	}

	private int sumArray(String[] array) {
		Integer sum = 0;
		for (String nb : array) {
			 
			sum += Integer.parseInt(nb.trim());
		}
		return sum;
	}

	private String[] tokenizer(String numbers) {
		String regex ="\n|,";
		Pattern pattern = Pattern.compile("//(\\w+)\n(\\w+)");
		Matcher match = pattern.matcher(numbers);
		
		if(match.matches()){
			regex = match.group(1);
			numbers = match.group(2);
		}
		
		String[] numberArray = numbers.split(regex);
		return numberArray;
	}

}
