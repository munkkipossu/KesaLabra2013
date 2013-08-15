

package TheGame;

public class CuarentaGame {

    private Player human;
    private Player computer;
    private Deck deck;
    private CardHolder table;
    

    public CuarentaGame(String firstName){
        this.human = new Player(firstName);
        this.computer = new Player("Computer");
        this.deck = new Deck();
        this.table = new CardHolder();
    }
    
    public Player getHumanPlayer(){
        return this.human;
    }
    
    public Player getComputerPlayer(){
        return this.computer;
    }

    public Deck getDeck(){
        return this.deck;
    }
    
    public void emptyDiscardpiles(){
        this.human.newDiscardpile();
        this.computer.newDiscardpile();
    }
    
 }
