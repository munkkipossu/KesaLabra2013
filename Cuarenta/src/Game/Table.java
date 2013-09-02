
package Game;

/**
 * Table is a 'CardHolder' that knows which card was last played.
 * For now, this is enough to make it it's own class, but we'll see
 * if I come up with more things for it to do.
 * 
 * @author tolaakso
 */
public class Table extends CardHolder{
    
    private Card lastCardPlayed;
    
    public Table(){
        super();
        this.lastCardPlayed = null;
    }

    public Card getLastCardPlayed(){
        return this.lastCardPlayed;
    }
    
    public void addCard(Card card){
        this.lastCardPlayed = card;
        super.addCard(card);
    }
    
    public Card takeCard(int whichCard){
        Card card = super.getCard(whichCard);
        super.removeCard(card);
        
        if(this.lastCardPlayed.equals(card)){
            this.lastCardPlayed = null;
        }
        return card;
    }
    
    
}
