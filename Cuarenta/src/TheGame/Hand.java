
/*
 * HAND:
 *  - starts with zero cards, they are dealt as game progresses
 *  - maximum of 5 cards
 *  - each card in hand can be viewed by the player
 * 
 * NOTE - I haven't decided (thought about) the mechanics of the game far enough to make a decision on how the logic will actually work (eg. how the logic deals (is it a method from the Deck, or the Hand and so on)
 */

package TheGame;
import java.util.ArrayList;

public class Hand {
    
    private ArrayList<Card> cards;
    
    public Hand(){
        this.cards = new ArrayList<Card>();
    }
    
    public void addCard(Card card){
        if(this.cards.size() < 6)
            this.cards.add(card);
    }
    
    public Card removeCard(int chosenCard){
        if(this.numberOfCards() < chosenCard){
            Card card = cards.get(chosenCard);
            cards.remove(chosenCard);
            return card;
        }
        else
            return null;
    }
    
    private int numberOfCards(){
        return this.cards.size();
    }
}
