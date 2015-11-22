package Model;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import Items.*;

public class Game extends Observable {
	public static int BAR_WIDTH = 69;
	private ArrayList<Item> items;
	private ArrayList<Splatter> spils;
	private Upgrade[] upgrades;
	private Random rand;
	private Player player;
	private int gifts;
	private int lvl;
	private int caf;
	private int counter;
	private int move;

	public Game() {
		rand = new Random();
		reset();
	}

	public int updateGame(){
		int speed = lvl * 2;
		if(move == 1){
			player.move(true);
		}
		else if(move == 2){
			player.move(false);
		}
		ArrayList<Item> rem = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			items.get(i).fall(speed);
			Point p = items.get(i).getPosition();
			int h = items.get(i).getHeight();
			int w = items.get(i).getWidth();
			if (p.y > Player.PLAYER_Y - h && p.y < Player.PLAYER_Y + Player.P_HEIGHT && p.x > player.getX() - w
					&& p.x < player.getX() + Player.P_WIDTH) {
				if(items.get(i) instanceof Gift){
					gifts++;
				}
				int temp = items.get(i).getValue();
				caf += temp * (7 - lvl);
				rem.add(items.get(i));
			} else if (p.y > Player.PLAYER_Y + Player.P_HEIGHT) {
				rem.add(items.get(i));
				if(items.get(i).getValue() > 1 && rand.nextInt(2) < 1){
					spils.add(new Splatter(rand.nextInt(3)));
				}
			}
		}
		for (int i = 0; i < rem.size(); i++) {
			items.remove(rem.get(i));
		}
		ArrayList<Splatter> clean = new ArrayList<Splatter>();
		for (int i = 0; i < spils.size(); i++) {
			if(spils.get(i).countdown()){
				clean.add(spils.get(i));
			}
		}
		for (int i = 0; i < clean.size(); i++) {
			spils.remove(clean.get(i));
		}
		genItem();
		counter++;
		if (counter > 12) {
			int temp = 1 + lvl - player.getAwake();
			if(temp < 1){
				temp = 1;
			}
			caf-= temp;
			counter = 0;
			if (caf < 1) {
				return -1;
			}
			if (caf >= 737){
				nextlvl();
				if(lvl > 6){
					return 2;
				}
				return 1;
			}
		}
		this.setChanged();
		this.notifyObservers();
		return 0;
	}
	
	private void nextlvl(){
		lvl++;
		caf = 70 + player.getCafBoost();
		counter = 0;
		move = 0;
		items = new ArrayList<Item>();
		spils = new ArrayList<Splatter>();
		Item temp = new Coffee();
		int check = rand.nextInt(1200 - temp.getWidth() - BAR_WIDTH);
		temp.setX(check + BAR_WIDTH);
		items.add(temp);
	}
	
	private void genItem(){
		int check = rand.nextInt(100);
		if (check < 2 || items.isEmpty()) {
			Item temp;
			check = rand.nextInt(100);
			if (check < 5) {
				temp = new Gift();
			}
			else if(upgrades[4].maxed() && check < 10){
				temp = new Press();
			}
			else if(upgrades[3].maxed() && check < 15){
				temp = new Mug();
			}
			else if(lvl > 5 && check > 95){
				temp = new Text();
			}
			else if(lvl > 1 && check > 85){
				temp = new Blanket();
			}
			else if(lvl > 3 && check > 80){
				temp = new Cap();
			}
			else if(lvl > 2 && check > 70){
				temp = new Lullaby();
			}
			else if(lvl > 4 && check > 65){
				temp = new Paper();
			}
			else if (check > 55) {
				temp = new Pillow();
			}
			else if(lvl > 5 && check > 50){
				temp = new Cream();
			}
			else if(lvl > 3 && check > 45){
				temp = new Soda();
			}
			else if(lvl > 4 && check > 40){
				temp = new Chocolate();
			}
			else if(lvl > 1 && check > 35){
				temp = new Tea();
			}
			else if(lvl > 2 && check > 25){
				temp = new Sugar();
			}
			else {
				temp = new Coffee();
			}
			check = rand.nextInt(1200 - temp.getWidth() - BAR_WIDTH);
			temp.setX(check + BAR_WIDTH);
			items.add(temp);
		}
	}
	
	private void setUpgrades(){
		upgrades = new Upgrade[5];
		upgrades[0] = new Upgrade(4, 3);
		upgrades[1] = new Upgrade(4, 4);
		upgrades[2] = new Upgrade(4, 4);
		upgrades[3] = new Upgrade(1, 5);
		upgrades[4] = new Upgrade(1, 10);
	}
	
	public void buy(int b){
		int temp = upgrades[b].buy(gifts);
		if(b < 3 && temp < gifts){
			player.upgrade(b);
		}
		gifts = temp;
	}
	
	public void reset() {
		player = new Player();
		gifts = 0;
		lvl = 0;
		nextlvl();
		setUpgrades();
	}

	public void move(int m) {
		move = m;
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
	
	public ArrayList<Splatter> getSpils() {
		return spils;
	}
	
	public int getGifts(){
		return gifts;
	}
	
	public boolean maxed(int upgrade){
		return upgrades[upgrade].maxed();
	}
	
	public int uCost(int upgrade){
		return upgrades[upgrade].cost();
	}
	
	public int getlvl(){
		return lvl;
	}
}
