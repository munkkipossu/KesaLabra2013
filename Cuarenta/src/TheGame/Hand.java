
package TheGame;

/**
 * For now, it is simply a 'CardHolder' earlier I was thinking
 * of creating additional properties for it, but if those don't
 * work out, I'll just refactor it away.
 * 
 * @author tolaakso
 */
public class Hand extends CardHolder{
    public boolean containsSameNumber(Card card){
        for(int i=0; i<this.numberOfCards(); i++){
            if(this.getCard(i).getRank() == card.getRank());
                return true;
        }
        return false;
    }
    
}
