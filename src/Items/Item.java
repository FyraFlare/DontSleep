package Items;


import java.awt.Point;

public class Item {
	int x, y;
	int val;
	
	Item(int value, int xPosition, int yPosition){
		val = value;
		x = xPosition;
		y = yPosition;
	}
	
	public int getValue(){
		return val;
	}
	
	public Point getPosition(){
		return new Point(x,y);
	}
	
	public void fall(int dist){
		y = y-dist;
	}
}
