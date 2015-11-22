package Model;

public class Player {
	private int x;
	public static final int PLAYER_Y = 610;
	public static final int P_WIDTH = 75;
	public static final int P_HEIGHT = 119;
	private int speed;
	private int cafBoost;
	private int awake;
	
	public Player(){
		x = 550;
		speed = 20;
		cafBoost = 0;
		awake = 0;
	}
	
	public void move(boolean left){
		int move = speed;
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
	
	public int getCafBoost(){
		return cafBoost;
	}
	
	public int getAwake(){
		return awake;
	}
}
