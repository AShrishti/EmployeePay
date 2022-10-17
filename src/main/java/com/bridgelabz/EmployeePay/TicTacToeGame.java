package com.bridgelabz.EmployeePay;

public class TicTacToeGame {
	public void createBoard() {
		char[] board = new char[10];
		for (char i = 1; i < 10; i++)
			board[i] = ' ';

	}

	public static void main(String[] args) {
		TicTacToeGame boardObj = new TicTacToeGame();
		boardObj.createBoard();
	}
}
