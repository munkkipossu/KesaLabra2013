
package TheGame;

public class Player{

	private String name;
        private Hand hand;
        private DiscardPile discardPile;

	public Player(){
		this("dude");
	}	
        
	public Player(String name){
		this.name = name;
		this.hand = new Hand();
                this.discardPile = new DiscardPile();                
	}
        
        public void receiveCard(Card card){
            this.hand.addCard(card);
        }
        
        public Card playCard(int cardNumber){
            return this.hand.removeCard(cardNumber);
        }
}
