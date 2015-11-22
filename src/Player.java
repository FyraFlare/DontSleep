
public class Player {
	private int x;
	public static final int PLAYER_Y = 610;
	public static final int P_WIDTH = 121;
	public static final int P_HEIGHT = 153;
	private int speed;
	private int cafBoost;
	private int awake;
	private int status;
	
	public Player(){
		x = 550;
		speed = 20;
		status = 0;
		cafBoost = 0;
		awake = 0;
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
		if(x < Game.BAR_WIDTH){
			x = Game.BAR_WIDTH;
		}
		else if(x > 1200 - P_WIDTH){
			x = 1200 - P_WIDTH;
		}
	}
	
	public int getX(){
		return x;
	}
	
	public void setStatus(int s){
		status = s;
	}
	
	public int getCafBoost(){
		return cafBoost;
	}
	
	public int getAwake(){
		return awake;
	}
}
