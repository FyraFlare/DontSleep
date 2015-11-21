import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import Items.*;

public class Game extends Observable {
	int caf;
	Player player;
	int points;
	int lvl;
	int counter;
	ArrayList<Item> items;
	public static int BAR_WIDTH = 69;
	Random rand;

	public Game() {
		caf = 50;
		player = new Player();
		points = 0;
		lvl = 1;
		counter = 0;
		items = new ArrayList<Item>();
		rand = new Random();
	}

	public void updateGame() {
		int speed = lvl * 10;
		ArrayList<Item> rem = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			items.get(i).fall(speed);
			Point p = items.get(i).getPosition();
			int h = items.get(i).getHeight();
			int w = items.get(i).getWidth();
			if (p.y > Player.PLAYER_Y - h && p.y < Player.PLAYER_Y + Player.P_HEIGHT && p.x > player.getX() - w
					&& p.x < player.getX() + Player.P_WIDTH) {
				caf += items.get(i).getValue();
				rem.add(items.get(i));
			} else if (p.y > Player.PLAYER_Y + Player.P_HEIGHT) {
				rem.add(items.get(i));
			}
		}
		for (int i = 0; i < rem.size(); i++) {
			items.remove(rem.get(i));
		}
		int check = rand.nextInt(100);
		if (check < 10) {
			Item temp;
			if (check > 4) {
				temp = new Coffee();
			} else {
				temp = new Pillow();
			}
			check = rand.nextInt(1200 - temp.getWidth() - BAR_WIDTH);
			temp.setX(check + BAR_WIDTH);
			items.add(temp);
		}
		counter++;
		if (counter > 20 - lvl) {
			caf--;
			counter = 0;
			if (caf < 1) {
				// TODO you lose
			}
			if (caf >= 737){
				lvl++;
				caf = 50;
			}
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void move(boolean left) {
		player.move(left);
		this.setChanged();
		this.notifyObservers();
	}

	public int getPlayerX() {
		return player.getX();
	}

	public int getCaf() {
		return caf;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
}
