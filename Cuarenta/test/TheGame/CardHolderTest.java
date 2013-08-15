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
public class CardHolderTest {
    
    public CardHolderTest() {
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
    public void CardHolderStartsOutEmpty(){
        CardHolder holder = new CardHolder();
        
        assertTrue(holder.numberOfCards() == 0);
    }
    
    @Test
    public void numberOfCardsIncreasesWhenCardsAreAdded(){
        CardHolder holder = new CardHolder();
        
        holder.addCard(new Card(Rank.KING, Suit.HEARTS));
        holder.addCard(new Card(Rank.KING, Suit.DIAMONDS));
    
        assertTrue(holder.numberOfCards() == 2);
    }
    
    @Test
    public void removingCardsDecreasesNumberOfCards(){
        CardHolder holder = new CardHolder();
        
        holder.addCard(new Card(Rank.KING, Suit.HEARTS));
        holder.addCard(new Card(Rank.KING, Suit.DIAMONDS));

        holder.removeCard(0);
        
        assertTrue(holder.numberOfCards() == 1);
    }

    @Test
    public void removingCardReturnsWantedCard_1(){
        CardHolder holder = new CardHolder();
        Card card;
        
        holder.addCard(new Card(Rank.KING, Suit.HEARTS));
        
        card = holder.removeCard(0);
        
        assertTrue(card.equals(new Card(Rank.KING, Suit.HEARTS)));
    }

    @Test
    public void removingCardReturnsWantedCard_2(){
        CardHolder holder = new CardHolder();
        Card card;
        
        holder.addCard(new Card(Rank.KING, Suit.HEARTS));
        holder.addCard(new Card(Rank.JACK, Suit.HEARTS));
        
        card = holder.removeCard(1);
        
        assertTrue(card.equals(new Card(Rank.JACK, Suit.HEARTS)));
    }
    
    @Test
    public void askingForMoreCardsThanExistResultsInNull(){
                CardHolder holder = new CardHolder();
        Card card;
        
        holder.addCard(new Card(Rank.KING, Suit.HEARTS));
        holder.addCard(new Card(Rank.JACK, Suit.HEARTS));
        
        card = holder.removeCard(5);
        
        assertTrue(card == null);
    }


}
