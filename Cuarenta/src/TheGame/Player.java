
/*
 * The player must have the followin properties:
 *  - Name (because why not... or something?)
 *  - CardHolder = Hand = the cards that the player is dealt and can play
 *  - Discard pile = cards the player has won this round. Only the number of 
 *      cards in the discardpile matter (gameplay wise). Might be refactored out
 *      later
 *  - Points: The number of points the player has won so far.
 * 
 * ACTIONS: Not yet thought out where to be implemented
 *  - The player must be able to choose a card to play from their hand
 *  - To choose which cards he collects from the table (if possible)
 * 
 */

package TheGame;

public class Player{

	private String name;
        private Hand hand;
        private Discardpile discardpile;
        private int points;

	public Player(){
		this("dude");
	}	
        
	public Player(String name){
		this.name = name;
		this.hand = new Hand();
                this.discardpile = new Discardpile();    
                this.points = 0;
	}
        
        public void addPoints(int points){
            this.points += points;
        }
        
        public int getPoints(){
            return this.points;
        }

        public String getName(){
            return this.name;
        }
        
       public int numberOfCardsInHand(){
           return this.hand.numberOfCards();
       }
        
        
        public void receiveCard(Card card){
            this.hand.addCard(card);
        }
        
        public Card playCard(int cardNumber){
            return this.hand.removeCard(cardNumber);
        }
        
        
        
        public int sizeOfDiscardPile(){
            return this.discardpile.numberOfCards();
        }
        
        public void newDiscardpile(){
            this.discardpile = new Discardpile();
        }
        
        public void addCardToDiscardpile(Card card){
            this.discardpile.addCard(card);
        }
        
}
