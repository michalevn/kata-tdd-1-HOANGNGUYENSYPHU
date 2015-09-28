package com.kata.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day06DStringCalculatorServiceImpl implements CalculatorService {

	public final char[] SPECIAL_CHARACTES = { '*', '.' };

	public int Add(String numbers) {
		// TODO Auto-generated method stub
		if (numbers == null || numbers.trim().isEmpty()) {
			return 0;
		}
		String[] array = tokenizer(numbers);
		int sum = sum(array);
		return sum;
	}

	private boolean isSpecialCharactor(char c) {
		for (int i = 0; i < SPECIAL_CHARACTES.length; i++) {
			if (SPECIAL_CHARACTES[i] == c) {
				return true;
			}
		}
		return false;
	}

	private String[] filterNegative(String numbers){
		String regex ="";
		return null;
	}
	private String[] tokenizer(String numbers) {
		String regex = ",|\n";
		String customRegex = "//(.+)\\n(.+)";
		Pattern pattern = Pattern.compile(customRegex);
		Matcher matcher = pattern.matcher(numbers);
		if (matcher.find()) {
			String newRegex = matcher.group(1);
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < newRegex.length(); i++) {
				char c = newRegex.charAt(i);
				if (isSpecialCharactor(c)) {
					temp.append("\\").append(c);

				} else {
					temp.append(c);
				}
			}
			String newInput = matcher.group(2);
			return newInput.split(temp.toString());

		}
		return numbers.split(regex);
	}

	private int sum(String[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += toInt(array[i]);
		}
		return sum;
	}

	private int toInt(String nb) {
		return Integer.parseInt(nb);
	}

}
