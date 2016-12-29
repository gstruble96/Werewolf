import java.util.Random;
import java.util.Scanner;


public class Deck{
  
  private int numCards;
  private MyLinkedList<Card> cards;
  
  public Deck(int numCards) {
    this.numCards = numCards;
    //make default list
  }
  
  public Deck(int numCards, MyLinkedList<Card> cards) {
    this.numCards = numCards;
    this.cards = cards;
  }
  
  public MyLinkedList<Card> getCards() {
    return cards;
}
  private static int middlecards = 3;
  
  public static int getMiddleCards(){
	  return middlecards;
  }
  
  /*public void shuffle(int numCards) {
    for (int i=numCards-1; i >0; i--) {
      int rand = (int) (Math.random()*(i+1));
      Card temp = cards.get(i);
      cards.get(i) = cards.get(rand);
      cards.get(rand) = temp;
    }
  }*/
  
  public void shuffle(int numCards) {
    int count = 0;
    while (count < numCards) {
      Card temp = cards.remove(count % cards.size);
      int i = (int) (Math.random()*cards.size);
      Card rand = cards.set(i,temp);
      cards.add((count % (cards.size+1)), rand);
      count++;
  }
    int county = 0;
    while(county<1) {
    Random rng = new Random();
      int beg = rng.nextInt(numCards);
      int end = rng.nextInt(numCards);
      if(beg<end) {
      cards.prepend(cards.extractSublist(beg,end));
      county++;
      }
    }
    }
  
   public MyLinkedList<Playerhand> ShowPlayers(Player[] playas) {
	   MyLinkedList<Playerhand> table = new MyLinkedList<Playerhand>();
	   for(int i = 0; i < numCards - middlecards; i++) {
		   Playerhand hand = new Playerhand(playas[i], cards.get(i));
		   table.add(hand);
   }
	return table;
    
  }
}
   
   ///the main method for pregame operations


    
    
    
    
    
    
    /*public void shuffle(int numCards) {
    int count = 0;
    while(count < 30) {
      Random rng = new Random();
      int beg = rng.nextInt(numCards);
      int end = rng.nextInt(numCards);
      if(beg<end) {
      cards.prepend(cards.extractSublist(beg,end));
      count++;
      }
    }*/
