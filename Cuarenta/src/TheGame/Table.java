

/*
 * The table functions in a simple manner. It simply holds the cards the players
 * have played to it. It must also allow cards to be removed (as players can do this
 * as well).
 */
package TheGame;
import java.util.ArrayList;


public class Table {
    private ArrayList<Card> cards;
    
    public Table(){
        this.cards = new ArrayList<Card>();
    }
    
    public void addCard(Card card){
        this.cards.add(card);
    }
    
    public Card removeCard(int chosenCard){
        Card card;
        if(chosenCard < this.numberOfCards()){
            card = this.cards.get(chosenCard);
            return card;
        }
         else
            return null;
    }
    public int numberOfCards(){
        return this.cards.size();
    }
}
