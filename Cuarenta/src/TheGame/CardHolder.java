
package TheGame;

/**
 * CardHolder represents a collection of cards. I'm not sure how necessary it is.
 * I might just simply replace it with an 'ArrayList<Card>' at some point, 
 * but I'll let it stay for now. An advantage could be gained from enforcing an
 * upperlimit for the number of cards it can hold.
 *
 * @author Teemu Laakso 
 */

import java.util.ArrayList;

public class CardHolder {

    private ArrayList<Card> cards;
    
    
    public CardHolder() {
        this.cards = new ArrayList<Card>();
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }
    
    public void addCard(Card card) {
        if (this.cards.size() < 5) {
            this.cards.add(card);
        }
    }
    
    public Card removeCard(int chosenCard){
        Card card = this.getCard(chosenCard);
        this.cards.remove(chosenCard);
        return card;
    }
    
    public Card removeCard(Card chosenCard) {
        this.cards.remove(chosenCard);
        return chosenCard;
    }

    public int numberOfCards() {
        return this.cards.size();
    }
}
