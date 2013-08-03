

public class Deck{
	
	private ArrayList<Card> card;

	public Deck(){
		this.card = new Arraylist<>();
		for(Rank rank : Rank.values()){
			for(Suit suit : Suit.values()){
				this.card.add(new Card(rank, suit));
			}
		}
	}

	public void shuffle(){
		this.deck = this();
	}

	public Card dealCard(void){
		chosenCard = randomInt(0,this.card.size());
		Card chosen = this.card.get(chosenCard);
		this.car.remove(chosenCard);
		return chosen;
	}
}
