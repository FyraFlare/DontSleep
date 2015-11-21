import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

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
	Random rand;
	
	public Game(){
		caf = 10;
		player = 550;
		points = 0;
		lvl = 1;
		items = new ArrayList<Item>();
		speed = 5;
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
			if(p.y > PlAYER_Y - h && p.y < PlAYER_Y + IMG_SIZE && p.x > player - w && p.x < player + IMG_SIZE){
				points += items.get(i).getValue();
				rem.add(i);
			}
			else if(p.y > PlAYER_Y + IMG_SIZE){
				rem.add(i);
			}
		}
		for(int i = 0; i < rem.size(); i++){
			items.remove(rem.get(i));
		}
		int check = rand.nextInt(100);
		if(check < 2){
			//TODO pick item type
			Item temp = new Item(5, check, IMG_SIZE, IMG_SIZE);
			check = rand.nextInt(1200-temp.getWidth());
			items.add(temp);
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
