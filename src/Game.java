import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import Items.*;

public class Game extends Observable{
	int caf;
	Player player;
	int points;
	int lvl;
	ArrayList<Item> items;
	private static final int IMG_SIZE = 50;
	Random rand;
	
	public Game(){
		caf = 10;
		player = new Player();
		points = 0;
		lvl = 1;
		items = new ArrayList<Item>();
		rand = new Random();
	}
	
	public void updateGame(){
		int speed = lvl*5;
		ArrayList<Integer> rem = new ArrayList<Integer>();
		for(int i = 0; i < items.size(); i++){
			items.get(i).fall(speed);
			Point p = items.get(i).getPosition();
			int h = items.get(i).getHeight();
			int w = items.get(i).getWidth();
			if(p.y > Player.PLAYER_Y - h && p.y < Player.PLAYER_Y + Player.P_HEIGHT && p.x > Player.P_WIDTH - w && p.x < Player.P_WIDTH + IMG_SIZE){
				points += items.get(i).getValue();
				rem.add(i);
			}
			else if(p.y > Player.PLAYER_Y + Player.P_HEIGHT){
				rem.add(i);
			}
		}
		for(int i = 0; i < rem.size(); i++){
			items.remove(rem.get(i));
		}
		int check = rand.nextInt(100);
		if(check < 3){
			Item temp;
			if(check >0){
				temp = new Coffee();
			}
			else{
				temp = new Pillow();
			}
			check = rand.nextInt(1200-temp.getWidth());
			temp.setX(check);
			items.add(temp);
		}
		caf--;
		if(caf < 1){
			//TODO you lose
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void move(boolean left){
		player.move(left);
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getPlayerX(){
		return player.getX();
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
}
