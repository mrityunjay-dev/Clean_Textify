package com.maxDev.cleanTextify;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

	public static String getFileContent(String inputFilePath) throws FileNotFoundException {
		File file = new File(inputFilePath);
		try (Scanner sc = new Scanner(file)) {
			String inputMessage = "";
			while (sc.hasNext()) {
				inputMessage = inputMessage.concat(sc.next() + " ");
			}
			return inputMessage.toLowerCase();
		}
	}

	public static ArrayList<Character> getSymbols(String inputFilePath) throws FileNotFoundException {
		File file = new File(inputFilePath);
		try (Scanner sc = new Scanner(file)) {
			ArrayList<Character> charList = new ArrayList<>();
			while (sc.hasNext()) {
				String next = sc.next();
				charList.add(next.charAt(0));
			}
			return charList;
		}
	}

	public static ArrayList<String> getStopword(String inputFilePath) throws FileNotFoundException {
		File file = new File(inputFilePath);
		try (Scanner sc = new Scanner(file)) {
			ArrayList<String> stopwordList = new ArrayList<>();
			while (sc.hasNext()) {
				String next = sc.next();
				stopwordList.add(next);
			}
			return stopwordList;

		}
	}

}
