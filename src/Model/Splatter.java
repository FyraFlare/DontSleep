package Model;

public class Splatter {
	private int counter;
	private int type;
	
	public Splatter(int pattern){
		counter = 80;
		type = pattern;
	}
	
	public boolean countdown(){
		counter--;
		if(counter > 0){
			return false;
		}
		return true;
	}
	
	public int getType(){
		return type;
	}
}
