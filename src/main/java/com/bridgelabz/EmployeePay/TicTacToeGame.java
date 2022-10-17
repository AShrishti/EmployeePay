package com.bridgelabz.EmployeePay;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicTacToeGame {
	/**
	 * @describe Created Board
	 */
	public void createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < board.length; i++)
			board[i] = ' ';

		for (char b : board)
			System.out.print(b);

	}

	public void choosePlayer() {
		char computer;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Character X or O");

		char player = sc.nextLine().charAt(0);
		if (player == 'X') {
			computer = 'O';
		} else
			computer = 'X';
		sc.close();
	}

	public static void main(String[] args) {
		TicTacToeGame boardObj = new TicTacToeGame();
		boardObj.createBoard();
		boardObj.choosePlayer();
	}
}
