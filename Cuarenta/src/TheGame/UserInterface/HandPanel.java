/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame.UserInterface;
import javax.swing.JPanel;
import TheGame.Hand;
import TheGame.Card;
import TheGame.Suit;
import TheGame.Rank;
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
    private Card[] cardsShown;
    private CardListener cardListener;
    private Card chosenCard;
    private int points;
    private JLabel pointLabel;
    private Card emptyCard;
    
    public HandPanel(Hand hand, int points){
        super(new GridLayout(1, 7));
        this.hand = hand;
        this.chosenCard=null;
        this.cardListener = new CardListener(this);
        this.cardsShown = new Card[5];
        this.emptyCard = new Card(Rank.TWO, Suit.HEARTS);
        emptyCard.setIcon(new ImageIcon());
        
        initiatePanel(hand, cardsShown);
                
        JPanel pointPanel = new JPanel(new BorderLayout());
        pointPanel.add(new JLabel("Points"), BorderLayout.NORTH);
        this.pointLabel = new JLabel(""+points);
        pointPanel.add(pointLabel, BorderLayout.CENTER);
        this.add(pointPanel);
        
        JPanel discardPanel = new JPanel(new BorderLayout());
        discardPanel.add(new JLabel("Discardpile"), BorderLayout.NORTH);
        discardPanel.add(new JLabel("0"), BorderLayout.CENTER);
        this.add(discardPanel);
    }
    
    
    private void initiatePanel(Hand hand, Card[] cardsShown){
        try{
            for(int i=0;i<this.hand.numberOfCards();i++){
                cardsShown[i] = this.hand.getCard(i);
                cardsShown[i].addMouseListener(cardListener);
                this.add(cardsShown[i]);
            }
            for(int i=this.hand.numberOfCards(); i<5;i++){
                this.add(new JLabel(""));
            }
        } catch(Exception e)
        {
            System.out.println("error in drawing the cards");
        }
    }

    
    public void setChosenCard(Card card){
        this.chosenCard=card;
    }
    
    public Card getChosenCard(){
        chosenCard.removeMouseListener(cardListener);
        chosenCard.setEmptyIcon();
        Card card = chosenCard;
        chosenCard = null;
        return card;
    }
}
