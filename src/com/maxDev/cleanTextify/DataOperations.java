package com.maxDev.cleanTextify;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DataOperations {

	public static String removeSymbols(String input) throws FileNotFoundException {
		ArrayList<String> symbolList = FileOperations.getStopword("C:\\Users\\Mrityunjay\\Desktop\\symbolFile.txt");
		char inputCharArray[] = input.toCharArray();
		ArrayList<Character> inputList = new ArrayList<>();

		for (char c : inputCharArray) {
			inputList.add(c);
		}
		inputList.removeAll(symbolList);
		input = "";
		for (Character character : inputList) {
			input = input + character;
		}
		return input;
	}

	public static String removeStopwords(String input) throws FileNotFoundException {
		ArrayList<String> stopList = FileOperations.getStopword("C:\\Users\\Mrityunjay\\Desktop\\stopWords.txt");

		stopList.add("");
		String inputArray[] = input.split(" ");
		ArrayList<String> inputList = new ArrayList<>();
		for (String string : inputArray) {
			inputList.add(string);
		}

		inputList.removeAll(stopList);
		input = "";
		for (String string : inputList) {
			input = input + string + " ";
		}

		return input;
	}
}