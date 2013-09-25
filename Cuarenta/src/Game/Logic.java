
package Game;
import java.util.ArrayList;

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
        
    public static void prepareGame(CuarentaGame game){
       game.dealCards();
    }
       
    public static void humanMove(CuarentaGame game, Card playedCard, ArrayList<Card> chosenCards){
        
        // The number of cards chosen from the table determines what is done
        
        switch(chosenCards.size()){
            case 0: noCardsChosen(game, playedCard);
                    break;
            case 1: oneCardChosen(game, playedCard, chosenCards.get(0));
                    break;
            default: generalAction(game, playedCard, chosenCards);
        }
        
    }
    
    private static void noCardsChosen(CuarentaGame game, Card playedCard){
        if(game.getTable().getLastCardPlayed().equalsSameNumber(playedCard)){
            caida(game.getHumanPlayer());
            game.getHumanPlayer().addToDiscardPile(playedCard);
            game.getHumanPlayer().addToDiscardPile(game.getTable().takeCard(game.getTable().getLastCardPlayed()));
        }
        else{
            game.getTable().addCard(playedCard);
            game.getHumanHand().removeCard(playedCard);
        }
        
    }
        
    private static void caida(Player player){
        player.addPoints(2);
    }
    
    private static void oneCardChosen(CuarentaGame game, Card playedCard, Card chosenCard){
        return;
        
        
        /*
        
                else if(chosenCards.size()==1){
            if(playedCard.sameNumber(chosenCards.get(0))){
                if(chosenCards.get(0).equals(game.lastCardPlayed())){
                    game.getHumanPlayer().addPoints(2);
                }
                game.getHumanPlayer().addToDiscardPile(game.getHumanHand().removeCard(playedCard));
                game.getHumanPlayer().addToDiscardPile(game.getTable().removeCard(chosenCards.get(0)));
                if(game.getTable().numberOfCards()==0){
                    game.getHumanPlayer().addPoints(2);
                }
            }
            else{
                game.getTable().addCard(playedCard);
                game.getHumanHand().removeCard(playedCard);
            }
            return;
        }
               */
    }
    
    private static void generalAction(CuarentaGame game, Card playedCard, ArrayList<Card> chosenCards){
        return;
    }


        /*
        else{
            for(int i=0; i<chosenCards.size(); i++){
                if(playedCard.equals(chosenCards.get(i)));
                
            }
            
            if (playedCard.getRank() < Rank.JACK){            
                for (int i = 0; i < chosenCards.size(); i++) {
                    for (int j = i + 1; j < chosenCards.size(); j++) {
                        if (playedCard.getRank < Rank.JACK) {
                            if (chosenCards[i].getRank() + chosenCards[j].getRank() == playedCard.getRank()) {
                                
                            }
                        }
                    }
                }    
            }
        }
           */
               
            // Conditions on human move
 //       if(legalMove(game.getHumanHand().getCard(playerCard), int[] tableCards, game.getTable())){
  //      }
   //     else
    //      game.getHumanPlayer().getHand().removeCard(card);
     //     game.getTable().add(card);
        

        /*
        
        // If Computer has cards, computer plays,
        if(game.getComputerPlayer().getHand().numberOfCards()>0){
       //     computerPlayCard(game);
      //      checkPoints();
        }
        
        // If human doesn't have cards anymore, computer can't either. Thus new cards are dealt
        if(game.getHumanPlayer().getHand().numberOfCards() == 0){
            if(game.getDeck().cardsLeft()>0)
                game.dealCards();
            else{   
                game.getDeck().shuffle();
                game.dealCards();
            }
                
        }
        
    }
    
    private static boolean (Card playedCard, ArrayList<Card> chosenCards){
        if(chosenCards.size()==0){
            return false;
        }
        if(choseCards.size()==1){
            if(playedCard.sameNumber(chosenCards[0])){
                return true;
            }
        }
        
        return false;
    }
    */
    public void computerPlayCard(CuarentaGame game) {
        Card lastPlayed = game.lastCardPlayed();
        for (int i = 0; i < game.getComputerPlayer().getHand().numberOfCards(); i++) {
            Card card = game.getComputerPlayer().getHand().getCard(i);
            if (card.getRank() == lastPlayed.getRank());
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
     
    public static void checkWinCondition(Player player){
        if(player.getPoints() >= 40){
            game.endGame(player);
        }
    }
    
}
