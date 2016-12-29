import java.util.Scanner;

public class Game {
	
	private static int CurrentState = 0;	
	
	public String getState(){
		if (CurrentState == 0){
			return "Setup";
		}
		else if(CurrentState ==  1){
			return "Night";
		}
		else if(CurrentState == 2){
			return "Day";
		}
		else if (CurrentState == 3){
			return "Vote";
		}
		return null;
	}
	
	public static void NextState(){
		CurrentState ++;
	}

	public static void Restart(){
		CurrentState = 0;
	}
	
	public static MyLinkedList<Object> getCardNumbers(){
		int middlecards = 3;
		Scanner input = new Scanner(System.in);
	    System.out.println("Enter the number of players");
	    int numplayer = input.nextInt();
	    int numcards = numplayer + middlecards;
	    
	    MyLinkedList<Object> ReturnList = new MyLinkedList<Object>();
	    ReturnList.add(numplayer);
	    ReturnList.add(numcards);
	    ReturnList.add(input);
	    return ReturnList;	 
	}
	public static Player[] setup(int numplayer, int numcards, Object input){
		Player[] playas = new Player[numplayer];
	    for (int i=0; i < numplayer; i++) {
	      System.out.println("Enter player #"+(i+1));
	      String playername = ((Scanner) input).next();
	      playas[i] = new Player(playername);
	    }
	    return playas;
	}
	
	public static void NightPhase(MyLinkedList<Card> cards, int numplayer){
		for (int i = 0; i < numplayer; i++){
			if (cards.getFirst() instanceof Werewolf){
				cards.getFirst().NightAction();
			}
		}
	}
	
	    
///the main method for pregame operations
public static void main(String[] args) throws Exception {
    MyLinkedList<Object> constants = getCardNumbers();
    int numplayer = (int) constants.getFirst();
    int numcards = (int) constants.get(1);
    Player[] playas = setup(numplayer, numcards, constants.getLast());
    
    MyLinkedList<Card> cards = new MyLinkedList<Card>();  
    for(int i = 0; i < numcards; i++) {
      System.out.println("Enter Card " + (i+1) + "/" + numcards);
      String cardName = ((Scanner) constants.getLast()).next();
      try {cards.add(Card.addCard(cardName));}
      catch(ClassNotFoundException m){Game.Restart();}
    }
    
   
    Deck deck = new Deck(numcards, cards);
    
    deck.shuffle(numcards);
    
    MyLinkedList<Playerhand>table = deck.ShowPlayers(playas);
    
    System.out.println(table.toString());
    
    MyLinkedList<Card> middleCards = cards.extractSublist(numplayer,numcards-1);
    System.out.println("Cards in the middle: " + middleCards.toString());
    cards.prepend(middleCards);
    
    NextState();
    NightPhase(cards, numplayer);
    }
}
    
   /* boolean yn = false;
    while(yn == false) {
    System.out.println("Would you like to play again?");
    String answer = input.next();
    if (answer == "yes") {
      yn = true;
      playAgain = true;
    }
    else if (answer == "no") {
      yn = true;
      playAgain = false;
    }
    else
      System.out.println("It's a yes or no question moron");
    }
    }*/
