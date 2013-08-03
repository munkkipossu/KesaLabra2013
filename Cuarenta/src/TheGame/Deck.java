


/*
 * The Deck should work as follows:
 *  -It contains 40 Cards:
 *      - 1-7, jack, queen, king of each suit
 *  -It contains a function that deals one card randomly
 *      - the same card should not be dealt multiple times
 *      - the deck can ONLY deal the 40 cards it possesses
 *  -Shuffling of the deck returns again all 40 cards to its
 */

package TheGame;
import java.util.ArrayList;


public class Deck{

    /*
     * What follows below is some quick coding for the concepts, not working code (sadly)s
     */
    
	private ArrayList<Card> cards;

	public Deck(){
                this.newCards();
	}

	public void shuffle(){
		this.newCards();    // the 'shuffling' is done in randomizing the deal, so shuffling just creates a full deck
	}

	public Card deal(){
		int chosenCard = 1; // TO BE IMPLEMENTED: randomInt(1,this.cards.size());
		Card chosen = this.cards.get(chosenCard);
		this.cards.remove(chosenCard);
		return chosen;
	}

        private void newCards(){
            this.cards = new ArrayList<Card>();

            for(Rank rank : Rank.values()){
                for(Suit suit : Suit.values()){

                    this.cards.add(new Card(rank, suit));
                }
            }

        }
}
