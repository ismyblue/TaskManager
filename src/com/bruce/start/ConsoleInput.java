package com.bruce.start;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInput implements input {

	private Scanner scanner;

	public ConsoleInput() {
		this.scanner = new Scanner(System.in);
		this.scanner.useDelimiter(Pattern.compile("\n"));
	}

	public Scanner getScanner() {
		return scanner;
	}

	@Override
	public void asking(String ask) {

		System.out.println(ask);
	}

}
