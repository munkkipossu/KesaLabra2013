

package TheGame;

public class Cuarenta {

    private Player firstPlayer;
    private Player secondPlayer;
    private Deck deck;
    private Table table;
    

    public Cuarenta(String firstName, String secondName){
        this.firstPlayer = new Player(firstName);
        this.secondPlayer = new Player(secondName);
        this.deck = new Deck();
        this.table = new Table();
    }
    
    public void dealRound(){
        this.deck.dealPlayerFiveCards(firstPlayer);
        this.deck.dealPlayerFiveCards(secondPlayer);
    }
}
