package Model;

public class Upgrade {
	int bought;
	int max;
	int cost;
	
	public Upgrade(int most, int price){
		max = most;
		cost = price;
	}
	
	public int buy(int gifts){
		if(bought < max && cost <= gifts){
			bought++;
			return gifts-cost;
		}
		return gifts;
	}
	
	public boolean maxed(){
		if(bought < max){
			return false;
		}
		return true;
	}
}
