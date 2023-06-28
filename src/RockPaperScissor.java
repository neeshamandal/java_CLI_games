import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
	public static void main(String [] args) {
		System.out.println("!!!!!LETS PLAY ROCK PAPER SCISSORS!!!!!");
		System.out.println();
		System.out.println();
		
		System.out.println("Enter 0 for Rock, 1 for Paper , 2 for Scissor");

		Scanner sc = new Scanner(System.in);
		
		while(true) {
		int userInput = sc.nextInt();
		if(userInput>2) {
			System.out.println("Invalid choice!!!!");
			return;
		}		
		
		Random rand = new Random(3);
		int computerInput = rand.nextInt(3);
		
		
		if(userInput == computerInput) {
			System.out.println("DRAW!!");
		}		
		else if(userInput==0 && computerInput==2 || userInput==1 && computerInput==0 || userInput==2 && computerInput==1) {
			System.out.println("HURRAYY YOU WON!!!!!");
		}
		else {
			System.out.println("computer won!!");
		}
		
		
		
		if(computerInput == 0) {
			System.out.println("computer choice: Rock");
		}
		else if(computerInput == 1) {
			System.out.println("computer choice: Paper");
		}
		else if(computerInput == 2) {
			System.out.println("computer choice: Scissors");
		}
		}
	}
		

}
