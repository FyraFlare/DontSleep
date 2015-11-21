
public class Player {
	private int x;
	
	public Player(){
		x = 550;
	}
	
	public void move(int speed){
		x += speed;
	}
	
	public int getPos(){
		return x;
	}
}
