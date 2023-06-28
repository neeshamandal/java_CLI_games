import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static ArrayList<Integer> playerPosition = new ArrayList<>();
	static ArrayList<Integer> cpuPosition = new ArrayList<>();

	public static void main(String[] args) {
		
		char[][] gameBoard = {{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '}};
		
		printGameBoard(gameBoard);
		
		while(true) {
			System.out.println("enter a number for position of X (1-9)");
			
			Scanner scan = new Scanner(System.in);	
			int userPos = scan.nextInt();	
			while(playerPosition.contains(userPos) || cpuPosition.contains(userPos)) {
				System.out.println("position taken!! Enter correct position!!");
				userPos = scan.nextInt();
			}
			
			placePosition(gameBoard,userPos, "player");
			if(checkWinner()==1) {
				printGameBoard(gameBoard);	
				break;
			};
			
			Random random = new Random();
			int cpuPos = random.nextInt(9)+1;
			while(cpuPosition.contains(cpuPos) || playerPosition.contains(cpuPos)) {
				cpuPos = random.nextInt(9)+1;
			}
			placePosition(gameBoard,cpuPos, "cpu");
			printGameBoard(gameBoard);	
			if(checkWinner()==1) {
				break;
			};
			
			
			
	}

	}
	public static void printGameBoard(char[][] gameBoard) {
		for(char [] row: gameBoard) {
			for(char col: row) {
				System.out.print(col);
			}
			System.out.println();
		}
		
	}
	
	public static void placePosition(char[][] gameBoard, int Pos, String user) {
		 char symbol = ' ';
		 
		 if(user.equals("player")) {
			 symbol = 'X';
			 playerPosition.add(Pos);
		 }
		 else if(user.equals("cpu")) {
			 symbol = 'O';
			 cpuPosition.add(Pos);
		 }
		
		
		switch(Pos) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
		}
		
	}
	
	public static int checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List bottomCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(bottomCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if(playerPosition.containsAll(l)){
				System.out.println(" congratulations!!!! YOU WON!!!");
				return 1;
			}
			else if(cpuPosition.containsAll(l)) {
				System.out.println("cpu won! you lose :(");
				return 1;
			}
		}
		
		if(playerPosition.size() + cpuPosition.size() == 9) {
			System.out.println("Its a tie!!"); 
			return 1;
		}
		
		return 0;
	}

}
