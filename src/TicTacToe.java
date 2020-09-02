import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		char[] board = createBoard();
		displayBoard(board);
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		char player = 'X';
		boolean decisionReached = false;
		int position = -1;
		while (decisionReached == false) {
			System.out.println(player+"'s turn: Enter the number on the board (0-8)");
			if (scan.hasNext()) {
				position = scan.nextInt();
				if (position >= 0 && position <= 8) {
					if (board[position] == ' ') {
						board[position] = player;
					} else {
						System.out.println("Position already filled. Choose a different number on the board (0-8)");
						continue;
					}
				} else {
					System.out.println("Wrong number. Enter the number on the board (0-8)");
					continue;
				}
				
				displayBoard(board);
				if (count >= 4) {
					if (decideWinner(board) == true) {
						decisionReached = true;
						break;
					} else if (count == 8) {
						// This is last
						break;
					}
				}
				player = whichPlayer(player);

				count++;
			}
		}
		if (decisionReached == true) {
			System.out.println("-------  "+ player +" is the winner! --------");
		} else {
			System.out.println("------- Game ended in a draw! WARGAMES!! -------");
		}
		scan.close();
	}
	
	private static boolean decideWinner(char[] board) {
		String b1 = board[0] + "" + board[1] + "" + board[2];
		String b2 = board[3] + "" + board[4] + "" + board[5];
		String b3 = board[6] + "" + board[7] + "" + board[8];
		String b4 = board[0] + "" + board[3] + "" + board[6];
		String b5 = board[1] + "" + board[4] + "" + board[7];
		String b6 = board[2] + "" + board[5] + "" + board[8];
		String b7 = board[0] + "" + board[4] + "" + board[8];
		String b8 = board[2] + "" + board[4] + "" + board[6];
		if ((b1.length() == 3 && decider(b1) == "Winner") ||
			(b2.length() == 3 && decider(b2) == "Winner") ||
			(b3.length() == 3 && decider(b3) == "Winner") ||
			(b4.length() == 3 && decider(b4) == "Winner") ||
			(b5.length() == 3 && decider(b5) == "Winner") ||
			(b6.length() == 3 && decider(b6) == "Winner") ||
			(b7.length() == 3 && decider(b7) == "Winner") ||
			(b8.length() == 3 && decider(b8) == "Winner")) {
			return true;
		} else {
			return false;
		}
	}

	private static String decider(String row) {
		if (row.equals("XXX") || row.equals("OOO")) {
			return "Winner";
		} else {
			return "No Result";
		}
	}
	
	private static char whichPlayer(char existing) {
		if (existing == 'X') {
			return 'O';
		} else {
			return 'X';
		}
	}
	
	private static void displayBoard(char[] board) {
		System.out.println("Board as of now");
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| "+board[i]+" ");
		}
		System.out.println("|");
		System.out.println("-------------");
		for (int i = 3; i < 6; i++) {
			System.out.print("| "+board[i]+" ");
		}
		System.out.println("|");
		System.out.println("-------------");
		for (int i = 6; i < 9; i++) {
			System.out.print("| "+board[i]+" ");
		}
		System.out.println("|");
		System.out.println("-------------");
	}
	
	private static char[] createBoard() {
		char[] board = new char[9];
		for(int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}
}
