/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame;
import java.util.ArrayList;

/**
 *
 * @author tolaakso
 */
public class CardHolder {
    
    
    private ArrayList<Card> cards;
    
    public CardHolder(){
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
