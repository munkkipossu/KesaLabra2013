
package TheGame;

public class Player{

	private String name;
        private CardHolder hand;
        private DiscardPile discardPile;
        private int points;

	public Player(){
		this("dude");
	}	
        
	public Player(String name){
		this.name = name;
		this.hand = new CardHolder();
                this.discardPile = new DiscardPile();    
                this.points = 0;
	}
        
        public void addPoints(int points){
            this.points += points;
        }
        
        public int getPoints(){
            return this.points;
        }
        
        public void receiveCard(Card card){
            this.hand.addCard(card);
        }
        
        
        public Card playCard(int cardNumber){
            return this.hand.removeCard(cardNumber);
        }
}
