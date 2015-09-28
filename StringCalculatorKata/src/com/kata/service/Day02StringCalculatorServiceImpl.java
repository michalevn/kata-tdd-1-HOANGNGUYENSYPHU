package com.kata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02StringCalculatorServiceImpl implements CalculatorService {

	public int Add(String numbers) {
		// TODO Auto-generated method stub
		if (numbers == null || numbers.equals("")) {
			return 0;
		}
		String[] array = tokenzike(numbers);
		int sum = sumArray(array);
		return sum;
	}

	private int sumArray(String[] array) {
		int sum = 0;
		List<Integer> negaties = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			Integer nb = Integer.parseInt(array[i]);
			if (nb < 0) {
				negaties.add(nb);
			}
			if (nb > 1000) {
				continue;
			}
			sum += nb;
		}
		if (negaties.size() > 0) {
			String errorMessage = "negatives not allowed:";
			for (int i = 0; i < negaties.size() - 1; i++) {
				errorMessage += negaties.get(i) + ",";
			}
			errorMessage += negaties.get(negaties.size() - 1);
			throw new IllegalArgumentException(errorMessage);

		}
		return sum;
	}

	private String[] tokenzike(String numbers) {

		String regex = "//\\[(.+)\\]\n(.+)";
		Pattern patter = Pattern.compile(regex);
		Matcher match = patter.matcher(numbers);
		if (match.matches()) {

			String newRegex = match.group(1);
			String newNumbers = match.group(2);
			String[] array = newNumbers.split(newRegex);
			return array;

		} else {
			String[] array = numbers.split(",|\n");
			return array;
		}
	}

}
