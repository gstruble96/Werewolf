import java.util.Scanner;
import java.util.Collections;

public class Card {
  
  private String name;
  public int order;
  private String owner;
  
  
  public Card(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public String toString() {
    return name;
  }
  
 ///the main method for pregame operations
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter the number of players");
    int numplayer = input.nextInt();
    Player[] playas = new Player[numplayer];
    for (int i=0; i < numplayer; i++) {
      System.out.println("Enter player #"+(i+1));
      String playername = input.next();
      playas[i] = new Player(playername);
    }
    
    int numCards = numplayer + 3;
    MyLinkedList<Card> cards = new MyLinkedList<Card>();  
    for(int i = 0; i < numCards; i++) {
      System.out.println("Enter Card " + (i+1) + "/" + numCards);
      String cardName = input.next();
      cards.add(new Card(cardName));
    }
    
    Deck deck = new Deck(numCards, cards);
    
    deck.shuffle(numCards);
    
    MyLinkedList<Playerhand> table = new MyLinkedList<Playerhand>();
    for(int i = 0; i < numplayer; i++) {
      Playerhand hand = new Playerhand(playas[i], cards.get(i));
      table.add(hand);
    }
    System.out.println(table.toString());
    
    MyLinkedList<Card> middleCards = cards.extractSublist(numplayer,numCards-1);
    System.out.println("Cards in the middle: " + middleCards.toString());
    cards.prepend(middleCards);
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
      
    
}