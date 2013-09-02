

package Game;
import java.util.ArrayList;



/**
 * The Deck should work as follows:
 *  -It contains 40 Cards:
 *      - 1-7, jack, queen, king of each suit
 *  -It contains a function that deals one card randomly
 *      - the same card should not be dealt multiple times
 *      - the deck can ONLY deal the 40 cards it possesses
 *  -Shuffling of the deck returns again all 40 cards
 * 
 * @author Teemu Laakso
 */

public class Deck{
    
	private ArrayList<Card> cards;

	public Deck(){
                this.newCards();
	}

	public void shuffle(){
		this.newCards();    // the 'shuffling' is done in randomizing the deal, so shuffle just creates a full deck
	}

        /**
         * The method deals a card from possible cards that it possesses.
         * The same card cannot be dealt twice (or more).
         * 
         * @return a new card from the deck. After 40 cards
         * have been dealt, returns null.
         */
	public Card deal(){
            if(this.cards.size() == 0)
                return null;
            int chosenCard = 0; // TO BE IMPLEMENTED: randomInt(0,this.cards.size()-1);
            Card dealtCard = this.cards.get(chosenCard);
            this.cards.remove(chosenCard);
            return dealtCard;
	}

        private void newCards(){
            this.cards = new ArrayList<Card>();

            for(Rank rank : Rank.values()){
                for(Suit suit : Suit.values()){
                    this.cards.add(new Card(rank, suit));
                }
            }

        }
        
        public int cardsLeft(){
            return this.cards.size();
        }
        
        
}
