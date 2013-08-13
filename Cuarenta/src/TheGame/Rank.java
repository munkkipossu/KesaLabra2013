/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame;

/**
 *
 * @author tolaakso
 */
public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    JACK,
    QUEEN,
    KING;
    
   @Override public String toString() {
        String s = super.toString();
        return s.substring(0, 1) + s.substring(1).toLowerCase();
    }
}