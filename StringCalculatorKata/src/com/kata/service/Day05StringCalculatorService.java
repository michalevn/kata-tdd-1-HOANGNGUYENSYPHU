package com.kata.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05StringCalculatorService implements CalculatorService {

	private Day05StringCalculatorService() {
		// TODO Auto-generated constructor stub
	}

	private static CalculatorService _instance;

	public static CalculatorService getInstance() {
		if (_instance == null) {
			_instance = new Day05StringCalculatorService();
		}
		return _instance;
	}

	public int Add(String numbers) {
		// TODO Auto-generated method stub
		if (numbers == null || numbers.trim().isEmpty()) {
			return 0;
		}
		String[] array = tokenizer(numbers);
		int sum = 0;
		for (String nb : array) {
			sum += toInt(nb);
		}
		return sum;
	}

	private String[] tokenizer(String numbers) {
		String regex = "\n|,";
		String customRegex = "//(.?)\\n(.*)";
		Pattern pattern = Pattern.compile(customRegex);
		Matcher match = pattern.matcher(numbers);
		if (match.find()) {
			String newRegex = match.group(1);
			if(newRegex.equals("*")){
				newRegex = "\\"+newRegex;
			}
			String newNumbers = match.group(2);
			return newNumbers.split(newRegex);

		}
		return numbers.split(regex);
	}

	private Integer toInt(String nb) {
		return Integer.parseInt(nb);
	}

}
