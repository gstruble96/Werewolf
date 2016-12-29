public class Werewolf extends Card implements SeeCard{
  
  public Werewolf(String name) {
    super(name);
  }

  public void NightAction() {
    //wake up look for other werewolves
    //face = awake
    //if solo werewolf, look at card in middle
	int c = 5;
	
			
  }
  public void Setup() {
		// TODO Auto-generated method stub
		
	}

public static Werewolf addCard() {
	// TODO Auto-generated method stub
	return new Werewolf("Werewolf1");
}

}
