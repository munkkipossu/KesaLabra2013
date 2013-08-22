
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

    public void addCard(Card card) {
        if (this.cards.size() < 6) {
            this.cards.add(card);
        }
    }

    public Card removeCard(int chosenCard) {
        if (this.numberOfCards() > chosenCard) {
            Card card = this.cards.get(chosenCard);
            this.cards.remove(chosenCard);
            return card;
        } else {
            System.out.printf("Am i here?");
            return null;
        }
    }

    public int numberOfCards() {
        return this.cards.size();
    }
}
