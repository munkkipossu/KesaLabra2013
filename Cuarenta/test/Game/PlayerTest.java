/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Rank;
import Game.Player;
import Game.Card;
import Game.Suit;
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
public class PlayerTest {
    
    public PlayerTest() {
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
    public void checkTheSizeOfDiscardPile(){
        Player player = new Player();

        player.addCardToDiscardpile(new Card(Rank.ACE, Suit.HEARTS));
        player.addCardToDiscardpile(new Card(Rank.TWO, Suit.HEARTS));
        player.addCardToDiscardpile(new Card(Rank.THREE, Suit.HEARTS));
        
        assertTrue(player.sizeOfDiscardPile() == 3); 
    }
    
    @Test
    public void newDiscardpileIsEmpty(){
        Player player = new Player();

        player.addCardToDiscardpile(new Card(Rank.ACE, Suit.HEARTS));
        player.addCardToDiscardpile(new Card(Rank.TWO, Suit.HEARTS));
        player.addCardToDiscardpile(new Card(Rank.THREE, Suit.HEARTS));
        
        player.newDiscardpile();
        
        assertTrue(player.sizeOfDiscardPile() == 0); 
    }
    
    @Test
    public void playerRecievesCards(){
        Player player = new Player();
        
        player.receiveCard(new Card(Rank.ACE, Suit.CLUBS));
        player.receiveCard(new Card(Rank.QUEEN, Suit.DIAMONDS));
        
        assertTrue(player.numberOfCardsInHand() == 2);
    }
    
    @Test
    public void playedCardIsTheOneIntended(){
        Player player = new Player();
        
        player.receiveCard(new Card(Rank.ACE, Suit.CLUBS));
        player.receiveCard(new Card(Rank.QUEEN, Suit.DIAMONDS));
        
        assertTrue(player.playCard(1).equals(new Card(Rank.QUEEN, Suit.DIAMONDS)));
    }
    
    @Test
    public void playingCardDecreasesNumberOfCardsInHand(){
        Player player = new Player();
        
        player.receiveCard(new Card(Rank.ACE, Suit.CLUBS));
        player.receiveCard(new Card(Rank.QUEEN, Suit.DIAMONDS));
        
        player.playCard(1);
        
        assertTrue(player.numberOfCardsInHand() == 1);
    }


}
