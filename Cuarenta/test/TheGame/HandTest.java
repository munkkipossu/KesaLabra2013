/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tolaakso
 */
public class HandTest {
    
    public HandTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void HandCanReceiveFiveCards(){
        Hand hand = new Hand();
        Deck deck = new Deck();
        
        for(int i=0; i<5; i++){
            hand.addCard(deck.deal());
            assertTrue(hand.numberOfCards() == i+1);
        }
    }

    public void HandCanRejectsSixthCard(){
        Hand hand = new Hand();
        Deck deck = new Deck();
        
        for(int i=0; i<6; i++){
            hand.addCard(deck.deal());
        }
            assertTrue(hand.numberOfCards() == 5);
    }

 /*   public void HandKnowsHowManyCardsItHolds(){
        Hand hand = new Hand();
        Deck deck = new Deck();
        
    }
   */ 
    
}
