package com.maxDev.cleanTextify;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class UserOperations {

	private static ArrayList<String> getWordList(String inputFilePath) throws FileNotFoundException {
		String input = FileOperations.getFileContent(inputFilePath);
		input = DataOperations.removeSymbols(input);
		input = DataOperations.removeStopwords(input);
		ArrayList<String> inputList = new ArrayList<>();
		String inputArray[] = input.split(" ");

		for (String string : inputArray) {
			inputList.add(string);
		}
		return inputList;
	}

	private static void print(ArrayList<Character> list) {
		for (Character character : list) {
			System.out.println(character);
		}
	}

	private static TreeSet<String> uniqueWordList(String inputFilePath) throws FileNotFoundException {
		TreeSet<String> uniqueList = new TreeSet<>(getWordList(inputFilePath));

		return uniqueList;
	}

	private static void print(Collection<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
	}

	private static String[][] getWordCount(ArrayList<String> wordList, TreeSet<String> uniqueWordList) {
		String[][] wordCount = new String[uniqueWordList.size()][2];

		int indexRow = 0;

		for (String string : uniqueWordList) {
			int count = Collections.frequency(wordList, string);
			wordCount[indexRow][0] = string;
			wordCount[indexRow][1] = String.valueOf(count);
			indexRow++;
		}
		return wordCount;
	}

	private static String[][] getTop5(String[][] wordCount) {
		String[][] top5 = new String[5][2];

		for (int i = 0; i < wordCount.length; i++) {

			for (int j = 0; j < wordCount.length; j++) {

				int value1 = Integer.parseInt(wordCount[i][1]);
				int value2 = Integer.parseInt(wordCount[j][1]);
				if (value1 > value2) {
					String temp1 = wordCount[i][0];
					wordCount[i][0] = wordCount[j][0];
					wordCount[j][0] = temp1;

					String temp2 = wordCount[i][1];
					wordCount[i][1] = wordCount[j][1];
					wordCount[j][1] = temp2;
				}
			}

		}

		for (int i = 0; i < 5; i++) {
			top5[i][0] = wordCount[i][0];
			top5[i][1] = wordCount[i][1];

		}

		return top5;
	}

	private static String[][] getTop10(String[][] wordCount) {
		String[][] top10 = new String[10][2];

		for (int i = 0; i < wordCount.length; i++) {

			for (int j = 0; j < wordCount.length; j++) {

				int value1 = Integer.parseInt(wordCount[i][1]);
				int value2 = Integer.parseInt(wordCount[j][1]);
				if (value1 > value2) {
					String temp1 = wordCount[i][0];
					wordCount[i][0] = wordCount[j][0];
					wordCount[j][0] = temp1;

					String temp2 = wordCount[i][1];
					wordCount[i][1] = wordCount[j][1];
					wordCount[j][1] = temp2;
				}
			}

		}

		for (int i = 0; i < 10; i++) {
			top10[i][0] = wordCount[i][0];
			top10[i][1] = wordCount[i][1];

		}

		return top10;
	}

	private static String[][] getBottom5(String[][] wordCount) {
		String[][] bottom5 = new String[5][2];

		for (int i = 0; i < wordCount.length; i++) {

			for (int j = 0; j < wordCount.length; j++) {

				int value1 = Integer.parseInt(wordCount[i][1]);
				int value2 = Integer.parseInt(wordCount[j][1]);
				if (value1 < value2) {
					String temp1 = wordCount[i][0];
					wordCount[i][0] = wordCount[j][0];
					wordCount[j][0] = temp1;

					String temp2 = wordCount[i][1];
					wordCount[i][1] = wordCount[j][1];
					wordCount[j][1] = temp2;
				}
			}

		}

		for (int i = 0; i < 5; i++) {
			bottom5[i][0] = wordCount[i][0];
			bottom5[i][1] = wordCount[i][1];

		}

		return bottom5;
	}

	private static String[][] getBottom10(String[][] wordCount) {
		String[][] bottom10 = new String[10][2];

		for (int i = 0; i < wordCount.length; i++) {

			for (int j = 0; j < wordCount.length; j++) {

				int value1 = Integer.parseInt(wordCount[i][1]);
				int value2 = Integer.parseInt(wordCount[j][1]);
				if (value1 < value2) {
					String temp1 = wordCount[i][0];
					wordCount[i][0] = wordCount[j][0];
					wordCount[j][0] = temp1;

					String temp2 = wordCount[i][1];
					wordCount[i][1] = wordCount[j][1];
					wordCount[j][1] = temp2;
				}
			}

		}

		for (int i = 0; i < 10; i++) {
			bottom10[i][0] = wordCount[i][0];
			bottom10[i][1] = wordCount[i][1];

		}

		return bottom10;
	}

	private static void print(String[][] stringCount) {
		for (int i = 0; i < stringCount.length; i++) {
			System.out.println(stringCount[i][0] + " " + stringCount[i][1]);
		}
	}

	public static void printAllUserCase(String inputFilePath) throws FileNotFoundException {

		System.out.println("========== ** Overll Word List ** ==========");
		ArrayList<String> wordList = getWordList(inputFilePath);
		print(wordList);
		System.out.println("========== ** Unique Word List ** ==========");
		TreeSet<String> uniqueWordList = uniqueWordList(inputFilePath);
		print(uniqueWordList);
		System.out.println("========== ** Overll Word Count ** ==========");
		String wordCount[][] = getWordCount(wordList, uniqueWordList);
		print(wordCount);
		System.out.println("========== ** Top 5** ==========");
		String top5[][] = getTop5(wordCount);
		print(top5);
		System.out.println("========== ** Top 10** ==========");
		String top10[][] = getTop10(wordCount);
		print(top10);
		System.out.println("========== ** Bottom 5** ==========");
		String bottom5[][] = getBottom5(wordCount);
		print(bottom5);
		System.out.println("========== ** Bottom 10** ==========");
		String bottom10[][] = getBottom10(wordCount);
		print(bottom10);

	}

}