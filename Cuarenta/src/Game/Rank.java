
package Game;

public enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    JACK(8),
    QUEEN(9),
    KING(10);
    
    private int value;
    Rank(int value){
        this.value=value;
    }
            
    public int getValue(){
        return this.value;
    }
    
   @Override public String toString() {
        String s = super.toString();
        return s.substring(0, 1) + s.substring(1).toLowerCase();
    }
}