

/*
 * Card is defined in a fairly self explanatory way:
 *  - Must have rank (ie. number)
 *  - Must have suit (ie. symbol)
 * 
 *  POSSIBILITIES:
 *      - should Card.java define an image to be displayed as well? I think it shall
 */


package TheGame;


public class Card {
    
    private Rank rank;
    private Suit suit;
    
    public Card(Rank rank, Suit suit){
        this.suit = suit;
        this.rank = rank;
    }
    
    public Rank getRank(){
        return this.rank;
    }
    
    public Suit getSuit(){
        return this.suit;
    }
    
    public boolean equals(Card card){
        if(this.rank.equals(card.getRank()) && this.suit.equals(card.getSuit()))
            return true;
        else
            return false;
    }

    public String toString(){
        return "" + this.getRank() + " of " + this.getSuit();
    }
    
}

