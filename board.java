import java.util.Random;
import java.util.Scanner;

public class board {
	card[][] cardPlacement = new card[5][5];
	

	board() {
		card emptySpaces = new card();
		emptySpaces.createCard("X");
		cardPlacement[2][0]= emptySpaces;
		cardPlacement[2][4]= emptySpaces;
		cardPlacement[3][0]= emptySpaces;
		cardPlacement[3][4]= emptySpaces;
		cardPlacement[4][4]= emptySpaces;
	}
	
	void displayBoard(){
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++)	{
			if(cardPlacement[i][j]!= null) {
				System.out.print("  " );
				cardPlacement[i][j].printIt();
				System.out.print("  " );
				}
			else {
				System.out.print(" ___ " );
				
				}
			
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("DISCARDED CARDS:");
		
		
		
		
		for(int i=4; i<5; i++) {
			for(int j=0; j<4; j++)	{
			if(cardPlacement[i][j]!= null) {
				System.out.print("  " );
				cardPlacement[i][j].printIt();
				System.out.print("  " );
				}
			else {
				System.out.print(" ___ " );
				
				}
			
			}
			System.out.println();
		}
		
		
	}
	
	
	
	void placeCard (card currentCard) {
		boolean validSquare = false;
		int row=0;
		int column=0;

		while(validSquare == false) {
			
		
		  System.out.println();  
		  System.out.println("Give row (for first row enter 0)");
		  Scanner scan = new Scanner(System.in);
		  row = scan.nextInt();
		
		  System.out.println("Give column (for first column enter 0)");
		  Scanner scan2 = new Scanner(System.in);
		  column = scan2.nextInt();
		  
		  if (row <5 && column<5) {
			  if (cardPlacement[row][column] == null ) {
			  validSquare = true;
			  cardPlacement[row][column] = currentCard;
			  }
		  }
		  
		  		else {
		  			System.out.println("non valid space, try again");
		  			}
		  
		  
			  
			  
		}  
		
		
	}
	
	
	int isGameFinished(int i) {
		
		boolean finishedGame=true;
		
		
		for(int j=0; j<4; j++) {
			for(int k=0; k<5; k++)	{
			if(cardPlacement[j][k]== null) {
				finishedGame=false;
				}
			
			}
			
		}
		
		if (finishedGame ==true) {
			return 20;
		}
		else {
			return i;
		}


	}
		
	
	int calculateScoreAux(int rowAddition, String hasAnAce, String potentialblackjack) {
		int returner = 0;
		
		if (hasAnAce =="YES"){
				if (rowAddition + 10 < 22) {
					rowAddition =rowAddition+10;
				}
			}
		
		if(rowAddition<17) {
			returner = 1;
		}

		if(rowAddition==17) {
			returner = 2;
		}
		if(rowAddition==18) {
			returner = 3;
		}
		if(rowAddition==19) {
			returner =4;
		}
		if(rowAddition==20) {
			returner = 5;
	    }
		
		if(rowAddition>21) {
			returner = 0;
			}
		if(rowAddition==21) {
			if (potentialblackjack == "YES") {
			returner = 21;
			}
			returner = 7;
			}
		
		return returner;
	}
		
		
	
	
		void calculateScore() {
			int sumHorizontal =0;
			int sumVertical =0;
			int score = 0;
			String hasAnAce ="NO";
			String potentialblackjack ="NO";
			
			for(int i=0; i<4; i++) {
				sumHorizontal = 0;
				hasAnAce ="NO";
					for(int j=0;j<5;j++) {
					
					sumHorizontal = sumHorizontal + cardPlacement[i][j].value;
					if(cardPlacement[i][j].valueOfCard=="A") {
						hasAnAce="YES";
						
					}
					
					
				}
				
					score= score + calculateScoreAux(sumHorizontal,hasAnAce,"NO");
				
			}
			
			for(int k=0; k<5; k++) {
				sumVertical = 0;
				hasAnAce ="NO";
				for(int l=0;l<4;l++) {
					
					sumVertical = sumVertical + cardPlacement[l][k].value;
					if(cardPlacement[l][k].valueOfCard=="A") {
						hasAnAce="YES";
					}
					
					
				}
				if(k==0 || k==4) {
					potentialblackjack = "YES";
				}
				score= score + calculateScoreAux(sumVertical,hasAnAce, potentialblackjack);
			}
			
			System.out.println("YOUR FINAL SCORE IS; " + score);	
		}
	
	
	
	
	
	public static void main(String[] args) {
		board newGame = new board();
		deck shuffledDeck = new deck();
		  
		newGame.displayBoard();
		
		for(int i=0; i<20; i++)
		{
			Random random = new Random();
			int r = random.nextInt(52);
			//System.out.println(r);
			System.out.println();
			System.out.print("next card is: ");
			shuffledDeck.deckCards[r].printIt();

			  
			  newGame.placeCard(shuffledDeck.deckCards[r]);
			  newGame.displayBoard();
			  
			 System.out.println();
			 System.out.println();
			 System.out.println();
			 System.out.println();
			 

			 i = newGame.isGameFinished(i);
		}
		newGame.calculateScore();
		
		
	}
}
