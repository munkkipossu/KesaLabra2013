/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame;

public class cuarentaLogic {

    
    /*
     * The game is played as follows:
     * 
     * Win condition: 40 point
     *  -Rounds are played until win condition is reached
     * 
     * Round:
     * 1) 5 cards are dealt to both players from the deck
     * 2) Play the game
     *  - As in most games, the player not 'dealing' goes first
     *  - Dealers is swapped every round
     * 3) Repeat 1&2 until deck is no more
     *  - If one player gets to 38 points, special rules come into play
     * 4) Points are counted. Check win condition.
     * 5) If no one win, deal new round.
     * 
     */

    
    public boolean checkWinCondition(Player player){
        return player.getPoints() == 40;
    }
    
}
