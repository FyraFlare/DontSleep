package Items;

import java.awt.Point;

public class Item {
	int x, y;
	int val;
	String img;
	
	Item(int value, String image, int xPosition, int yPosition){
		val = value;
		img = image;
		x = xPosition;
		y = yPosition;
	}
	
	int getValue(){
		return val;
	}
	
	String getImg(){
		return img;
	}
	
	Point getPosition(){
		return new Point(x,y);
	}
	
	void fall(int dist){
		y = y-dist;
	}
}
