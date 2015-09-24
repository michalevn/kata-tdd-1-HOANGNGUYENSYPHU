package com.kata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03StringCalculatorServiceImpl implements CalculatorService {

	@Override
	public int Add(String numbers) {
		// TODO Auto-generated method stub
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		String[] array = tokenizer(numbers);
		return sum(array);

	}

	private int sum(String[] array) {
		int sum = 0;
		List<Integer> negatives = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			int nb = toInt(array[i]);
			if (nb < 0) {
				negatives.add(nb);
			}
			if (nb > 1000) {
				continue;
			}
			sum += toInt(array[i]);
		}
		checkIfHaveNegativeNumber(negatives);
		return sum;
	}

	private void checkIfHaveNegativeNumber(List<Integer> negatives) {

		if (negatives.isEmpty()) {
			return;
		}
		StringBuilder message = new StringBuilder("negatives not allowed:");
		// throw new IllegalArgumentException("negatives not allowed:"
		// + nb);
		int i = 0;
		for (i = 0; i < negatives.size() - 1; i++) {
			message.append(negatives.get(i)).append(",");
		}
		message.append(negatives.get(i));
		throw new IllegalArgumentException(message.toString());
	}

	private String[] tokenizer(String numbers) {

		String regex = ",|\n";
		String customRegex = "//[\\[]?(.+)[\\]]?\\n(.+)";
		Pattern pattern = Pattern.compile(customRegex);
		Matcher match = pattern.matcher(numbers);
		if (match.matches()) {
			String newRegex = "["+match.group(1);
			String newNumber = match.group(2);
			return newNumber.split(newRegex);
		}
		return numbers.split(regex);
	}

	private Integer toInt(String number) {
		return Integer.parseInt(number);
	}

}
