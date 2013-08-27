/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;
import TheGame.*;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 *
 * @author tolaakso
 */
public class TablePanel extends JPanel {
    
    private Table table;
    private TableListener tableListener;
    private Card[] chosenCards;
    
    public TablePanel(CuarentaGame game){
        super(new GridLayout(4,5));
 //       this.cardListener = new TableListener;
        this.table=game.getTable();
        this.chosenCards=null;
    }
    
    public void addCard(Card card){
        this.table.addCard(card);
        
    }
    
    
    public Card[] getChosenCards(){
        Card[] cards = new Card[2];
        cards[0]= new Card(Rank.TWO, Suit.CLUBS);
        cards[1]= new Card(Rank.TWO, Suit.CLUBS);
        return cards;
    }
    
}
