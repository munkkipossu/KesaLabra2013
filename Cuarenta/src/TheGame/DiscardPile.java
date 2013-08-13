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
public class DiscardPile {
    
    private ArrayList<Card> pile;
    
    public DiscardPile(){
        this.pile = new ArrayList<Card>();
    }
    
    public int numberOfCards(){
        return this.pile.size();
    }
    
}
