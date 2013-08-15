

package TheGame;

public class CuarentaGame {

    private Player firstPlayer;
    private Player secondPlayer;
    private Deck deck;
    private CardHolder table;
    

    public CuarentaGame(String firstName, String secondName){
        this.firstPlayer = new Player(firstName);
        this.secondPlayer = new Player(secondName);
        this.deck = new Deck();
        this.table = new CardHolder();
    }
    
    public void dealRound(Player player){
        this.deck.dealPlayerFiveCards(firstPlayer);
        this.deck.dealPlayerFiveCards(secondPlayer);
    }
}
