import java.util.Scanner;
import java.util.Collections;

public abstract class Card extends Game{
  
  private Deck d;
  private static String name;
  public int order;
  private String owner;
  
  
  public Card(String name) {
    this.name = name;
  }
  
  public static String getName() {
    return name;
  }
  
  public String toString() {
    return name;
  }
  
  public abstract void Setup();
  
  public static Card addCard(String cardName) throws Exception{
	 
	  if (cardName == "Werewolf"){
		  return Werewolf.addCard();
	  }
	 ClassNotFoundException m = new ClassNotFoundException("That's not a card ya dumb fuk");
	 throw m;
  }
  
  public abstract void NightAction();
	  
  public int middlecards = Deck.getMiddleCards();

}
