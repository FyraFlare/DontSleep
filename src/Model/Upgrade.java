package Model;

public class Upgrade {
	private int bought;
	private int max;
	private int cost;
	
	public Upgrade(int most, int price){
		max = most;
		cost = price;
	}
	
	public int buy(int gifts){
		if(bought < max && cost <= gifts){
			bought++;
			cost++;
			return gifts-cost-1;
		}
		return gifts;
	}
	
	public boolean maxed(){
		if(bought < max){
			return false;
		}
		return true;
	}
	
	public int cost(){
		return cost;
	}
}
