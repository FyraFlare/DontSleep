package Items;


import java.awt.Point;

public class Item {
	int x, y;
	int w, h;
	int val;
	
	public Item(int value, int width, int height){
		val = value;
		x = 0;
		y = 0;
		w = width;
		h = height;
	}
	
	public int getValue(){
		return val;
	}
	
	public Point getPosition(){
		return new Point(x,y);
	}
	
	public void fall(int dist){
		y = y+dist;
	}
	
	public void setX(int xPosition){
		x = xPosition;
	}
	
	public int getHeight(){
		return h;
	}
	
	public int getWidth(){
		return w;
	}
}
