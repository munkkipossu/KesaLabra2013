/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import Game.*;
import java.util.ArrayList;

/**
 *
 * @author mp
 */
public class LogicTest {
    
    public LogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new CuarentaGame("human", true);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pointsAddedIfLastCardPlayedIsChosen() { 
        Card tableCard = new Card(Rank.QUEEN, Suit.HEARTS);
        game.getTable().addCard(tableCard);
        ArrayList<Card> chosenCards = new ArrayList<Card>();
        chosenCards.add(tableCard);        
        
        Card playedCard = new Card(Rank.QUEEN, Suit.CLUBS);
        game.getHuman().addCard(playedCard);
        
        humanMove(game, playedCard, chosenCards);
        
        assertTrue(game.getHumanPlayer.getPoints() == 2);
    }

    @Test
    public void pointsAddedIfTableEmptied() { 
        
    }

    @Test
    public void chosenCardPlacedToDicardpileIfWrongChoice() { 
        
    }

    @Test
    public void chosenCardPlacedToDicardpileIfWrongChoice() { 
        
    }

    @Test
    public void zeroCardsChosenPlayedCardAddedToDiscardpile() { 
        
    }
    
    @Test
    public void oneWrongCardChosenPlayedCardAddedToDiscardpile() { 
        
    }

    @Test
    public void moreThanOneWrongCardChosenPlayedCardAddedToDiscardpile() { 
        
    }

    @Test
    public void cardAdditionWorks() { 
        
    }

}