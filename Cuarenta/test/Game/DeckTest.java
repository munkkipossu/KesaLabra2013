/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Deck;
import Game.Card;
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
import java.util.ArrayList;
public class DeckTest {
    
    public DeckTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void fourtyCardsDealt() { 
        Deck deck = new Deck();         
        Card card;    

         for(int i=0; i<40; i++){
            card=deck.deal();
            assertTrue(card != null);
        }
    }
    
    @Test
    public void moreThanFourtyIsNull(){
        Deck deck = new Deck();         
        Card card;    

        for(int i=0; i<41; i++){
            card=deck.deal();     
            if(i==40)
                assertTrue(card == null);
        }
    }
         
    @Test
    public void sameCardNotDealt(){
        Deck deck = new Deck();         
        Card card;
        ArrayList<Card> cardsDealt = new ArrayList<Card>();    

        for(int i=0; i<40; i++){
            card=deck.deal();     
            assertFalse(cardsDealt.contains(card));
            cardsDealt.add(card);
        }            
    }
    
    @Test
    public void fortyCardsDealtAfterShuffle(){
        Deck deck = new Deck();         
        Card card;    
        
        card = deck.deal();
        deck.shuffle();
        for(int i=0; i<40; i++){
            card=deck.deal();
            assertTrue(card != null);
        }
    }
    
    @Test
    public void checkDeckContains40Cards(){
        Deck deck = new Deck();
        
        assertTrue(deck.cardsLeft() == 40);
    }
    
    @Test
    public void checkDealingCardsDecreasesCardsLeft(){
        Deck deck = new Deck();
        Card card;
        
        for(int i=0; i<10; i++){
            card = deck.deal();
        }
        
        assertTrue(deck.cardsLeft() == 30);
    }
}
