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
		ArrayList<Item> rem = new ArrayList<Item>();
		for(int i = 0; i < items.size(); i++){
			items.get(i).fall(speed);
			Point p = items.get(i).getPosition();
			int h = items.get(i).getHeight();
			int w = items.get(i).getWidth();
			if(p.y > Player.PLAYER_Y - h && p.y < Player.PLAYER_Y + Player.P_HEIGHT && p.x > player.getX() - w && p.x < player.getX() + Player.P_WIDTH){
				points += items.get(i).getValue();
				rem.add(items.get(i));
			}
			else if(p.y > Player.PLAYER_Y + Player.P_HEIGHT){
				rem.add(items.get(i));
			}
		}
		for(int i = 0; i < rem.size(); i++){
			items.remove(rem.get(i));
		}
		int check = rand.nextInt(100);
		if(check < 10){
			Item temp;
			if(check >7){
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
