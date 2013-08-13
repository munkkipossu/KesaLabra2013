/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGame;

/**
 *
 * @author tolaakso
 */
public enum Suit {
    HEARTS,
    DIAMONDS,
    SPADES,
    CLUBS;
    
    @Override public String toString() {
        String s = super.toString();
        return s.substring(0, 1) + s.substring(1).toLowerCase();
    }
}
