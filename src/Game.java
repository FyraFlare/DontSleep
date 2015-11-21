import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

import Items.Item;

public class Game extends Observable{
	int caf;
	int player;
	int points;
	int lvl;
	ArrayList<Item> items;
	private static final int IMG_SIZE = 50;
	public static final int PlAYER_Y = 700;
	int speed;
	
	public Game(){
		caf = 10;
		player = 550;
		points = 0;
		lvl = 1;
		items = new ArrayList<Item>();
		speed = 5;
	}
	
	public void updateGame(){
		int speed = lvl*5;
		//TODO generate items
		ArrayList<Integer> rem = new ArrayList<Integer>();
		for(int i = 0; i < items.size(); i++){
			items.get(i).fall(speed);
			Point p = items.get(i).getPosition();
			if(p.y > PlAYER_Y - IMG_SIZE && p.y < PlAYER_Y + IMG_SIZE && p.x > player - IMG_SIZE && p.x < player + IMG_SIZE){
				points += items.get(i).getValue();
				rem.add(i);
			}
		}
		for(int i = 0; i < rem.size(); i++){
			items.remove(rem.get(i));
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void move(boolean left){
		int move = speed;
		if(left){
			move = -move;
		}
		player += move;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getPlayer(){
		return player;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
}
