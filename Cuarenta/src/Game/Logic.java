
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
                    System.out.println("No cards found");
                    break;
            case 1: oneCardChosen(game, playedCard, chosenCards.get(0));
                    System.out.println("One card found");
                    break;
            default: generalAction(game, playedCard, chosenCards);
        }
        
    }
    
    private static void noCardsChosen(CuarentaGame game, Card playedCard){
        // This isn't actually in the rules of the game, just a mechanic I want in there
      //  if(sameNumberAsLastCardPlayed(game,playedCard)){
       //     caida(game.getHumanPlayer());
        //    game.getHumanPlayer().removeCard(playedCard);
         //   game.getHumanPlayer().addToDiscardPile(playedCard);
          //  game.getHumanPlayer().addToDiscardPile(game.getTable().takeCard(game.getTable().getLastCardPlayed()));
        //}
        //else{
            game.getTable().addCard(playedCard);
            game.getHumanHand().removeCard(playedCard);
        //}


    }
        
    private static void caida(Player player){
        player.addPoints(2);
    }
    
    private static boolean sameNumberAsLastCardPlayed(CuarentaGame game, Card card){
        return card.equalsSameNumber(game.getTable().getLastCardPlayed());
    }
    
    private static void oneCardChosen(CuarentaGame game, Card playedCard, Card chosenCard){
        if(playedCard.equalsSameNumber(chosenCard)){
            if(chosenCard.equals(game.getTable().getLastCardPlayed())){
                caida(game.getHumanPlayer());
            }
            game.getHumanPlayer().removeCard(playedCard);
            game.getHumanPlayer().addToDiscardPile(playedCard);
            game.getTable().removeCard(chosenCard);
            game.getHumanPlayer().addToDiscardPile(chosenCard);
        }       
        else
            game.getHumanPlayer().removeCard(playedCard);
            game.getTable().addCard(playedCard);
        return;
    }
   
    
    private static boolean containsNumber(int number, ArrayList<Card> list){
        for(int i=0;i<list.size();i++){
            if(number == list.get(i).getRank().getValue());
                return true;
        }

        return false;
    }
    
    private static boolean containsAddivelySameNumber(Card card, ArrayList<Card> list){
        // If the chosen card has a rank of 3, 4, 5, 6, or 7 it can 'added' up to
        if(card.getRank().getValue()<3 || card.getRank().getValue()>7){
            for(int i=0; i<list.size(); i++){
                for(int j=i; j<list.size(); j++){
                    if(list.get(i).getRank().getValue()+list.get(j).getRank().getValue() == card.getRank().getValue())
                        return true;
                }
            }
            return false;
        }
        else
            return false;
    }
    
    
    
    private static void generalAction(CuarentaGame game, Card playedCard, ArrayList<Card> chosenCards){
        boolean correctlyPlayedHand = true;
        if(containsNumber(playedCard.getRank().getValue(), chosenCards)){
            for(int i=1; i<chosenCards.size(); i++){
                if(containsNumber(playedCard.getRank().getValue()+i, chosenCards)==false){
                    correctlyPlayedHand=false;
                    game.getHumanPlayer().removeCard(playedCard);
                    game.getTable().addCard(playedCard);
                    break;
                }
            }
            if(correctlyPlayedHand){
                
                for(int i=0; i<chosenCards.size(); i++){
                    game.getHumanPlayer().addToDiscardPile(game.getTable().takeCard(game.getTable().getLastCardPlayed()));
                }
            }
                
        }
        else if(containsAddivelySameNumber(playedCard, chosenCards)){
            
            
        }
        
        else{
            game.getTable().addCard(playedCard);
        }
        
        return;
    }

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
            //game.endGame(player);
        }
    }
    
}
