
public class Player{

	private String name;
	private Hand hand;

	public Player(){
		this("dude");
	}	

	public Player(String name){
		this.name = name;
		this.Hand = new Hand();
	}



}
