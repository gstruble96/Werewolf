public class Playerhand {
  
  private Player player;
  private Card card;
  
  public Playerhand(Player player, Card card) {
    this.player = player;
    this.card = card;
  }
  
  public String toString() {
    return (player.toString() + " - " + card.toString());
}
}