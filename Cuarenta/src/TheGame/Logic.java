
package TheGame;


    /**
     * The game is played as follows:
     * 
     * Win condition: 40 point
     *  -Rounds are played until win condition is reached
     * 
     * Round:
     * 1) 5 cards are dealt to both players from the shuffled deck
     * 2) Play the round
     *  - As in most games, the player not 'dealing' goes first
     *  - Dealers is swapped every round
     *  - After cards are played, count points, check win condition
     * 3) Repeat 1&2 until deck is no more
     *  
     * NOTE: If one player gets to 38 points, special rules come into play
     *
     * 4) If no one win, deal new round.
     * 
     * @author Teemu Laakso
     */


public class Logic {
    
    public void playTheGame(String name){
        CuarentaGame game = new CuarentaGame(name);
        Player human=game.getHumanPlayer();
        Player computer=game.getComputerPlayer();
        
        /*
         * NOTE: I haven't decided on the way checkin for th win condition is
         * done, so it doesn't work yet.
         */
        while(checkWinCondition(human)==false){
            if(game.getDeck().cardsLeft() == 0){
                game.emptyDiscardpiles();
                game.getDeck().shuffle();
            }
            game.dealCards();
            playRound(game);
        }
        
    }
    
    
    /*
     * NOTE: The following contains some thoughts on how a round should be
     * coded, it is not yet complete
     */
    
    public void playRound(CuarentaGame game){
        Player human = game.getHumanPlayer();
        Player computer = game.getComputerPlayer();
        Player activePlayer;
        
        for(int i=0; i<10; i++){
            // For now, human player starts always. This isn't quite intended, but not important right now
            if(i%2==0)
                activePlayer = human;
            else
                activePlayer = computer;
            // choose a card to play
            
            // choose next actions
            
            // add points accordingly

            // check win condition

        }

        human.addPoints(calculatePointsFromDiscardPile(game.getHumanPlayer()));
        computer.addPoints(calculatePointsFromDiscardPile(game.getComputerPlayer()));
    }
      

    private int calculatePointsFromDiscardPile(Player player){
        int numberOfCards = player.sizeOfDiscardPile();
        if(numberOfCards<19)
            return 0;
        else if (numberOfCards%2 == 0)
            return 6 + (numberOfCards-18);
        else 
            return 7 + (numberOfCards-18);
    }
     
    public boolean checkWinCondition(Player player){
        return player.getPoints() >= 40;
    }
    
}
