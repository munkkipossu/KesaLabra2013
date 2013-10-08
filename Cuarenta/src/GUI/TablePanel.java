/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Game.CuarentaGame;
import Game.Card;
import Game.Rank;
import Game.Suit;
import Game.Table;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author tolaakso
 */
public class TablePanel extends JPanel {
    
    private Table table;
    private ArrayList<Card> chosenCards;
    private Card[] cards;
    
    public TablePanel(CuarentaGame game){
        super(new GridLayout(1,7));
        this.table = game.getTable();
        this.chosenCards= new ArrayList<Card>();
        this.cards = new Card[40];
    }
    
    
        
    public ArrayList<Card> getChosenCards(){
        return chosenCards;
    }
      
    public void drawTable(){
        
        this.removeAll();
                
        try{
          System.out.println("Table contains:");
   /*         for(int i=0; i<this.table.numberOfCards(); i++){
                System.out.println(cards[i]);
   
   * }*/
 
            
           // for(int i=0;i<2;i++)
            //    this.add(new Card(Rank.KING, Suit.SPADES));
 
            this.add(new Card(Rank.KING, Suit.HEARTS));
            for(int i=0;i<this.table.numberOfCards();i++){
      //         this.cards[i]=new Card(Rank.ACE, Suit.HEARTS);

                this.cards[i]=this.table.getCard(i);
                this.cards[i].addMouseListener(new TableListener(this.chosenCards));
                this.add(cards[i]);
                System.out.println("i: " + i + " " + cards[i]);
            }
            
            System.out.println("This table JPANEL has: "  + this.getComponentCount() + " components.");

        }

        catch(Exception e){
            System.out.println("failed trying to draw the table");
        }
    }
}
