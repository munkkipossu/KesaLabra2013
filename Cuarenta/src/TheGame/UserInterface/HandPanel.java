/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;
import javax.swing.JPanel;
import TheGame.Hand;
import TheGame.Card;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 *
 * @author tolaakso
 */
public class HandPanel extends JPanel {
    
    private Hand hand;
    private CardListener cardListener;
    private Card chosenCard;
    private int points;
    
    public HandPanel(Hand handm int points){
        super(new GridLayout(1, 7));
        this.hand = hand;
        this.chosenCard=null;
        this.cardListener = new CardListener(this);
        try{
            for(int i=0;i<this.hand.numberOfCards();i++){
                Card card = this.hand.getCard(i);
                card.addMouseListener(cardListener);
                this.add(card);
            }
            for(int i=this.hand.numberOfCards(); i<5;i++){
                this.add(new JLabel(""));
            }
        } catch(Exception e)
        {
            System.out.println("error in drawing the cards");
        }
        
        JPanel pointPanel = new JPanel(new BorderLayout());
        pointPanel.add(new JLabel("Points"), BorderLayout.NORTH);
        pointPanel.add(new JLabel(""+points), BorderLayout.CENTER);
        this.add(pointPanel);
        
        JPanel discardPanel = new JPanel(new BorderLayout());
        discardPanel.add(new JLabel("Discardpile"), BorderLayout.NORTH);
        discardPanel.add(new JLabel("0"), BorderLayout.CENTER);
        this.add(discardPanel);
    }
    
    
    public void setChosenCard(Card card){
        this.chosenCard=card;
    }
    
    public Card getChosenCard(){
        chosenCard.removeMouseListener(cardListener);
        chosenCard.setEmptyIcon();
        return this.chosenCard;
    }
}
