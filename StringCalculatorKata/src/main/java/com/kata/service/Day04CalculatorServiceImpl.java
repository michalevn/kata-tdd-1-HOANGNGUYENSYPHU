package com.kata.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04CalculatorServiceImpl implements CalculatorService {
	private static final char[] SPECIAL_CHARACTERS = { '*', '.', '?' };

	private Day04CalculatorServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	private static Day04CalculatorServiceImpl instance = new Day04CalculatorServiceImpl();

	public static CalculatorService getInstance() {
		return instance;
	}

	public int Add(String numbers) {
		// TODO Auto-generated method stub
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		// throw exception if nagative number is passed
		filterNegativeNumbers(numbers);
		String[] array = tokenizer(numbers);
		int sum = sum(array);
		return sum;
	}

	/**
	 * throw exception if nagative number is passed
	 * 
	 * @param input
	 *            : input to check
	 */
	private void filterNegativeNumbers(String input) {
		String regex = "(-\\d+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(input);
		StringBuilder output = new StringBuilder();
		while (match.find()) {
			String group = match.group();
			output.append(group).append(",");

		}
		if (output.toString().isEmpty() == false) {
			String rs = output.subSequence(0, output.length() - 1).toString();
			throw new IllegalArgumentException(
					"negative number is not allowed:" + rs);
		}

	}

	private int sum(String[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			int nb = toInt(array[i]);
			if (nb > 1000) {
				continue;
			}
			sum += nb;
		}
		return sum;
	}

	/**
	 * check if a character is a regex special character or not
	 * 
	 * @param input
	 * @return
	 */
	private boolean isSpecialCharacter(char input) {
		for (int i = 0; i < SPECIAL_CHARACTERS.length; i++) {
			if (input == SPECIAL_CHARACTERS[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * build internal regex for custom delimiter
	 * 
	 * @param input
	 * @return
	 */
	private String buildInternalRegex(String input) {

		StringBuilder newRegex = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (isSpecialCharacter(c)) {
				newRegex.append("\\").append(c);
			} else {
				newRegex.append(c);
			}

		}
		return newRegex.toString();

	}

	/**
	 * tokenize input string to array
	 * 
	 * @param numbers
	 * @return
	 */
	private String[] tokenizer(String numbers) {
		String regex = "\n|,";
		String newRegex = "//(.+)\\n(.+)";
		Pattern patter = Pattern.compile(newRegex);
		Matcher match = patter.matcher(numbers);
		if (match.matches()) {
			String customRegex = match.group(1);
			String inputNumber = match.group(2);
			customRegex = buildInternalRegex(customRegex);
			String[] result = inputNumber.split(customRegex);
			return result;
		}
		String[] array = numbers.split(regex);
		return array;
	}

	private Integer toInt(String number) {
		return Integer.parseInt(number);
	}

}
