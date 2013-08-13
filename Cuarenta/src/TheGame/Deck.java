


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
    
	private ArrayList<Card> cards;

	public Deck(){
                this.newCards();
	}

	public void shuffle(){
		this.newCards();    // the 'shuffling' is done in randomizing the deal, so shuffle just creates a full deck
	}

	private Card deal(){
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
        
        public void dealPlayerFiveCards(Player player){
            for(int i=0;i<5;i++){
                player.receiveCard(this.deal());
            }
        }


}
