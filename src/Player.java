
public class Player {
	private int x;
	public static final int PLAYER_Y = 700;
	public static final int P_WIDTH = 50;
	public static final int P_HEIGHT = 50;
	private int speed;
	private int status;
	
	public Player(){
		x = 550;
		speed = 10;
		status = 0;
	}
	
	public void move(boolean left){
		int move = speed;
		if(status == 1){
			move -= 3;
		}
		else if(status == 2){
			move = -move;
		}
		else if(status == 3){
			move = 0;
		}
		if(left){
			move = -move;
		}
		x += move;
	}
	
	public int getX(){
		return x;
	}
	
	public void setStatus(int s){
		status = s;
	}
}
