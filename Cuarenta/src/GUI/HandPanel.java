 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.swing.JPanel;
import Game.Hand;
import Game.Card;
import Game.Suit;
import Game.Rank;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 *
 * @author tolaakso
 */
public class HandPanel extends JPanel {
    
    private Hand hand;
    private Card[] cardsShown;
    private CardListener cardListener;
    private Card chosenCard;
    private int points;
    private int discardpile;
    private JLabel pointLabel;
    
    public HandPanel(Hand hand){
        super(new GridLayout(1, 7));
        this.hand = hand;
        this.chosenCard=null;
        this.cardListener = new CardListener(this);
        this.cardsShown = new Card[5];
        this.discardpile = 0;
        this.points=0;
        
        drawHand();
    }
    
    public void drawHand(){
        
        this.removeAll();
        
        try{
            for(int i=0;i<this.hand.numberOfCards();i++){
                this.cardsShown[i] = this.hand.getCard(i);
                this.cardsShown[i].addMouseListener(this.cardListener);
                this.add(cardsShown[i]);
             }
                
            for(int i=this.hand.numberOfCards(); i<5;i++){
                this.add(new JLabel(""));
            }
            
                            
        JPanel pointPanel = new JPanel(new BorderLayout());
        pointPanel.add(new JLabel("Points"), BorderLayout.NORTH);
        this.pointLabel = new JLabel(""+points);
        pointPanel.add(pointLabel, BorderLayout.CENTER);
        this.add(pointPanel);
        
        JPanel discardPanel = new JPanel(new BorderLayout());
        discardPanel.add(new JLabel("Discardpile"), BorderLayout.NORTH);
        discardPanel.add(new JLabel(""+discardpile), BorderLayout.CENTER);
        this.add(discardPanel);
        } catch(Exception e)
        {
            System.out.println("error in drawing the cards");
        }
    }

    
    public void setChosenCard(Card card){
        this.chosenCard=card;
    }

    public void updatePoints(int points){
        this.points=points;
    }
    
    public void updateDiscardpileSize(int pile){
        this.discardpile=pile;
    }
    
    public Card getChosenCard(){
         return this.chosenCard;
    }
}
