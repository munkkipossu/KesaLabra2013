/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;
import TheGame.*;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author tolaakso
 */
public class TablePanel extends JPanel {
    
    private ArrayList<Card> table;
    private TableListener tableListener;
    private ArrayList<Card> chosenCards;
    
    public TablePanel(CuarentaGame game){
        super(new GridLayout(4,5));
        this.tableListener = new TableListener();
        this.table = game.getTable();
        this.chosenCards= new ArrayList<Card>();
    }
    
    public void addCard(Card card){
        card.addMouseListener(tableListener);
        this.table.add(card);
        this.add(card);
    }
    
    public ArrayList<Card> getChosenCards(){
        return chosenCards;
    }
    
}
