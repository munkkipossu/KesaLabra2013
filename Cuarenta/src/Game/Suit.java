
package Game;

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
