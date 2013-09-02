

package Game;
import java.util.ArrayList;


/**
 * The game itself consists of two players (human and 
 * computer), a deck of cards, and a table for holding
 * played cards. Players can play cards to table, and
 * take them. No rules or logic regarding game play is
 * defined here
 * 
 * @author Teemu Laakso
 */

public class CuarentaGame {

    private Player human;
    private Player computer;
    private Deck deck;
    private Table table; 
    private boolean humanPlaysFirst;
    

    public CuarentaGame(String firstName, boolean firstPlayer){
        this.human = new Player(firstName);
        this.computer = new Player("Computer");
        this.deck = new Deck();
        this.table = new Table();
        this.humanPlaysFirst = firstPlayer;
    }
    
    public Player getHumanPlayer(){
        return this.human;
    }
    
    public Player getComputerPlayer(){
        return this.computer;
    }
    
    public Hand getHumanHand(){
        return this.human.getHand();
    }

    public Deck getDeck(){
        return this.deck;
    }
    
    public Table getTable(){
        return this.table;
    }
    
    public void emptyDiscardpiles(){
        this.human.newDiscardpile();
        this.computer.newDiscardpile();
    }
    
    public void dealCards(){
        if(this.deck.cardsLeft()>=10){
            for(int i=0; i<5; i++){
                this.getHumanPlayer().receiveCard(this.getDeck().deal());
                this.getComputerPlayer().receiveCard(this.getDeck().deal());
            }
        }
    }
    
    public void shuffleDeck(){
        this.deck.shuffle();
    }
    
    public Card lastCardPlayed(){
        return this.table.getLastCardPlayed();
    }
    
    public boolean humanPlaysFirst(){
        return this.humanPlaysFirst;
    }
 }
